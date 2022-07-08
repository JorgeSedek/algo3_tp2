package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.JuegoView;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Puntaje;
import edu.fiuba.algo3.modelo.General.Ranking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class BotonMovArribaEvento implements EventHandler<ActionEvent> {

    private Direccion direccion;
    private EscenarioView escenarioView;
    private JuegoView juegoView;
    private App app;

    public BotonMovArribaEvento(EscenarioView escenarioView, JuegoView juegoView, App app){
        this.escenarioView = escenarioView;
        this.juegoView = juegoView;
        this.app = app;
    }

    public void handle(ActionEvent actionEvent){
        direccion = new DireccionArriba();
        Juego.getInstance().moverVehiculo(direccion);

        escenarioView.actualizar();
        juegoView.actualizar();


        if (!Juego.getInstance().hayJugadoresActivos()) {

            StackPane puntuaciones = new StackPane();
            TextArea textArea = new TextArea(
                    "TABLA DE PUNTUACIONES: \n\n" + puntajesDeLosJugadores()
            );

            Button salir = new Button("Volver al Inicion");
            BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this.app);
            salir.setOnAction(botonSalir);
            salir.defaultButtonProperty().bind(salir.focusedProperty());

            textArea.setEditable(false);
            VBox vbox = new VBox(textArea, salir);
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
        List<Puntaje> puntajes = Ranking.getInstance().puntajes();
        String puntajesString = "";

        for (Puntaje puntaje : puntajes) {
            puntajesString += "Jugador: " + puntaje.obtenerNombreJugador() + " Movimientos: " + puntaje.obtenerPuntuacion() + "\n";
        }

        return puntajesString;
    }
}
