package VISTA.Controladores;

import Consumibles.Bodega;
import Consumibles.EnumAlimento;
import Consumibles.EnumMedicamento;
import ModuloPelea.ModuloPersonajes.Jugador;
import VISTA.Juego;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Medicinas implements Initializable, DragWindow {

    private Juego juego;

    @FXML
    private Pane comidas;

    @FXML
    private ListView<EnumMedicamento> medicinas;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @FXML
    public void escogerComida(MouseEvent event) throws IOException {
        EnumMedicamento nombre = medicinas.getSelectionModel().getSelectedItem();
        Jugador.getInstance().curar(nombre);
        medicinas.getItems().removeAll(Bodega.getInstance().getMedicamentosDisponibles());
        medicinas.getItems().addAll(Bodega.getInstance().getMedicamentosDisponibles());
        juego.cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();

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
            medicinas.getItems().addAll(Bodega.getInstance().getMedicamentosDisponibles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
