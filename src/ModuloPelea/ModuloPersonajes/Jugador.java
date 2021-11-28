package ModuloPelea.ModuloPersonajes;

import Consumibles.*;
import Deportes.EnumDeportes;
import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import Strategy.ControladorDeporte;
import Model.ControladorSalud;
import Strategy.*;
import TimeChecker.Partida;
import TimeChecker.Reloj;
import VISTA.Controladores.Comunicador;
import VISTA.Juego;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;


public class Jugador extends Personaje implements Serializable {

    private static final long serialVersionUID = 8L;

    //El nivel es la edad del personaje.
    //Las habilidades son las armas

    public float velocidad;
    public boolean muertePorEnfermedad = true;
    public int cantidadDeDiasEnfermo;
    //ArrayList de estados. Es una lista el boton de la pantalla setea el estado actual que es el que se satisface o se niega.
    public HashMap<EnumActividades, IControlerStrategy> controladores;
    public IControlerStrategy estadoActual;
    public ControladorSalud controladorSalud;
    public EnumDeportes deporteActual;
    public EnumActividades etiquetaEstadoActual;
    private static Jugador jugador;
    public Consumible consumible;
    public Partida partida;

    public Jugador (Personaje personaje){
        super(personaje);
        this.controladores = new HashMap<>();
        initializeControllers();
        this.etiquetaEstadoActual = EnumActividades.Normal;
        this.controladorSalud = new ControladorSalud();
        jugador = this;
        partida = Partida.getPartida();
    }

    public static Jugador getInstance (){
        return jugador;
    }

    public void setControladorSalud(ControladorSalud controladorSalud){
        this.controladorSalud = controladorSalud;
    }


    public void initializeControllers(){
        controladores.put(EnumActividades.Comer, new ControladorComer());
        controladores.put(EnumActividades.Mimir, new ControladorSuenno());
        controladores.put(EnumActividades.Social, new ControladorSocial());
        controladores.put(EnumActividades.Bano, new ControladorBano());
        controladores.put(EnumActividades.Cura, new ControladorCura());
        controladores.put(EnumActividades.Deporte, new ControladorDeporte());
    }

    //Metodos de pelea.
    public void agregarHabilidad(Arma habilidad){//Usaddo por ejercicio para dar nuevas habilidades al personaje.
        //Usa el metodo de agregar arma
        armas.addArma(habilidad);
    }

    public Arma getHabilidad(String nombreHabilidad){
        return armas.getArma(nombreHabilidad);
    }

    //Intenta robar una habilidad
    public void robarHabilidad(Enemigo enemigo){
        for(Arma miHabilidad:armas.getArmas().values()){
            for(Arma habilidad:enemigo.getHabilidades()){
                if(miHabilidad.getNombre().equals(habilidad.getNombre())){
                    armas.addArma(habilidad);
                    return;
                }
            }
        }
    }

    public static void setJugador(Jugador jugador) {
        Jugador.jugador = jugador;
    }

    public void comer(EnumAlimento comida) throws IOException {
        estadoActual = controladores.get(EnumActividades.Comer);
        etiquetaEstadoActual = EnumActividades.Comer;
        this.consumible = Bodega.getInstance().getAlimento(comida);
        this.consumible.consumir();
        estadoActual.satisfacer();
    }

    public void bano(){
        estadoActual = controladores.get(EnumActividades.Bano);
        etiquetaEstadoActual = EnumActividades.Bano;
        estadoActual.satisfacer();
    }
    
    public void curar(EnumMedicamento medicamento) throws IOException {
        estadoActual = controladores.get(EnumActividades.Cura);
        etiquetaEstadoActual = EnumActividades.Cura;
        this.consumible = Bodega.getInstance().getMedicamento(medicamento);
        this.consumible.consumir();
        Bodega.getInstance().actualizarBodega();
        estadoActual.satisfacer();
    }
    
    public void ejercitarse(EnumDeportes deporteActual){
        this.deporteActual = deporteActual;
        estadoActual = controladores.get(EnumActividades.Ejercitar);
        etiquetaEstadoActual = EnumActividades.Ejercitar;
        estadoActual.satisfacer();
    }
    
    public void social(){
        estadoActual = controladores.get(EnumActividades.Social);
        etiquetaEstadoActual = EnumActividades.Social;
        estadoActual.satisfacer();
    }

//Cero que el creciento se va  a pasar con un boton.
//    public void verifarEdad(int edad){
//        //Cuando termina el dia entonces
//        //Reviso si la cantidad de dias que han pasado ven un año
//        //Numero de dias % dias por año
//        this.nivel = edad;
//        //this.aparienciaActual = apariencias.get(nivel,estadoActual.toString());//Apariencia pone: nivel,estadoActual
//    }

    public void verificarMimir(boolean mimio){

        estadoActual = controladores.get(EnumActividades.Mimir);
        if(mimio){
            estadoActual.satisfacer();
        }
        else{
            ((ControladorSuenno)estadoActual).madrugar();
        }
    }

    public void verificarMuerte() throws IOException {
        if(controladorSalud.isEnfermo())
            cantidadDeDiasEnfermo += 1;
        if(cantidadDeDiasEnfermo >= 3){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Partida.getPartida().getJuego().abrirNotificacionMorir();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void escogerReinicio(String fecha) throws FileNotFoundException {
        Juego juego = Jugador.getInstance().partida.getJuego();
        if (fecha == null){
            setJugador((Jugador) Partida.getPartida().getTimeChecker().getLogger().buscarPartida("0-0"));
        }else{
            setJugador((Jugador) Partida.getPartida().getTimeChecker().getLogger().buscarPartida(fecha));
        }
        Jugador.getInstance().partida.setJuego(juego);
        Jugador.getInstance().partida.getJuego().getPersonajeImagen().setImage(Comunicador.getInstance().cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual));
        Jugador.getInstance().partida.getJuego().getEdad().setText(String.valueOf(Jugador.getInstance().getNivel()));
        Jugador.getInstance().partida.getJuego().cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
    }

    public ControladorSalud getControladorSalud(){
        return this.controladorSalud;
    }



}
