package VISTA.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreadorConsuminles implements Initializable, DragWindow {


    @FXML
    private Pane contenedor;

    @FXML
    private ComboBox<String> cbxNombreAlimento;

    @FXML
    private ComboBox<String> cbxNombreMed;

    @FXML
    private ComboBox<String> cbxTipoAlimento; //puede cambiarlo el String por algún enum

    @FXML
    private TextField txtCantidadComidas;

    @FXML
    private TextField txtCantidadMeds;

    @FXML
    private TextField txtPtsEnergía;

    @FXML
    void crearAlimento(ActionEvent event) {

    }

    @FXML
    void crearMedicamento(ActionEvent event) {

    }

    @FXML
    public void cerrar(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onDraggedScene(contenedor);
    }
}

