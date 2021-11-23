package ModuloPelea.ModuloPersonajes;

import LibreriaPersonajes.TDA.Arma;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloComida.Comida;
import ModuloPelea.ModuloControladores.Controlador;

import java.util.HashMap;


public class Goku extends Personaje {

    private static final long serialVersionUID = 8L;

    //El nivel es la edad del personaje.
    //Las habilidades son las armas
    float velocidad;
    boolean muertePorEnfermedad;
    int cantidadDeDiasEnfermo;
    //ArrayList de estados. Es una lista el boton de la pantalla setea el estado actual que es el que se satisface o se niega.
    HashMap<String, Controlador> controladores;
    Controlador estadoActual;

    public Goku(Personaje personaje){
        super(personaje);
        controladores = new HashMap<>();
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


    //Metodos de controladores.

    //Cada uno de los controladores. Modifica el movimiento, la imagen y tinee un comportamiento asociado.
    //Set valor es solo para controladores que necesitan de un objeto para funcionar como el comer
    //El satisfacer suma en el controlador salud el negar resta en el controlador salud

    public void comer(Comida comida){
        estadoActual = controladores.get("Comer");
        estadoActual.setValor(comida);//Paso intermedio para los que necesitan de algun objeo en especifico.
        estadoActual.satisfacer();
    }


    //Metodos de verificacion


    //Cero que el crecimiento se va  a pasar con un boton.
    public void verificarEdad(int edad){
        //Cuando termina el dia entonces
        //Reviso si la cantidad de dias que han pasado valen un año
        //Numero de dias % dias por año
        this.nivel = edad;
        //this.aparienciaActual = apariencias.get(nivel,estadoActual.toString());//Apariencia pone: nivel,estadoActual
    }

    public void verificarMimir(){
        //Crear una alerta en pantalla para preguntar si quiere dormir
        boolean mimio = true;
        estadoActual = controladores.get("Dormir");
        if(mimio)
        {
            estadoActual.satisfacer();
        }
        else{
            estadoActual.negar();
        }
    }

    public void verificarMuerte(){
        if(cantidadDeDiasEnfermo >= 3){
            this.muertePorEnfermedad = true;
        }
    }


    public void restarAtributos(){//Esto creo que no se usaria.
        for(Controlador controlador:controladores.values()){
            controlador.negar();    
        }
    }

}
