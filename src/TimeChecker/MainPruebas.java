package TimeChecker;

import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.EnemigoFactory;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;
import ModuloPelea.ModuloPersonajes.Jugador;

import java.util.Timer;

public class MainPruebas {
    public static void main(String[] args) {
//        Thread.currentThread().run();
        new EnemigoFactory();//Fabrica de personajes
        Jugador personaje = new Jugador(new Personaje.BuilderPersonaje().setNombre("Goku").addApariencia("Goku.jpg").setVida(500).addArma(HabilidadFactory.getInstance().getHabilidad("Karate")).build());
        personaje.controladorSalud.setEnfermo(true);

        Partida.getPartida().setTimeChecker(50);
        Partida.getPartida().getTimeChecker().setReloj(3, 3, 6, 6);

//        partida.getTimeChecker().getReloj().getLogger().
//        TimeChecker timeChecker = new TimeChecker(1000, 5, 6, 6, 6);
        Timer timer = new Timer();
        timer.schedule(Partida.getPartida().getTimeChecker().iniciarTiempo(), 0, Partida.getPartida().getTimeChecker().getSegundo());

        Jugador cargado = (Jugador)Partida.getPartida().getTimeChecker().getLogger().buscarPartida("3-0");
        System.out.println(cargado.getNombre());
        }
}
