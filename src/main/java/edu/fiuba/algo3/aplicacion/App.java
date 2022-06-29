package edu.fiuba.algo3.aplicacion;

import edu.fiuba.algo3.aplicacion.Eventos.*;
import edu.fiuba.algo3.aplicacion.Vista.CasilleroView;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private Juego juego;
    private List<Jugador> jugadores;

    private double width = 500;
    private double height = 500;

    public static final int MEDIDA_CASILLERO = 50;

    private CasilleroView[][] tableroView = new CasilleroView[(int) width][(int) height];

    private Group casillerosView = new Group();

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(mostrarTablero());
        stage.setScene(scene);
        stage.show();

        this.stage = stage;

        stage.setTitle("Juego GPS");
        StackPane layout = new StackPane();
        Label titulo = new Label();
        Label integrantes = new Label();

        Button comenzar = new Button("Comenzar");
        Button salir = new Button("Salir");

        comenzar.defaultButtonProperty().bind(comenzar.focusedProperty());
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        BotonSalirEvento botonSalirEvento = new BotonSalirEvento();
        salir.setOnAction(botonSalirEvento);
/*
        BotonComenzarEvento botonComenzarEvento = new BotonComenzarEvento(this);
        comenzar.setOnAction(botonComenzarEvento);


 */

        titulo.setText("GPS Juego - Algo3");
        integrantes.setText("Integrantes:\n" + "Cristian Martin Lin\n" + "Martin Alejo Polese\n" + "Tomas Nahuel Olivera\n" + "Jorge Sedek\n" );

        StackPane.setAlignment(titulo, Pos.TOP_CENTER);
        StackPane.setAlignment(integrantes, Pos.BOTTOM_LEFT);

        HBox botonera = new HBox(comenzar, salir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(10);

        VBox contenedorPrincipal = new VBox(botonera);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        layout.setPrefHeight(400);
        layout.setPrefWidth(500);
        layout.getChildren().addAll(integrantes, titulo, contenedorPrincipal);
        layout.setPadding(new Insets(10));

        //var scene = new Scene(layout);
        //scene.getStylesheets().add("css/pantalla_inicio_fondo.css");
        /*Background bi = new Background(new BackgroundImage(new Image("gps-fondo.jpg"),
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(width, height, false, false, false, false)));*/
        stage.setScene(scene);
        stage.show();
    }

    public void elegirCantidadJugadores(){
        StackPane layout = new StackPane();
        Button aceptar = new Button("Aceptar");
        Label pedirCantJugadores = new Label();

        pedirCantJugadores.setText("Seleccione la cantidad de jugadores: ");
        StackPane.setAlignment(pedirCantJugadores, Pos.TOP_CENTER);

        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().add(1);
        choiceBox.getItems().add(2);
        choiceBox.getItems().add(3);
        //choiceBox.getItems().addAll(1,2,3);

        //aceptar.setOnAction(e -> getChoice(choiceBox));

        BotonAceptarEvento accept = new BotonAceptarEvento(this, choiceBox);
        aceptar.setOnAction(accept);

        StackPane.setAlignment(choiceBox, Pos.CENTER);
        StackPane.setAlignment(aceptar, Pos.CENTER);

        VBox contenedor = new VBox(pedirCantJugadores, choiceBox, aceptar);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);

        Button salir = new Button("Salir");
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        layout.getChildren().addAll(contenedor, salir);
        layout.setPadding(new Insets(10));

        StackPane.setAlignment(salir, Pos.BOTTOM_LEFT);
        layout.setPrefHeight(400);
        layout.setPrefWidth(500);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
    }

    private Parent mostrarTablero(){
        int filas = 5;
        int columnas = 9;
        Pane root = new Pane();
        root.setPrefSize(filas * MEDIDA_CASILLERO - (1 - (filas % 2)) * MEDIDA_CASILLERO , columnas * MEDIDA_CASILLERO - (1 - (columnas % 2)) * MEDIDA_CASILLERO);
        root.getChildren().addAll(casillerosView);

        for (int y = 0; y < columnas; y = y + 2) {
            for (int x = 0; x < filas; x = x + 2) {
                CasilleroView casillero = new CasilleroView( x, y);
                tableroView[x][y] = casillero;

                casillerosView.getChildren().add(casillero);

            }
        }

        return root;
    }


    public void getChoice(ChoiceBox<Integer> choiceBox) {
        int cant_jugadores = choiceBox.getValue();
        System.out.println(cant_jugadores);
    }

    public Stage getStage(){
        return this.stage;
    }

    public static void main(String[] args) {
        launch();
    }

}