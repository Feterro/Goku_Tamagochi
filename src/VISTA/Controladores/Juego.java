package VISTA.Controladores;

import VISTA.Ambiente;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Juego implements Initializable {

    private ArrayList<Pane> areas = new ArrayList<>();

    @FXML
    private ImageView ambiente;

    @FXML
    private ImageView mapaMiniatura;

    @FXML
    private Pane principal;

    @FXML
    private ListView<String> notificaciones;

    @FXML
    private Pane mapa;

    @FXML
    private Pane cocina;

    @FXML
    private Pane comedor;

    @FXML
    private Pane cuarto;

    @FXML
    private Pane banno;

    @FXML
    private Pane piscina;

    @FXML
    private Pane peleas;

    @FXML
    private Pane huerto;

    @FXML
    private Pane bodega;

    @FXML
    private Pane jardin;

    @FXML
    private Pane cancha;

    @FXML
    private Pane gimnasio;

    @FXML
    private ImageView personajeImagen;

    public void cambiarAmbiente(Ambiente ambiente) throws FileNotFoundException {
        switch (ambiente){
            case MANANA:
                ponerImagen("src/VISTA/Imagenes/Ambientes/Día.png");
                break;
            case NOCHE:
                ponerImagen("src/VISTA/Imagenes/Ambientes/noche.png");
                break;
            case TARDE:
                ponerImagen("src/VISTA/Imagenes/Ambientes/tarde.png");
                break;
        }
    }

    private void ponerImagen(String ruta) throws FileNotFoundException {
        InputStream stream = new FileInputStream(ruta);;
        Image image = new Image(stream);
        ambiente.setImage(image);
    }

    private void meterALista(){
        areas.add(cocina); areas.add(piscina); areas.add(comedor); areas.add(cuarto); areas.add(banno); areas.add(jardin);
        areas.add(gimnasio); areas.add(bodega); areas.add(huerto); areas.add(peleas); areas.add(mapa); areas.add(cancha);
    }

    private void ponerVisible(Pane pane){

        for (Pane area: areas){
            if (area.equals(pane)){
                area.setVisible(true);
            }else{
                area.setVisible(false);
            }
        }
    }

    private void moverPersonaje(){
        Timeline tiempo = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            int pos = 2;
            @Override
            public void handle(ActionEvent actionEvent) {

                System.out.println(pos);
                personajeImagen.setLayoutX(personajeImagen.getLayoutX() + pos);
                boolean bordeDerecho = personajeImagen.getLayoutX() >= (875 - personajeImagen.getFitWidth());
                boolean bordeIzquierdo = personajeImagen.getLayoutX() <= (235 + personajeImagen.getFitWidth());

//                boolean rightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
//                boolean leftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());

                if (bordeIzquierdo || bordeDerecho)
                    pos *= -1;

//                if (pos[0] == 235){
//                    izquierda = false;
//                }else if (pos[0] == 875)
//                    izquierda = true;
//                if (izquierda){
//                    pos[0]++;
//                }else{
//                    pos[0]--;
//                }
//                if (pos[0] <= 875 && pos[0] >= 235) {
//
//                }else{
//                    pos[0]--;
//                }

            }
        }));
        tiempo.setCycleCount(Animation.INDEFINITE);
        tiempo.play();
    }

    @FXML
    public void cerrar(MouseEvent event){
        //agregar ventana de preguntar
        System.exit(1);
    }

    @FXML
    public void mostrarMapa(MouseEvent event){
        ponerVisible(mapa);
    }

    @FXML
    void irBaño(ActionEvent event) {
        ponerVisible(banno);
    }

    @FXML
    void irBodega(ActionEvent event) {
        ponerVisible(bodega);
    }

    @FXML
    void irCanchaFutbol(ActionEvent event) {
        ponerVisible(cancha);
    }

    @FXML
    void irCocina(ActionEvent event) {
        ponerVisible(cocina);
    }

    @FXML
    void irComedor(ActionEvent event) {
        ponerVisible(comedor);
    }

    @FXML
    void irCuarto(ActionEvent event) {
        ponerVisible(cuarto);
    }

    @FXML
    void irGinmasio(ActionEvent event) {
        ponerVisible(gimnasio);
    }

    @FXML
    void irHuerto(ActionEvent event) {
        ponerVisible(huerto);
    }

    @FXML
    void irPeleas(ActionEvent event) {
        ponerVisible(peleas);
    }

    @FXML
    void irPiscina(ActionEvent event) {
        ponerVisible(piscina);
    }

    @FXML
    void irjardin(ActionEvent event) {
        ponerVisible(jardin);
    }

    @FXML
    public void prueba(MouseEvent event){
        moverPersonaje();
//        personajeImagen.setX(235);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        meterALista();
        notificaciones.getItems().add("HOLA");
        try {
            cambiarAmbiente(Ambiente.NOCHE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
