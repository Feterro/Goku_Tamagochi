package VISTA;

import LibreriaPersonajes.Apariencia.LvlImages;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.EnemigoFactory;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.EnumActividades;
import VISTA.Ambiente;
import VISTA.Controladores.Deporte;
import VISTA.Controladores.Velocidad;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Juego implements Initializable {

    private ArrayList<Pane> areas = new ArrayList<>();
    private Timeline moverse;
    private Jugador goku = Jugador.getInstance();

    @FXML
    private ImageView ambiente;

    @FXML
    private Pane banno;

    @FXML
    private Pane bodega;

    @FXML
    private Pane cancha;

    @FXML
    private Pane cultivos;

    @FXML
    private Pane cocina;

    @FXML
    private Pane comedor;

    @FXML
    private Pane cuarto;

    @FXML
    private Text edad;

    @FXML
    private Pane estados;

    @FXML
    private Pane gimnasio;

    @FXML
    private Text hora;

    @FXML
    private Pane huerto;

    @FXML
    private Text humor;

    @FXML
    private Pane jardin;

    @FXML
    private Pane mapa;

    @FXML
    private ListView<String> notificaciones;

    @FXML
    private Text numeroDias;

    @FXML
    private Pane peleas;

    @FXML
    private ImageView personajeImagen;

    @FXML
    private Pane piscina;

    @FXML
    private ImageView imagenDeportePis;

    @FXML
    private Text nombreDeportePis;

    @FXML
    private ComboBox<Deporte> deportesPisicina;

    @FXML
    private ImageView imagenDeporteCancha;

    @FXML
    private Text nombreDeporteCancha;

    @FXML
    private ComboBox<Deporte> deportesCancha;

    @FXML
    private ImageView imagenDeporteGym;

    @FXML
    private Text nombreDeporteGym;

    @FXML
    private ComboBox<Deporte> deportesGym;

    @FXML
    private ImageView imagenDeportePeleas;

    @FXML
    private Text nombreDeportePeleas;

    @FXML
    private ComboBox<Deporte> deportesPeleas;



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

    private void ponerVisible(Pane pane) throws FileNotFoundException {
        humor.setText(goku.etiquetaEstadoActual.name());
        if (pane.equals(mapa)){
            moverse.stop();
            personajeImagen.setVisible(false);
            personajeImagen.setLayoutY(420);
            estados.setVisible(false);
        }else{
            System.out.println(goku.getApariencia().getImagenPorNivelNombre(10, EnumActividades.Comer.name()));
            InputStream stream = new FileInputStream(goku.getApariencia().getImagenPorNivelNombre(goku.getNivel(), EnumActividades.Caminando.name()));
            Image image = new Image(stream);
            personajeImagen.setImage(image);
            estados.setVisible(true);
            personajeImagen.setVisible(true);
            if (pane.equals(jardin) || pane.equals(piscina) || pane.equals(cancha) || pane.equals(huerto)){
                moverPersonaje(Velocidad.RAPIDO, 1);
                personajeImagen.setLayoutX(0);
            } else if (pane.equals(gimnasio) || pane.equals(bodega)){
              personajeImagen.setLayoutX(115);
              moverPersonaje(Velocidad.RAPIDO, 2);
            }else if (pane.equals(peleas)){
                personajeImagen.setLayoutX(106);
                moverPersonaje(Velocidad.RAPIDO, 3);
            } else {
                personajeImagen.setLayoutX(235);
                moverPersonaje(Velocidad.RAPIDO, 0);
            }
        }
        for (Pane area: areas){
            if (area.equals(pane)){
                area.setVisible(true);
            }else{
                area.setVisible(false);
            }
        }
    }

    private void moverPersonaje(Velocidad vel, int edificio){
        int velocidad = 0;
        switch (vel){
            case NORMAL:
                velocidad = 25;
                break;
            case RAPIDO:
                velocidad = 10;
                break;
            case ENFERMO:
                velocidad = 50;
                break;
        }
        moverse = new Timeline(new KeyFrame(Duration.millis(velocidad), new EventHandler<ActionEvent>() {
            int pos = 2;
            @Override
            public void handle(ActionEvent actionEvent) {
                personajeImagen.setLayoutX(personajeImagen.getLayoutX() + pos);
                int bordeMax;
                int bordeMin;
                if (edificio == 0){
                    bordeMin = 235;
                    bordeMax = 875;
                }else if (edificio == 1){
                    bordeMin = 0;
                    bordeMax = (int) (1188 - personajeImagen.getFitWidth());
                } else if (edificio == 2){
                    bordeMax = (int) (1019 - personajeImagen.getFitWidth());
                    bordeMin = 115;
                } else {
                    bordeMax = (int) (1080 - personajeImagen.getFitWidth());
                    bordeMin = 106;
                }
                boolean bordeDerecho = personajeImagen.getLayoutX() == bordeMax;
                boolean bordeIzquierdo = personajeImagen.getLayoutX() == bordeMin;

                if (bordeIzquierdo || bordeDerecho)
                    pos *= -1;
            }
        }));
        moverse.setCycleCount(Animation.INDEFINITE);
        moverse.play();
    }

    private void inicializarPersonaje(){
        new EnemigoFactory();//Fabrica de personajes
        new HabilidadFactory();//Fabrica de armas

        LvlImages primerNivel = new LvlImages();
        primerNivel.addApariencia(EnumActividades.Atacar.name(), "src/VISTA/Imagenes/Personaje/ataque_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Caminando.name(), "src/VISTA/Imagenes/Personaje/caminando_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Enfermo.name(), "src/VISTA/Imagenes/Personaje/caminandoEnfermo_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Comer.name(), "src/VISTA/Imagenes/Personaje/comiendo_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Mimir.name(), "src/VISTA/Imagenes/Personaje/dormir_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Ejercitar.name(), "src/VISTA/Imagenes/Personaje/ejercicio_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Normal.name(), "src/VISTA/Imagenes/Personaje/estarQuietoEnfermo_nivel1.png");

        LvlImages segundoNivel = new LvlImages();
        segundoNivel.addApariencia(EnumActividades.Atacar.name(), "src/VISTA/Imagenes/Personaje/ataque_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Caminando.name(), "src/VISTA/Imagenes/Personaje/caminando_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Enfermo.name(), "src/VISTA/Imagenes/Personaje/caminandoEnfermo_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Comer.name(), "src/VISTA/Imagenes/Personaje/comiendo_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Mimir.name(), "src/VISTA/Imagenes/Personaje/dormir_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Ejercitar.name(), "src/VISTA/Imagenes/Personaje/ejercicio_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Normal.name(), "src/VISTA/Imagenes/Personaje/estarQuietoEnfermo_nivel2.png");

        LvlImages tercerNivel = new LvlImages();
        tercerNivel.addApariencia(EnumActividades.Atacar.name(), "src/VISTA/Imagenes/Personaje/ataque_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Caminando.name(), "src/VISTA/Imagenes/Personaje/caminando_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Enfermo.name(), "src/VISTA/Imagenes/Personaje/caminandoEnfermo_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Comer.name(), "src/VISTA/Imagenes/Personaje/comiendo_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Mimir.name(), "src/VISTA/Imagenes/Personaje/dormir_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Ejercitar.name(), "src/VISTA/Imagenes/Personaje/ejercicio_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Normal.name(), "src/VISTA/Imagenes/Personaje/estarQuietoEnfermo_nivel3.png");

        goku = new Jugador(new Personaje.BuilderPersonaje().setNombre("Goku")
                .addApariencia(0, primerNivel)
                .addApariencia(10, segundoNivel)
                .addApariencia(30, tercerNivel)
                .setVida(500).addArma(HabilidadFactory.getHabilidad("Karate")).build());
    }

    @FXML
    public void cerrar(MouseEvent event){
        //agregar ventana de preguntar
        System.exit(1);
    }

    @FXML
    public void mostrarMapa(MouseEvent event) throws FileNotFoundException {
        ponerVisible(mapa);
    }

    @FXML
    void irBaño(ActionEvent event) throws FileNotFoundException {
        ponerVisible(banno);
    }

    @FXML
    void irBodega(ActionEvent event) throws FileNotFoundException {
        ponerVisible(bodega);
    }

    @FXML
    void irCanchaFutbol(ActionEvent event) throws FileNotFoundException {
        ponerVisible(cancha);
    }

    @FXML
    void irCocina(ActionEvent event) throws FileNotFoundException {
        ponerVisible(cocina);
    }

    @FXML
    void irComedor(ActionEvent event) throws FileNotFoundException {
        ponerVisible(comedor);
    }

    @FXML
    void irCuarto(ActionEvent event) throws FileNotFoundException {
        ponerVisible(cuarto);
    }

    @FXML
    void irGinmasio(ActionEvent event) throws FileNotFoundException {
        ponerVisible(gimnasio);
    }

    @FXML
    void irHuerto(ActionEvent event) throws FileNotFoundException {
        ponerVisible(huerto);
    }

    @FXML
    void irPeleas(ActionEvent event) throws FileNotFoundException {
        ponerVisible(peleas);
    }

    @FXML
    void irPiscina(ActionEvent event) throws FileNotFoundException {
        ponerVisible(piscina);
    }

    @FXML
    void irjardin(ActionEvent event) throws FileNotFoundException {
        ponerVisible(jardin);
    }

    @FXML
    public void moverAquiXY(MouseEvent event){
        moverse.stop();
        personajeImagen.setLayoutX(event.getSceneX());
        personajeImagen.setLayoutY(event.getSceneY()-personajeImagen.getFitHeight());
    }

    @FXML
    public void moverAquiX(MouseEvent event){
        moverse.stop();
        personajeImagen.setLayoutX(event.getSceneX());
    }

    @FXML
    public void comer(ActionEvent event) {

    }

    @FXML
    public void hacerDeportePis(ActionEvent event) throws FileNotFoundException {
        Deporte deporte = deportesPisicina.getSelectionModel().getSelectedItem();
        if (deporte != null){
//            String path = ""; //ruta imagen
//            InputStream stream = new FileInputStream(path);
//            Image image = new Image(stream);
//            imagenDeportePis.setImage(image);
            //jugar
            nombreDeportePis.setText(deporte.name());
        }

    }

    @FXML
    public void hacerDeporteCancha(ActionEvent event) throws FileNotFoundException {
        Deporte deporte = deportesCancha.getSelectionModel().getSelectedItem();
        if (deporte != null){
//            String path = ""; //ruta imagen
//            InputStream stream = new FileInputStream(path);
//            Image image = new Image(stream);
//            imagenDeporteCancha.setImage(image);
            //jugar
            nombreDeporteCancha.setText(deporte.name());
        }

    }

    @FXML
    public void hacerDeporteGym(ActionEvent event) throws FileNotFoundException {
        Deporte deporte = deportesGym.getSelectionModel().getSelectedItem();
        if (deporte != null){
//            String path = ""; //ruta imagen
//            InputStream stream = new FileInputStream(path);
//            Image image = new Image(stream);
//            imagenDeporteGym.setImage(image);
            //jugar
            nombreDeporteGym.setText(deporte.name());
        }
    }

    @FXML
    public void hacerDeportePeleas(ActionEvent event) throws FileNotFoundException {
        Deporte deporte = deportesPeleas.getSelectionModel().getSelectedItem();
        if (deporte != null){
//            String path = ""; //ruta imagen
//            InputStream stream = new FileInputStream(path);
//            Image image = new Image(stream);
//            imagenDeportePeleas.setImage(image);
            //jugar
            nombreDeportePeleas.setText(deporte.name());
        }
    }

    @FXML
    public void pelear(ActionEvent event) {

    }

    @FXML
    public void defecar(ActionEvent event) {

    }

    @FXML
    public void dormir(ActionEvent event) {

    }

    @FXML
    public void orinar(ActionEvent event) {

    }

    @FXML
    public void recogerCultivos(ActionEvent event){
        cultivos.setVisible(false);
        moverse.stop();
        notificaciones.getItems().remove(notificaciones.getItems().get(notificaciones.getItems().size()-1));
        notificaciones.getItems().add("Los cultivos fueron recogidos!".toUpperCase(Locale.ROOT));
    }

    @FXML
    public void verInventario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/Inventario.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarPersonaje();
        edad.setText(String.valueOf(goku.getNivel()));
        deportesPisicina.setItems(FXCollections.observableArrayList(Deporte.values()));
        deportesCancha.setItems(FXCollections.observableArrayList(Deporte.values()));
        personajeImagen.setVisible(false);
        meterALista();
        notificaciones.getItems().add("");
        try {
            cambiarAmbiente(Ambiente.NOCHE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
