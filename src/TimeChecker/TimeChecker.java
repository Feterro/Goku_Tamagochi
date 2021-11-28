package TimeChecker;

import Consumibles.Bodega;
import ModuloPelea.ModuloPersonajes.Jugador;
import VISTA.Ambiente;
import VISTA.Juego;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
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
                int dia = reloj.aumentar(); // Aumenta un segundo.
                if (dia != diaActual){
                    String partidaSerializada = null; // Cambiar por Partida.
                    try {
                        partidaSerializada = logger.serializarObjeto(Bodega.getInstance().getMedicamentos());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // consumible controladores
                    logger.guardarDia(diaActual, reloj.getAnios(), "src/TimeChecker/Dias/", partidaSerializada);
                    logger.saveJson("src/TimeChecker/Dias/dias.json");
                    diaActual = dia;
                }
                int parteDia = reloj.getHorasMaximo() / 3;
                if (reloj.getHoras() == parteDia && reloj.getMinutos() == 0 && reloj.getSegundos() == 0){
                    // primera parte del dia
                    if(reloj.getDias() == 1)
                        Jugador.getInstance().setNombre("Pepe");
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
//                            try {
////                                Partida.getPartida().getJuego().abrirNotificacionDormir();
////                                Partida.getPartida().getJuego().abrirNotificacionMorir();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }

                        }
                    });
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
