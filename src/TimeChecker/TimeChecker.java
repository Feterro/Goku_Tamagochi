package TimeChecker;

import ModuloPelea.ModuloPersonajes.ControladorPelea;
import ModuloPelea.ModuloPersonajes.Enemigo;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.EnumActividades;
import VISTA.Ambiente;
import javafx.application.Platform;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class TimeChecker extends Thread implements Serializable {
    public boolean visitando = false;
    // Configuración del tiempo
    private int segundo; //En milisegundos.
    private int diaActual = 0;
    private int anioActual = 0;
    private Reloj reloj;
    private Logger logger = new Logger();
    public int cantpeleas = 0;
    public int cantVisitas = 0;
    public boolean estaPeleando = false;
    private static final long serialVersionUID = 1007L;

    public TimeChecker(int segundo ){
        this.segundo = segundo;
    }


    public void setReloj(int segundosMaximo, int minutosMaximo, int horasMaximo, int diasMaximo) {
        this.reloj = new Reloj(segundosMaximo, minutosMaximo, horasMaximo, diasMaximo);
    }

    public Reloj getReloj() {
        return reloj;
    }

    public int getSegundo(){
        return segundo;
    }

    public TimerTask iniciarTiempo() {

        TimerTask tareaNuevoSegundo = new TimerTask() {
            @Override
            public void run() {
                if (cantpeleas < 2 && !estaPeleando && !visitando) {
                    int crear = ThreadLocalRandom.current().nextInt(0, 50);
                    if (crear == 5) {
                        ((ControladorPelea) Jugador.getInstance().controladores.get(EnumActividades.Pelear)).crearEnemigo();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Jugador.getInstance().partida.getJuego().notificacionPelea();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                }
                if (cantVisitas < 2 && !visitando && !estaPeleando){
                    int crear = ThreadLocalRandom.current().nextInt(0, 50);
                    if (crear == 7) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Jugador.getInstance().partida.getJuego().notificacionSocializar();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                }
                int dia = reloj.aumentar(); // Aumenta un segundo.
                if (dia != diaActual){
                    String partidaSerializada =  logger.serializarObjeto(Jugador.getInstance());
                    logger.guardarDia(diaActual, reloj.getAnios(), "src/TimeChecker/Dias/", partidaSerializada);
                    logger.saveJson("src/TimeChecker/Dias/dias.json");
                    diaActual = dia;
                }
                int parteDia = reloj.getHorasMaximo() / 3;
                if (reloj.getHoras() == parteDia && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    try {
                        Partida.getPartida().getJuego().cambiarAmbiente(Ambiente.MANANA);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Primera parte del día");
                }
                else if (reloj.getHoras() == parteDia * 2 && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    // Segunda parte del día
                    try {
                        Partida.getPartida().getJuego().cambiarAmbiente(Ambiente.TARDE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Segunda parte del día");
                }
                else if (reloj.getHoras() == 0 && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    // Ultima parte del día
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Partida.getPartida().getJuego().abrirNotificacionDormir();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    try {
                        Jugador.getInstance().verificarMuerte();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Jugador.getInstance().verificarMuerte();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Partida.getPartida().getJuego().cambiarAmbiente(Ambiente.NOCHE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A mimir");
                    cantpeleas = 0;
                }
                System.out.println(reloj.verHora());
                Partida.getPartida().getJuego().cambiarHoraYdias(reloj.verHora(), reloj.verFecha());
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
