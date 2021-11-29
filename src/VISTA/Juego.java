package VISTA;

import Consumibles.Bodega;
import Deportes.EnumDeportes;
import Deportes.SportFactory;
import LibreriaPersonajes.Apariencia.LvlImages;
import LibreriaPersonajes.TDA.Personaje;
import ModuloPelea.ModuloPersonajes.ControladorPelea;
import ModuloPelea.ModuloPersonajes.EnemigoFactory;
import ModuloPelea.ModuloPersonajes.HabilidadFactory;
import ModuloPelea.ModuloPersonajes.Jugador;
import Strategy.EnumActividades;
import VISTA.Controladores.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.*;
import TimeChecker.Partida;

public class Juego implements Initializable, Serializable {

    private ArrayList<Pane> areas = new ArrayList<>();
    private Timeline moverse;
//    private Jugador Jugador.getInstance() = Jugador.getInstance();
    private int edadGoku = 1;
    private Comunicador comunicador = Comunicador.getInstance();

    @FXML
    private Pane cargarJuego;

    @FXML
    private Pane otro;

    @FXML
    private TextField fechaJuego;

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
    public ListView<String> notificaciones;

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
    private ComboBox<EnumDeportes> deportesPisicina;

    @FXML
    private ImageView imagenDeporteCancha;

    @FXML
    private Text nombreDeporteCancha;

    @FXML
    private ComboBox<EnumDeportes> deportesCancha;

    @FXML
    private ImageView imagenDeporteGym;

    @FXML
    private Text nombreDeporteGym;

    @FXML
    private ComboBox<EnumDeportes> deportesGym;

    @FXML
    private ImageView imagenDeportePeleas;

    @FXML
    private Text nombreDeportePeleas;

    @FXML
    private ComboBox<EnumDeportes> deportesPeleas;

    @FXML
    private Button estadisticasB;

    @FXML
    private ComboBox<String> ataques;

    @FXML
    private ImageView personajeEnemigo;

    @FXML
    public ImageView personajeAmigo;

    public Pane getCuarto() {
        return cuarto;
    }

    public Pane getPeleas() {
        return peleas;
    }

    public ImageView getPersonajeImagen() {
        return personajeImagen;
    }

    public ImageView getPersonajeEnemigo() {
        return personajeEnemigo;
    }

    public Timeline getMoverse() {
        return moverse;
    }

    public void cambiarHumor(String hum){
        humor.setText(hum);
    }

    public Text getEdad() {
        return edad;
    }

