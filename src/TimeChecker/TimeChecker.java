package TimeChecker;

import java.util.Timer;
import java.util.TimerTask;

public class TimeChecker extends Thread{
    // Configuración del tiempo
    private int segundo; //En milisegundos.
    private Reloj reloj;


    public TimeChecker(Partida partida, int segundo, int segundosMaximo, int minutosMaximo, int horasMaximo, int diasMaximo){
        reloj = new Reloj(partida, segundosMaximo, minutosMaximo, horasMaximo, diasMaximo);
        this.segundo = segundo;
    }

    public TimeChecker(Partida partida, int segundo){
        this.segundo = segundo;
        reloj = new Reloj(partida);
    }

    public Reloj getReloj() {
        return reloj;
    }

    public int getSegundo(){
        return segundo;
    }

    public TimerTask iniciarTiempo(){
        TimerTask tareaNuevoSegundo = new TimerTask() {
            @Override
            public void run() {
                reloj.aumentar(); // Aumenta un segundo.
                System.out.println(reloj.verHora());
            }
        };
        return tareaNuevoSegundo;
    }

}
