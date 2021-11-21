package Model;

public class Jugador {

    public static Jugador jugador = null;
    public ControladorSalud controladorSalud;

    private Jugador() {
        this.controladorSalud = new ControladorSalud();
    }

    public static Jugador getInstance(){
        if (jugador == null)
            jugador = new Jugador();

        return jugador;
    }

}
