package VISTA;

import Consumibles.Bodega;
import Consumibles.EnumAlimento;
import ModuloPelea.ModuloPersonajes.Jugador;
import VISTA.Controladores.DragWindow;
import VISTA.Juego;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Comida implements Initializable, DragWindow {

    private Juego juego;

    @FXML
    private Pane comidas;

    @FXML
    private ListView<EnumAlimento> comida;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @FXML
    public void escogerComida(MouseEvent event) throws IOException {
        EnumAlimento nombre = comida.getSelectionModel().getSelectedItem();
        Jugador.getInstance().comer(nombre);
        comida.getItems().removeAll(Bodega.bodega.getAlimentosDisponibles());
        comida.getItems().addAll(Bodega.getInstance().getAlimentosDisponibles());
        juego.cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
//        FXMLLoader loader =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLS/juego.fxml")));
//        Juego controller = loader.getController();
//        controller.cambiarHumor(String.valueOf(Jugador.getInstance().estadoActual));
    }

    @FXML
    void cerrar(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onDraggedScene(comidas);
        try {
            comida.getItems().addAll(Bodega.getInstance().getAlimentosDisponibles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
