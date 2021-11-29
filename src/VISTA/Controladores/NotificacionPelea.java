package VISTA.Controladores;

import ModuloPelea.ModuloPersonajes.ControladorPelea;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.EnumActividades;
import VISTA.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class NotificacionPelea implements Initializable, DragWindow {

    private Juego juego;
    private Comunicador comunicador = Comunicador.getInstance();

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Juego getJuego() {
        return juego;
    }

    @FXML
    private Pane cont;

    @FXML
    void pelear(ActionEvent event) throws FileNotFoundException {
        juego.ponerVisible(juego.getPeleas(), true);
        juego.getMoverse().stop();
        juego.getPersonajeEnemigo().setVisible(true);
        juego.getPersonajeImagen().setImage(comunicador.cambiarImagenGoku(EnumActividades.Atacar));
        juego.getPersonajeImagen().setLayoutX(500);
        juego.getPersonajeImagen().setLayoutY(286);
//        System.out.println(((ControladorPelea) Jugador.getInstance().controladores.get(EnumActividades.Pelear)).getEnemigo().getApariencia().getImagenPorNivelNombre(0, "default"));
        InputStream stream = new FileInputStream("src/VISTA/Imagenes/Enemigo/enemigo1.png");
        Image image = new Image(stream);
        juego.getPersonajeEnemigo().setImage(image);
        Jugador.getInstance().partida.getTimeChecker().cantpeleas++;
        Jugador.getInstance().partida.getTimeChecker().estaPeleando = true;
        ((ControladorPelea) Jugador.getInstance().controladores.get(EnumActividades.Pelear)).peleando = true;
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void rechazar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onDraggedScene(cont);
    }
}
