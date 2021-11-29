package VISTA.Controladores;

import Consumibles.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreadorConsuminles implements Initializable, DragWindow {


    @FXML
    private Pane contenedor;

    @FXML
    private ComboBox<EnumAlimento> cbxNombreAlimento;

    @FXML
    private ComboBox<EnumMedicamento> cbxNombreMed;

    @FXML
    private ComboBox<EnumTipoAlimento> cbxTipoAlimento;

    @FXML
    private TextField txtCantidadComidas;

    @FXML
    private TextField txtCantidadMeds;

    @FXML
    private TextField txtPtsEnergía;

    @FXML
    void crearAlimento(ActionEvent event) throws IOException {
        int cant=  Integer.valueOf(txtCantidadComidas.getText());
        int puntos =  Integer.valueOf(txtPtsEnergía.getText());
        EnumAlimento alimento =  cbxNombreAlimento.getSelectionModel().getSelectedItem();
        EnumTipoAlimento tipo =  cbxTipoAlimento.getSelectionModel().getSelectedItem();
        Bodega.getInstance().addAlimento(alimento, new Alimento(cant, alimento,tipo,puntos));
    }

    @FXML
    void crearMedicamento(ActionEvent event) throws IOException {
        int cant = Integer.valueOf(txtCantidadMeds.getText());
        EnumMedicamento med = cbxNombreMed.getSelectionModel().getSelectedItem();
        Bodega.getInstance().addMedicamentos(med, new Medicamento(cant, med));

    }

    @FXML
    public void cerrar(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cbxNombreAlimento.setItems(FXCollections.observableArrayList(EnumAlimento.values()));
        cbxNombreMed.setItems(FXCollections.observableArrayList(EnumMedicamento.values()));
        cbxTipoAlimento.setItems(FXCollections.observableArrayList(EnumTipoAlimento.values()));
        onDraggedScene(contenedor);
    }
}

