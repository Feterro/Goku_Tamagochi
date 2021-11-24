package TimeChecker;

import ModuloPelea.ModuloPersonajes.Jugador;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class TimeChecker extends Thread implements Serializable {
    // Configuración del tiempo
    private int segundo; //En milisegundos.
    private int diaActual = 0;
    private int anioActual = 0;
    private Reloj reloj;
    private Logger logger = new Logger();
    private static final long serialVersionUID = 1007L;


    public TimeChecker(int segundo ){
        this.segundo = segundo;
    }

//    public TimeChecker(Partida partida, int segundo){
//        this.segundo = segundo;
//        reloj = new Reloj();
//    }

    public void setReloj(int segundosMaximo, int minutosMaximo, int horasMaximo, int diasMaximo) {
        this.reloj = new Reloj(segundosMaximo, minutosMaximo, horasMaximo, diasMaximo);
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
                int dia = reloj.aumentar(); // Aumenta un segundo.
                if (dia != diaActual){
                    String partidaSerializada = logger.serializarObjeto(Jugador.getInstance()); // Cambiar por Partida.
                    logger.guardarDia(diaActual, reloj.getAnios(), "src/TimeChecker/Dias/", partidaSerializada);
                    logger.saveJson("src/TimeChecker/Dias/dias.json");
                    diaActual = dia;
                }
                int parteDia = reloj.getHorasMaximo() / 3;
                if (reloj.getHoras() == parteDia && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    // primera parte del dia
                    if(reloj.getDias() == 1)
                        Jugador.getInstance().setNombre("Pepe");
                    System.out.println("Primera parte del día");
                }
                else if (reloj.getHoras() == parteDia * 2 && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    // Segunda parte del día
                    System.out.println("Segunda parte del día");
                }
                else if (reloj.getHoras() == 0 && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    // Ultima parte del día
                    System.out.println("A mimir");
                }
                System.out.println(reloj.verHora());
            }
        };
        return tareaNuevoSegundo;
    }

    public TimerTask estadoDia(){
        TimerTask estadoDelDia = new TimerTask() {
            @Override
            public void run() {
                System.out.println(reloj.verHora());
            }
        };
        return estadoDelDia;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
