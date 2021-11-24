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
        new HabilidadFactory();//Fabrica de armas
        Jugador personaje = new Jugador(new Personaje.BuilderPersonaje().setNombre("Goku").addApariencia("Goku.jpg").setVida(500).addArma(HabilidadFactory.getHabilidad("Karate")).build());
        Partida partida = new Partida();
        partida.setTimeChecker(200);
        partida.getTimeChecker().setReloj(3, 3, 6, 6);

//        partida.getTimeChecker().getReloj().getLogger().
//        TimeChecker timeChecker = new TimeChecker(1000, 5, 6, 6, 6);
//        Timer timer = new Timer();
//        timer.schedule(partida.getTimeChecker().iniciarTiempo(), 0, partida.getTimeChecker().getSegundo());
        Jugador cargado = (Jugador)partida.getTimeChecker().getLogger().buscarPartida("1-0");
        System.out.println(cargado.getNombre());

//        System.out.println(timeChecker.reloj.verHora());
    }
}
