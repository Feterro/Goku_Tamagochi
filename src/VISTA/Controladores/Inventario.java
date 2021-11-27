package VISTA.Controladores;

import Consumibles.Bodega;
import Consumibles.EnumAlimento;
import Consumibles.EnumMedicamento;
import VISTA.Controladores.DragWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Inventario implements Initializable, DragWindow {

    @FXML
    private ListView<String> inventario;

    @FXML
    private Pane invent;

    @FXML
    void cerrar(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> articulos = new ArrayList<>();
        try {
            for (EnumMedicamento medicamento: Bodega.getInstance().getMedicamentosDisponibles()){
                articulos.add(medicamento.name());
            }
            for (EnumAlimento alimento: Bodega.bodega.getAlimentosDisponibles()){
                articulos.add(alimento.name());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        onDraggedScene(invent);
        inventario.getItems().addAll(articulos);

    }
}

