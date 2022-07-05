package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.JuegoView;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Puntaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class BotonMovArribaEvento implements EventHandler<ActionEvent> {

    private Direccion direccion;
    private EscenarioView escenarioView;
    private JuegoView juegoView;

    public BotonMovArribaEvento(EscenarioView escenarioView, JuegoView juegoView){
        this.escenarioView = escenarioView;
        this.juegoView = juegoView;
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
            textArea.setEditable(false);
            VBox vbox = new VBox(textArea);
            puntuaciones.getChildren().add(vbox);

            Stage stageEscenarioView = escenarioView.obtenerStage();
            stageEscenarioView.setScene(new Scene(puntuaciones));
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
