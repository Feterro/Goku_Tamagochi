package TimeChecker;

import java.util.ArrayList;

public class Partida {
    private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    private Casa casa;
    private int diaMaximo;
    private Logger logger = new Logger();
    private TimeChecker timeChecker;

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

    public int getDiaMaximo() {
        return diaMaximo;
    }

    public void setDiaMaximo(int diaMaximo) {
        this.diaMaximo = diaMaximo;
    }

    public void volverDia(String dia){
        logger.buscarPartida(dia);
    }



}
