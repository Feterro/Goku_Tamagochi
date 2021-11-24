package TimeChecker;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {
    private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    private Casa casa;
    private TimeChecker timeChecker;
    public String tex = "PRUEBA";
    private static Partida partida;

    private static final long serialVersionUID = 1004L;

    public Partida(){
       // timeChecker = new TimeChecker(this, segundo, segundosMaximo, minutosMaximo, horasMaximo, diasMaximo);

    }

//    public Partida(int segundo){
//        timeChecker = new TimeChecker(this, segundo);
//    }

    public static Partida getPartida(){
        if (partida != null){
            return partida;
        }else {
            partida = new Partida();
            return partida;
        }
    }

    public TimeChecker getTimeChecker(){
        return timeChecker;
    }

    public void setTimeChecker(int segundo){
        timeChecker = new TimeChecker(segundo);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

//    public Partida volverDia(String dia){
////        return timeChecker.getReloj().getLogger().buscarPartida(dia);
//    }

}
