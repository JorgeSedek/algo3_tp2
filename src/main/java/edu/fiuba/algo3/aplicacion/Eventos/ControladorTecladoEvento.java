package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.Vista.EscenarioView;
import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.VehiculoView;
import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorTecladoEvento implements EventHandler<KeyEvent> {
    private Direccion direccion;

    private VehiculoView vehiculoView;
    private EscenarioView escenarioView;

    public ControladorTecladoEvento(EscenarioView escenarioView){
        this.escenarioView = escenarioView;
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
            Juego.getInstance().moverVehiculo(new DireccionArriba());
        }

        //vehiculoView.actualizar();
        //vehiculoView.dibujar();
        escenarioView.actualizar();
        keyEvent.consume();

        if (!Juego.getInstance().hayJugadoresActivos()) {
            StackPane puntuaciones = new StackPane();
            VBox vbox = new VBox(new TextArea("PUNTUACIONES:"));
            puntuaciones.getChildren().add(vbox);

            Stage stageEscenarioView = escenarioView.obtenerStage();
            stageEscenarioView.setScene(new Scene(puntuaciones));
            stageEscenarioView.show();
        }
    }

}

