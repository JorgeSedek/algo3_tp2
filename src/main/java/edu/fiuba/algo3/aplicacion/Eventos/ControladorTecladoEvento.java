package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.VehiculoView;
import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorTecladoEvento implements EventHandler<KeyEvent> {
    private Direccion direccion;

    private VehiculoView vehiculoView;

    public ControladorTecladoEvento(){
    }

    public void handle(KeyEvent keyEvent){
        try {
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

            vehiculoView.actualizar();
            //vehiculoView.dibujar();
            keyEvent.consume();

        } catch (Exception ignored) {
            //Excepcion de no se puede mover
        }

    }

}
