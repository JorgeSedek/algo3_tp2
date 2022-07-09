package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.App;
import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.JuegoView;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.General.Puntaje;
import edu.fiuba.algo3.modelo.General.Ranking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class BotonMovDerechaEvento implements EventHandler<ActionEvent> {

    private Direccion direccion;
    private EscenarioView escenarioView;
    private JuegoView juegoView;
    private App app;

    public BotonMovDerechaEvento(EscenarioView escenarioView, JuegoView juegoView, App app){
        this.escenarioView = escenarioView;
        this.juegoView = juegoView;
        this.app = app;
    }

    public void handle(ActionEvent actionEvent){
        direccion = new DireccionDerecha();
        Juego.getInstance().moverVehiculo(direccion);

        escenarioView.actualizar();
        juegoView.actualizar();


        if (!Juego.getInstance().hayJugadoresActivos()) {
            app.obtenerReproductorMusica().stop();
            app.agregarPuntajesJugadores();
            juegoView.limpiarConsola();
            Logger.getInstance().resetear();

            StackPane puntuaciones = new StackPane();

            Label titulo = new Label("TABLA DE PUNTUACIONES: \n\n");

            Button salir = new Button("Volver al Inicio");
            BotonSalirElegirJugadoresEvent botonSalir = new BotonSalirElegirJugadoresEvent(this.app);
            salir.setOnAction(botonSalir);
            salir.defaultButtonProperty().bind(salir.focusedProperty());
            StackPane.setAlignment(salir, Pos.BOTTOM_CENTER);

            VBox vbox = new VBox(titulo);
            vbox.setId("puntuaciones");
            puntajesDeLosTop6Jugadores(vbox);
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

    private void puntajesDeLosTop6Jugadores(VBox vBox) {
        List<Puntaje> puntajes = app.obtenerPuntajes();
        int cantJugadoresEnTop = 0;

        for (Puntaje puntaje : puntajes) {
            cantJugadoresEnTop++;
            if (cantJugadoresEnTop > 6) {
                return;
            }

            Text nombre = new Text(puntaje.obtenerNombreJugador());
            Text puntuacion = new Text(String.valueOf(puntaje.obtenerPuntuacion()));
            HBox hBox = new HBox(nombre, puntuacion);
            hBox.setSpacing(100);
            hBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(hBox);

        }
    }

}
