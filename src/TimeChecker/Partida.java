package TimeChecker;

import java.util.ArrayList;

public class Partida {
//    private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
//    private Casa casa;
    private TimeChecker timeChecker;
    public String tex = "PRUEBA";

    public Partida(int segundo, int segundosMaximo, int minutosMaximo, int horasMaximo, int diasMaximo){
        timeChecker = new TimeChecker(this, segundo, segundosMaximo, minutosMaximo, horasMaximo, diasMaximo);
    }

    public Partida(int segundo){
        timeChecker = new TimeChecker(this, segundo);
    }

    public Partida getPartida(){
        if (this != null){
            return this;
        }
        return null;
    }

    public TimeChecker getTimeChecker(){
        return timeChecker;
    }

//    public ArrayList<Personaje> getPersonajes() {
//        return personajes;
//    }
//
//    public void setPersonajes(ArrayList<Personaje> personajes) {
//        this.personajes = personajes;
//    }
//
//    public Casa getCasa() {
//        return casa;
//    }
//
//    public void setCasa(Casa casa) {
//        this.casa = casa;
//    }

    public Partida volverDia(String dia){
        return timeChecker.getReloj().getLogger().buscarPartida(dia);
    }

}
