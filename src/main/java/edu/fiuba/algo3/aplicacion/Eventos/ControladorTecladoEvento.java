package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.JuegoView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.VehiculoView;
import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Puntaje;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ControladorTecladoEvento implements EventHandler<KeyEvent> {
    private Direccion direccion;

    private VehiculoView vehiculoView;
    private EscenarioView escenarioView;
    private JuegoView juegoView;

    public ControladorTecladoEvento(EscenarioView escenarioView, JuegoView juegoView){
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

            StackPane puntuaciones = new StackPane();
            TextArea textArea = new TextArea(
                    "TABLA DE PUNTUACIONES: \n\n" + puntajesDeLosJugadores()
            );
            textArea.setEditable(false);
            VBox vbox = new VBox(textArea);
            puntuaciones.getChildren().add(vbox);

            Stage stageEscenarioView = escenarioView.obtenerStage();
            Scene scene = new Scene(puntuaciones);
            scene.getStylesheets().add("file:../algo3_tp2/src/main/java/edu/fiuba/algo3/aplicacion/css/principal.css");
            stageEscenarioView.setScene(scene);
            stageEscenarioView.setFullScreen(true);
            stageEscenarioView.show();
        }
    }

    private String puntajesDeLosJugadores() {
        List<Puntaje> puntajes = Juego.getInstance().obtenerPuntajes();
        String puntajesString = "";

        for (Puntaje puntaje : puntajes) {
            puntajesString += "Jugador: " + puntaje.obtenerNombreJugador() + " Movimientos: " + puntaje.obtenerPuntuacion() + "\n";
        }

        return puntajesString;
    }

}

