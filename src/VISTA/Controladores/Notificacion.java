package VISTA.Controladores;

import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.EnumActividades;
import VISTA.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Notificacion implements Initializable, DragWindow {

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
    private Pane contMorir;

    @FXML
    private TextField fechaTF;

    @FXML
    public void reiniciar(ActionEvent event) throws FileNotFoundException {
        Jugador.getInstance().escogerReinicio(null);
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @FXML
    public void volverA(ActionEvent event) throws FileNotFoundException {
        if (!fechaTF.getText().isEmpty()) {
            Jugador.getInstance().escogerReinicio(fechaTF.getText());
            Node source = (Node) event.getSource();
            Stage stageActual = (Stage) source.getScene().getWindow();
            stageActual.close();
        }
    }

    @FXML
    public void dormir(ActionEvent event) throws FileNotFoundException {
        Jugador.getInstance().verificarMimir(true);
        juego.ponerVisible(juego.getCuarto(), true);
        juego.getPersonajeImagen().setLayoutX(680);
        juego.getPersonajeImagen().setLayoutY(400);
        juego.getPersonajeImagen().setImage(comunicador.cambiarImagenGoku(EnumActividades.Mimir));
        juego.getMoverse().stop();
        juego.cambiarHumor(EnumActividades.Mimir.name());
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @FXML
    public void trasnochar(ActionEvent event) {
        Jugador.getInstance().verificarMimir(false);
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (cont != null)
            onDraggedScene(cont);
        if (contMorir != null)
            onDraggedScene(contMorir);
    }

}
