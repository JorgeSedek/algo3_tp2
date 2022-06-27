package edu.fiuba.algo3.Applicacion;

import edu.fiuba.algo3.Applicacion.Eventos.BotonComenzarEvento;
import edu.fiuba.algo3.Applicacion.Eventos.BotonSalirElegirJugadoresEvent;
import edu.fiuba.algo3.Applicacion.Eventos.BotonSalirEvento;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private Juego juego;
    private List<Jugador> jugadores;

    @Override
    public void start(Stage stage) {
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

        BotonComenzarEvento botonComenzarEvento = new BotonComenzarEvento(this);
        comenzar.setOnAction(botonComenzarEvento);

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

        var scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public void elegirCantidadJugadores(){
        StackPane layout = new StackPane();
        Button salir = new Button("Salir");

        layout.getChildren().add(salir);
        layout.setPadding(new Insets(10));

        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this);
        salir.setOnAction(botonSalir);

        StackPane.setAlignment(salir, Pos.BOTTOM_LEFT);
        layout.setPrefHeight(400);
        layout.setPrefWidth(500);

        Scene scene = new Scene(layout);
        this.stage.setScene(scene);
    }

    public Stage getStage(){
        return this.stage;
    }

    public static void main(String[] args) {
        launch();
    }

}