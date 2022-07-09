package edu.fiuba.algo3.aplicacion;

import edu.fiuba.algo3.aplicacion.Eventos.BotonComenzarEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonInstruccionesEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonSalirEvento;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.modelo.General.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private MediaPlayer mediaPlayer;
    private List<Jugador> jugadores;
    private EscenarioView escenarioView;

    private List<Puntaje> puntajes = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        // Inicializacion
        Ranking.resetInstance();
        this.stage = stage;
        jugadores = new ArrayList<>();

        stage.setTitle("Juego GPS");
        StackPane layout = new StackPane();
        Label integrantes = new Label("Integrantes:\n" + "Cristian Martin Lin\n" + "Martin Alejo Polese\n" + "Tomas Nahuel Olivera\n" + "Jorge Sedek\n");
        Label titulo = new Label("GPS Juego - Algo3");

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");
        Button instrucciones = new Button("Instrucciones");

        // Propiedades, setters y musica
        comenzar.defaultButtonProperty().bind(comenzar.focusedProperty());
        salir.defaultButtonProperty().bind(salir.focusedProperty());
        instrucciones.defaultButtonProperty().bind(instrucciones.focusedProperty());

        BotonSalirEvento botonSalirEvento = new BotonSalirEvento();
        salir.setOnAction(botonSalirEvento);

        BotonComenzarEvento botonComenzarEvento = new BotonComenzarEvento(this);
        comenzar.setOnAction(botonComenzarEvento);

        BotonInstruccionesEvento botonInstruccionesEvento = new BotonInstruccionesEvento(this);
        instrucciones.setOnAction(botonInstruccionesEvento);

        StackPane.setAlignment(titulo, Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes, Pos.BOTTOM_LEFT);

        HBox botonera = new HBox(comenzar, instrucciones, salir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(10);

        VBox contenedorPrincipal = new VBox(botonera);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        layout.setPrefHeight(1080);
        layout.setPrefWidth(1920);
        layout.getChildren().addAll(contenedorPrincipal, titulo, integrantes);

        reproducirMusica();

        // Stage
        Image icon = new Image("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/imagenes/icon.png");
        stage.getIcons().add(icon);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Para salir de pantalla completa presione ESC");
        stage.centerOnScreen();
        stage.show();
    }

    public Stage getStage(){
        return this.stage;
    }

    public EscenarioView getEscenarioView(){
        return this.escenarioView;
    }

    public List<Jugador> getJugadores(){
        return this.jugadores;
    }

    public static void main(String[] args) {
        launch();
    }

    public void setFilaYColumna(int fila, int columna) {
        Escenario.resetInstance(fila,columna);
        Escenario.getInstance().agregarObjetosRandom();
    }

    public void asignarEscenario(EscenarioView escenarioView) {
        this.escenarioView = escenarioView;
    }

    public void reproducirMusica() {
        File file = new File("src/dejavu.mp3");
        Media media = new Media( file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
    }

    public MediaPlayer obtenerReproductorMusica() {
        return this.mediaPlayer;
    }

    public void agregarPuntajesJugadores() {
        List<Puntaje> puntajesJuego = Ranking.getInstance().puntajes();
        for (Puntaje puntaje : puntajesJuego) {
            this.puntajes.add(puntaje);
        }
    }

    public List<Puntaje> obtenerPuntajes() {
        Collections.sort(this.puntajes, new OrdenarPorMovimientos());
        return this.puntajes;
    }
}