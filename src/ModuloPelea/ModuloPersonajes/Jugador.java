package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import Model.ControladorSalud;
import Strategy.*;

import java.util.HashMap;


public class Jugador extends Personaje {

    private static final long serialVersionUID = 8L;

    //El nivel es la edad del personaje.
    //Las habilidades son las armas

    public float velocidad;
    public boolean muertePorEnfermedad;
    public int cantidadDeDiasEnfermo;
    //ArrayList de estados. Es una lista el boton de la pantalla setea el estado actual que es el que se satisface o se niega.
    public HashMap<EnumActividades, IControlerStrategy> controladores;
    public IControlerStrategy estadoActual;
    public ControladorSalud controladorSalud;
    private static Jugador jugador;
    private Object consumible;

    public Jugador (Personaje personaje){
        super(personaje);
        controladores = new HashMap<>();
        jugador = this;
    }



    public static Jugador getInstance (){
        return jugador;
    }

    public void setControladorSalud(ControladorSalud controladorSalud){
        this.controladorSalud = controladorSalud;
    }

//    public void addControlador(EnumActividades name, IControlerStrategy controlador){
//        controladores.put(name,controlador);
//    }

    public void initializeControllers(){
        controladores.put(EnumActividades.Comer, new ControladorComer());
        controladores.put(EnumActividades.Mimir, new ControladorSuenno());
        controladores.put(EnumActividades.Social, new ControladorSocial());
        controladores.put(EnumActividades.Bano, new ControladorBano());
        controladores.put(EnumActividades.Cura, new ControladorCura());
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


    public void comer(Object comida){//Todo:Cambiar a comida
        estadoActual = controladores.get(EnumActividades.Comer);
        this.consumible = comida;
        estadoActual.satisfacer();
    }

    public void bano(){
        estadoActual = controladores.get(EnumActividades.Bano);
        estadoActual.satisfacer();
    }
    
    public void curar(Object medicamento){
        estadoActual = controladores.get(EnumActividades.Cura);
        consumible = medicamento;
        estadoActual.satisfacer();
    }
    
    public void ejercitarse(){
        estadoActual = controladores.get(EnumActividades.Ejercitar);
        estadoActual.satisfacer();
    }
    
    public void social(){
        estadoActual = controladores.get(EnumActividades.Social);
        estadoActual.satisfacer();
    }

//Cero que el creciento se va  a pasar con un boton.
    public void verifarEdad(int edad){
        //Cuando termina el dia entonces
        //Reviso si la cantidad de dias que han pasado ven un año
        //Numero de dias % dias por año
        this.nivel = edad;
        //this.aparienciaActual = apariencias.get(nivel,estadoActual.toString());//Apariencia pone: nivel,estadoActual
    }

    public void verificarMimir(){
        //Crear una alerta en pantalla para preguntar si quiere dormir
        boolean mimio = true;
        estadoActual = controladores.get(EnumActividades.Mimir);
        if(mimio){
            estadoActual.satisfacer();
        }
        else{
            //estadoActual.negar();
        }
    }

    public void verificarMuerte(){
        if(cantidadDeDiasEnfermo >= 3){
            this.muertePorEnfermedad = true;
        }
    }

}
