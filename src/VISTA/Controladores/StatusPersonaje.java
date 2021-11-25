package VISTA.Controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StatusPersonaje implements Initializable, DragWindow {

    @FXML
    private Pane contenedor;

    @FXML
    private Text estadosPersonaje;

    @FXML
    private Text ganasDeIrAlbanno;

    @FXML
    private Text hambre;

    @FXML
    private Text liquidosConsumidos;

    @FXML
    private Text probabilidadEnfermarse;

    @FXML
    private Text saludFisica;

    @FXML
    private Text saludSocial;

    @FXML
    private Text solidosConsumidos;

    @FXML
    private Text sueno;

    @FXML
    private Text vida;

    @FXML
    void cerrar(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onDraggedScene(contenedor);
    }
}
