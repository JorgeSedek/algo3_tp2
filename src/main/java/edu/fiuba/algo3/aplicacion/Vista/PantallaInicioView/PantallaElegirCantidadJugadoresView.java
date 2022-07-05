package edu.fiuba.algo3.aplicacion.Vista.PantallaInicioView;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Eventos.BotonAceptarEvento;
import edu.fiuba.algo3.aplicacion.Eventos.BotonSalirElegirJugadoresEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PantallaElegirCantidadJugadoresView {

    private App app;

    public PantallaElegirCantidadJugadoresView(App app){
        this.app = app;
    }

    public void elegirCantidadJugadores(){
        StackPane layout = new StackPane();
        Button aceptar = new Button("Aceptar");
        Label pedirCantJugadores = new Label();

        pedirCantJugadores.setText("Seleccione la cantidad de jugadores: ");
        StackPane.setAlignment(pedirCantJugadores, Pos.TOP_CENTER);

        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().addAll(1,2,3);

        BotonAceptarEvento accept = new BotonAceptarEvento(this.app, choiceBox);
        aceptar.setOnAction(accept);

        StackPane.setAlignment(choiceBox, Pos.CENTER);
        StackPane.setAlignment(aceptar, Pos.CENTER);

        VBox contenedor = new VBox(pedirCantJugadores, choiceBox, aceptar);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);

        Button salir = new Button("Salir");
        BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this.app);
        salir.setOnAction(botonSalir);
        salir.defaultButtonProperty().bind(salir.focusedProperty());

        layout.getChildren().addAll(contenedor, salir);
        layout.setPadding(new Insets(10));

        StackPane.setAlignment(salir, Pos.BOTTOM_LEFT);
        layout.setPrefHeight(1080);
        layout.setPrefWidth(1920);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
        this.app.getStage().setScene(scene);
        this.app.getStage().setFullScreen(true);
        this.app.getStage().setFullScreenExitHint("");
        this.app.getStage().centerOnScreen();
    }

}
