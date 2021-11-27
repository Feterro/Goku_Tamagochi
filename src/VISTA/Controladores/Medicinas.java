package VISTA.Controladores;

import Consumibles.Bodega;
import Consumibles.EnumAlimento;
import Consumibles.EnumMedicamento;
import ModuloPelea.ModuloPersonajes.Jugador;
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

    @FXML
    private Pane comidas;

    @FXML
    private ListView<EnumMedicamento> medicinas;

    @FXML
    public void escogerComida(MouseEvent event) throws IOException {
        EnumMedicamento nombre = medicinas.getSelectionModel().getSelectedItem();
        Jugador.getInstance().curar(nombre);
        medicinas.getItems().removeAll(Bodega.getInstance().getMedicamentosDisponibles());
        medicinas.getItems().addAll(Bodega.getInstance().getMedicamentosDisponibles());
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
            medicinas.getItems().addAll(Bodega.getInstance().getMedicamentosDisponibles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