    public Pane getJardin() {
        return jardin;
    }

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
        InputStream stream = new FileInputStream(ruta);
        Image image = new Image(stream);
        ambiente.setImage(image);
    }

    private void meterALista(){
        areas.add(cocina); areas.add(piscina); areas.add(comedor); areas.add(cuarto); areas.add(banno); areas.add(jardin);
        areas.add(gimnasio); areas.add(bodega); areas.add(huerto); areas.add(peleas); areas.add(mapa); areas.add(cancha);
    }

    public void ponerVisible(Pane pane, boolean dormir) throws FileNotFoundException {
        Jugador.getInstance().partida.getTimeChecker().estaPeleando = false;
        Jugador.getInstance().partida.getTimeChecker().visitando = false;
        personajeAmigo.setVisible(false);
        personajeEnemigo.setVisible(false);
        humor.setText(Jugador.getInstance().etiquetaEstadoActual.name());
        if (pane.equals(mapa)){
            moverse.stop();
            personajeImagen.setVisible(false);
            personajeImagen.setLayoutY(420);
            estados.setVisible(false);
            estadisticasB.setVisible(false);
        }else{
            ObservableList<String> fxCollections = FXCollections.observableArrayList();
            fxCollections.addAll(Jugador.getInstance().getArmas().getArmas().keySet());
            ataques.setItems(fxCollections);
            estadisticasB.setVisible(true);
            InputStream stream = new FileInputStream(Jugador.getInstance().getApariencia().getImagenPorNivelNombre(Jugador.getInstance().getNivel(), EnumActividades.Caminando.name()));
            Image image = new Image(stream);
            personajeImagen.setImage(image);
            estados.setVisible(true);
            personajeImagen.setVisible(true);
            if (pane.equals(jardin) || pane.equals(piscina) || pane.equals(cancha) || pane.equals(huerto)){
                moverPersonaje(Velocidad.NORMAL, 1);
                personajeImagen.setLayoutX(0);
                personajeImagen.setLayoutY(458);
            } else if (pane.equals(gimnasio) || pane.equals(bodega)){
              personajeImagen.setLayoutX(115);
              moverPersonaje(Velocidad.NORMAL, 2);
              personajeImagen.setLayoutY(458);
            }else if (pane.equals(peleas)){
                personajeImagen.setLayoutX(106);
                moverPersonaje(Velocidad.NORMAL, 3);
                personajeImagen.setLayoutY(458);
            } else {
                if (dormir){
                    personajeImagen.setLayoutX(235);
                    personajeImagen.setLayoutY(458);
                }else {
                    personajeImagen.setLayoutX(235);
                    moverPersonaje(Velocidad.NORMAL, 0);
                    personajeImagen.setLayoutY(458);
                }
            }
        }
        for (Pane area: areas){
            area.setVisible(area.equals(pane));
        }
    }

    public void moverPersonajesPeleaSocial(ImageView personaje){
        Timeline mover = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            int pos = 2;
            @Override
            public void handle(ActionEvent actionEvent) {
                personaje.setLayoutX(personaje.getLayoutX() + pos);
                int bordeMax = 500;
                int bordeMin = 700;

                boolean bordeDerecho = personaje.getLayoutX() == bordeMax;
                boolean bordeIzquierdo = personaje.getLayoutX() == bordeMin;

                if (bordeIzquierdo || bordeDerecho)
                    pos *= -1;
            }
        }));
        mover.setCycleCount(Animation.INDEFINITE);
        mover.play();
    }

    private void moverPersonaje(Velocidad vel, int edificio){
        if (moverse != null) moverse.stop();
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

        LvlImages primerNivel = new LvlImages();
        primerNivel.addApariencia(EnumActividades.Atacar.name(), "src/VISTA/Imagenes/Personaje/ataque_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Caminando.name(), "src/VISTA/Imagenes/Personaje/caminando_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Enfermo.name(), "src/VISTA/Imagenes/Personaje/caminandoEnfermo_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Comer.name(), "src/VISTA/Imagenes/Personaje/comiendo_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Mimir.name(), "src/VISTA/Imagenes/Personaje/dormir_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Ejercitar.name(), "src/VISTA/Imagenes/Personaje/ejercicio_nivel1.png");
        primerNivel.addApariencia(EnumActividades.Normal.name(), "src/VISTA/Imagenes/Personaje/estarQuieto_nivel1 .png");

        LvlImages segundoNivel = new LvlImages();
        segundoNivel.addApariencia(EnumActividades.Atacar.name(), "src/VISTA/Imagenes/Personaje/ataque_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Caminando.name(), "src/VISTA/Imagenes/Personaje/caminando_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Enfermo.name(), "src/VISTA/Imagenes/Personaje/caminandoEnfermo_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Comer.name(), "src/VISTA/Imagenes/Personaje/comiendo_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Mimir.name(), "src/VISTA/Imagenes/Personaje/dormir_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Ejercitar.name(), "src/VISTA/Imagenes/Personaje/ejercicio_nivel2.png");
        segundoNivel.addApariencia(EnumActividades.Normal.name(), "src/VISTA/Imagenes/Personaje/estarQuieto_nivel2.png");

        LvlImages tercerNivel = new LvlImages();
        tercerNivel.addApariencia(EnumActividades.Atacar.name(), "src/VISTA/Imagenes/Personaje/ataque_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Caminando.name(), "src/VISTA/Imagenes/Personaje/caminando_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Enfermo.name(), "src/VISTA/Imagenes/Personaje/caminandoEnfermo_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Comer.name(), "src/VISTA/Imagenes/Personaje/comiendo_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Mimir.name(), "src/VISTA/Imagenes/Personaje/dormir_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Ejercitar.name(), "src/VISTA/Imagenes/Personaje/ejercicio_nivel3.png");
        tercerNivel.addApariencia(EnumActividades.Normal.name(), "src/VISTA/Imagenes/Personaje/estarQuieto_nivel3.png");

        Jugador jugador = new Jugador(new Personaje.BuilderPersonaje().setNombre("Goku")
                .addApariencia(0, primerNivel)
                .addApariencia(10, segundoNivel)
                .addApariencia(30, tercerNivel)
                .setVida(500).build());
        Jugador.setJugador(jugador);
    }

    public void cambiarHoraYdias(String horaS, String dia){
        numeroDias.setText(dia);
        hora.setText(horaS);
    }

    public void abrirNotificacionDormir() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/notificacion.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        Notificacion not = fxmlLoader.getController();
        not.setJuego(this);
    }

    public void abrirNotificacionMorir() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/notificacionMorir.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        Notificacion not = fxmlLoader.getController();
        not.setJuego(this);
    }

    public void notificacionPelea() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/notificacionPelea.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        NotificacionPelea not = fxmlLoader.getController();
        not.setJuego(this);
    }

    public void notificacionSocializar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/notificacionSocializar.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        Notificacion not = fxmlLoader.getController();
        not.setJuego(this);
    }

    @FXML
    public void cambiarMood(MouseEvent event){
        cambiarHumor(String.valueOf(Jugador.getInstance().etiquetaEstadoActual));
    }

    @FXML
    public void cerrar(MouseEvent event){
        //agregar ventana de preguntar
        System.exit(1);
    }

    @FXML
    public void mostrarMapa(MouseEvent event) throws FileNotFoundException {
        ponerVisible(mapa, false);
    }

    @FXML
    void irBaño(ActionEvent event) throws FileNotFoundException {
        ponerVisible(banno, false);
    }

    @FXML
    void irBodega(ActionEvent event) throws FileNotFoundException {
        ponerVisible(bodega, false);
    }

    @FXML
    void irCanchaFutbol(ActionEvent event) throws FileNotFoundException {
        ponerVisible(cancha, false);
    }

    @FXML
    void irCocina(ActionEvent event) throws FileNotFoundException {
        ponerVisible(cocina, false);
    }

    @FXML
    void irComedor(ActionEvent event) throws FileNotFoundException {
        ponerVisible(comedor, false);
    }

    @FXML
    void irCuarto(ActionEvent event) throws FileNotFoundException {
        ponerVisible(cuarto, false);
    }

    @FXML
    void irGinmasio(ActionEvent event) throws FileNotFoundException {
        ponerVisible(gimnasio, false);
    }

    @FXML
    void irHuerto(ActionEvent event) throws FileNotFoundException {
        ponerVisible(huerto, false);
    }

    @FXML
    void irPeleas(ActionEvent event) throws FileNotFoundException {
        ponerVisible(peleas, false);
    }

    @FXML
    void irPiscina(ActionEvent event) throws FileNotFoundException {
        ponerVisible(piscina, false);
    }

    @FXML
    void irjardin(ActionEvent event) throws FileNotFoundException {
        ponerVisible(jardin, false);
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
    public void comer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/Comida.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

        personajeImagen.setLayoutY(353);
        personajeImagen.setLayoutX(380);
        personajeImagen.setImage(comunicador.cambiarImagenGoku(EnumActividades.Comer));
        moverse.stop();
        Comida comida = fxmlLoader.getController();
        comida.setJuego(this);
    }

    @FXML
    public void curar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/Medicinas.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        Medicinas meds = fxmlLoader.getController();
        meds.setJuego(this);
    }

    @FXML
    public void hacerDeportePis(ActionEvent event) throws FileNotFoundException {
        EnumDeportes deporte = deportesPisicina.getSelectionModel().getSelectedItem();
        if (deporte != null){
            String path = SportFactory.getInstance().getDeporte(deporte).getImagen();
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            imagenDeportePis.setImage(image);
            nombreDeportePis.setText(deporte.name());
            Jugador.getInstance().ejercitarse(deporte);
            personajeImagen.setImage(comunicador.cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual));
            cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
            moverse.stop();
            moverPersonaje(Velocidad.RAPIDO, 1);
        }
    }

    @FXML
    public void hacerDeporteCancha(ActionEvent event) throws FileNotFoundException {
        EnumDeportes deporte = deportesCancha.getSelectionModel().getSelectedItem();
        if (deporte != null){
            String path = SportFactory.getInstance().getDeporte(deporte).getImagen();
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            imagenDeporteCancha.setImage(image);
            nombreDeporteCancha.setText(deporte.name());
            Jugador.getInstance().ejercitarse(deporte);
            personajeImagen.setImage(comunicador.cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual));
            cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
            moverse.stop();
            moverPersonaje(Velocidad.RAPIDO, 1);
        }
    }

    @FXML
    public void hacerDeporteGym(ActionEvent event) throws FileNotFoundException {
        EnumDeportes deporte = deportesGym.getSelectionModel().getSelectedItem();
        if (deporte != null){
            String path = SportFactory.getInstance().getDeporte(deporte).getImagen();
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            imagenDeporteGym.setImage(image);
            nombreDeporteGym.setText(deporte.name());
            Jugador.getInstance().ejercitarse(deporte);
            personajeImagen.setImage(comunicador.cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual));
            cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
            moverse.stop();
            moverPersonaje(Velocidad.RAPIDO, 2);
        }
    }

    @FXML
    public void hacerDeportePeleas(ActionEvent event) throws FileNotFoundException {
        EnumDeportes deporte = deportesPeleas.getSelectionModel().getSelectedItem();
        if (deporte != null){
            String path = SportFactory.getInstance().getDeporte(deporte).getImagen();
            InputStream stream = new FileInputStream(path);
            Image image = new Image(stream);
            imagenDeportePeleas.setImage(image);
            nombreDeportePeleas.setText(deporte.name());
            Jugador.getInstance().ejercitarse(deporte);
            personajeImagen.setImage(comunicador.cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual));
            cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
            moverse.stop();
            moverPersonaje(Velocidad.RAPIDO, 3);
        }
    }

    @FXML
    public void pelear(ActionEvent event) throws FileNotFoundException {
        if (Jugador.getInstance().combo.size() > 0) {
            if (((ControladorPelea) Jugador.getInstance().controladores.get(EnumActividades.Pelear)).getEnemigo() != null) {
                Jugador.getInstance().pelear();
                comunicador.cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual);
                humor.setText(Jugador.getInstance().etiquetaEstadoActual.name());
            }else{
                notificaciones.getItems().add("No hay enemigos para pelear");
            }
        }else{
            notificaciones.getItems().add("Escoja habilidades para atacar");
        }
    }
    
    @FXML
    public void dormir(ActionEvent event) throws FileNotFoundException {
        moverse.stop();
        Jugador.getInstance().verificarMimir(true);
        ponerVisible(cuarto, true);
        personajeImagen.setLayoutX(680);
        personajeImagen.setLayoutY(400);
        personajeImagen.setImage(comunicador.cambiarImagenGoku(EnumActividades.Mimir));
        cambiarHumor(Jugador.getInstance().etiquetaEstadoActual.name());
    }

    @FXML
    public void irBano(ActionEvent event) throws FileNotFoundException {
        personajeImagen.setLayoutX(280);
        personajeImagen.setLayoutY(400);
        Jugador.getInstance().bano(); //preguntar después si hay que hacer algo más
        humor.setText(Jugador.getInstance().etiquetaEstadoActual.name());
        personajeImagen.setImage(comunicador.cambiarImagenGoku(Jugador.getInstance().etiquetaEstadoActual));
        moverse.stop();
        comunicador.cambiarImagenGoku(EnumActividades.Bano);
    }

    @FXML
    public void recogerCultivos(ActionEvent event) throws IOException {
        Bodega.getInstance().llenarBodega();
        //Bodega.getInstance().actualizarBodega();
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

    @FXML
    public void stats(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/statusPersonaje.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void cambiarEdad(ActionEvent event) throws FileNotFoundException {
        if (edadGoku == 3){
            edadGoku = 1;
            Jugador.getInstance().setNivel(0);
            edad.setText(String.valueOf(Jugador.getInstance().getNivel()));
            personajeImagen.setImage(comunicador.cambiarImagenGoku(EnumActividades.Caminando));
        }
        else {
            edadGoku = edadGoku + 1;
            if (edadGoku == 2){
                Jugador.getInstance().setNivel(10);
            }else{
                Jugador.getInstance().setNivel(30);
            }
            edad.setText(String.valueOf(Jugador.getInstance().getNivel()));
            personajeImagen.setImage(comunicador.cambiarImagenGoku(EnumActividades.Caminando));
        }
    }

    @FXML
    public void crearConsumible(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLS/CreadorConsuminles.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void jugar(ActionEvent event) throws FileNotFoundException {
        if (!fechaJuego.getText().isEmpty()) {
            cargarJuego.setVisible(false);
            otro.setVisible(true);
            inicializarPersonaje();
            Partida.getPartida().setJuego(this);
            Partida.getPartida().setTimeChecker(2000);
            Partida.getPartida().getTimeChecker().setReloj(3, 3, 6, 6);
            try {
                Jugador.getInstance().escogerReinicio(fechaJuego.getText());
            }catch (NullPointerException | FileNotFoundException ignored){
            }

            Timer timer = new Timer();
            timer.schedule(Partida.getPartida().getTimeChecker().iniciarTiempo(), 0, Partida.getPartida().getTimeChecker().getSegundo());
            edad.setText(String.valueOf(Jugador.getInstance().getNivel()));
            personajeImagen.setVisible(false);
            personajeImagen.setLayoutY(235);
            personajeImagen.setLayoutY(458);
            try {
                personajeImagen.setImage(comunicador.cambiarImagenGoku(EnumActividades.Caminando));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            meterALista();
            notificaciones.getItems().add("");
            try {
                cambiarAmbiente(Ambiente.MANANA);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObservableList<EnumDeportes> deportes = FXCollections.observableArrayList();
            deportes.addAll(SportFactory.getInstance().getDeportes().keySet());
            deportesPisicina.setItems(deportes);
            deportesPeleas.setItems(deportes);
            deportesCancha.setItems(deportes);
            deportesGym.setItems(deportes);
        }
    }

    @FXML
    public void agregarCombo(ActionEvent event){
        if (!ataques.getSelectionModel().getSelectedItem().isEmpty())
            Jugador.getInstance().addToCombo(Jugador.getInstance().getArmas().getArma(ataques.getSelectionModel().getSelectedItem()));
        else{
            notificaciones.getItems().add("Escoja una habilidad");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public ImageView getPersonajeAmigo() {
        return personajeAmigo;
    }
}
