package TimeChecker;

import java.util.Timer;

public class MainPruebas {
    public static void main(String[] args) {
//        Thread.currentThread().run();
        Partida partida = new Partida(500, 2, 2, 2, 2);
//        partida.getTimeChecker().getReloj().getLogger().
//        TimeChecker timeChecker = new TimeChecker(1000, 5, 6, 6, 6);
        Timer timer = new Timer();
        timer.schedule(partida.getTimeChecker().iniciarTiempo(), 0, partida.getTimeChecker().getSegundo());

//        System.out.println(timeChecker.reloj.verHora());
    }
}
