package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.JuegoView;
import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Puntaje;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class ControladorTecladoEvento implements EventHandler<KeyEvent> {
    private Direccion direccion;

    private App app;
    private EscenarioView escenarioView;
    private JuegoView juegoView;

    public ControladorTecladoEvento(EscenarioView escenarioView, JuegoView juegoView, App app){
        this.app = app;
        this.escenarioView = escenarioView;
        this.juegoView = juegoView;
    }

    public void handle(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.A) {

            direccion = new DireccionIzquierda();
            Juego.getInstance().moverVehiculo(direccion);
        }
        if (keyEvent.getCode() == KeyCode.S) {
            direccion = new DireccionAbajo();
            Juego.getInstance().moverVehiculo(direccion);

        }
        if (keyEvent.getCode() == KeyCode.D) {
            direccion = new DireccionDerecha();
            Juego.getInstance().moverVehiculo(direccion);

        }
        if (keyEvent.getCode() == KeyCode.W) {
            direccion = new DireccionArriba();
            Juego.getInstance().moverVehiculo(direccion);
        }

        escenarioView.actualizar();
        juegoView.actualizar();
        keyEvent.consume();

        // Entra a este if cuando se termina el juego
        if (!Juego.getInstance().hayJugadoresActivos()) {
            app.obtenerReproductorMusica().stop();
            StackPane puntuaciones = new StackPane();

            Label titulo = new Label("TABLA DE PUNTUACIONES: \n\n");

            Button salir = new Button("Volver al Inicio");
            BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this.app);
            salir.setOnAction(botonSalir);
            salir.defaultButtonProperty().bind(salir.focusedProperty());
            StackPane.setAlignment(salir, Pos.BOTTOM_CENTER);

            VBox vbox = new VBox(titulo);
            vbox.setId("puntuaciones");
            puntajesDeLosJugadores(vbox);
            puntuaciones.getChildren().addAll(vbox, salir);
            vbox.setAlignment(Pos.TOP_CENTER);

            Stage stageEscenarioView = escenarioView.obtenerStage();
            Scene scene = new Scene(puntuaciones);
            scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
            stageEscenarioView.setScene(scene);
            stageEscenarioView.setFullScreen(true);
            stageEscenarioView.show();
        }
    }

    private void puntajesDeLosJugadores(VBox vBox) {
        List<Puntaje> puntajes = Juego.getInstance().obtenerPuntajes();

        for (Puntaje puntaje : puntajes) {
            Text nombre = new Text(puntaje.obtenerNombreJugador());
            Text puntuacion = new Text(String.valueOf(puntaje.obtenerPuntuacion() ));
            HBox hBox = new HBox(nombre, puntuacion);
            hBox.setSpacing(100);
            hBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(hBox);
        }
    }

}

