package VISTA.Controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Comida implements Initializable, DragWindow {

    @FXML
    private Pane comidas;

    @FXML
    private ListView<String> comida;

    @FXML
    public void escogerComida(MouseEvent event){
        String nombre = comida.getSelectionModel().getSelectedItem();
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
    }
}
