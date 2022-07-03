package edu.fiuba.algo3.aplicacion.Eventos;

import edu.fiuba.algo3.aplicacion.Vista.VehiculosView.VehiculoView;
import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorTecladoEvento implements EventHandler<KeyEvent> {

    private Escenario escenario;
    private Juego juego;
    private Direccion direccion;
    private VehiculoView vehiculo;

    public ControladorTecladoEvento(Juego juego, Escenario escenario){
        this.escenario = escenario;
        this.juego = juego;
    }

    public void handle(KeyEvent keyEvent){
/*
        try {
            if(keyEvent.getCode() == KeyCode.A){
                //Algo
                DireccionIzquierda direccion = new DireccionIzquierda();
                /*
                Juego.getInstance().moverVehiculo(direccion);
              //  vehiculo.actualizar(float pixelX, float pixelY);

            }

            if(keyEvent.getCode() == KeyCode.S){
                //Algo
                DireccionAbajo direccion = new DireccionAbajo();

                Juego.getInstance().moverVehiculo(direccion);
              //  vehiculo.actualizar(float pixelX, float pixelY);

            }
            if(keyEvent.getCode() == KeyCode.D){
                DireccionDerecha direccion = new DireccionDerecha();

                //Algo
                Juego.getInstance().moverVehiculo(direccion);
               // vehiculo.actualizar(float pixelX, float pixelY);


            }

            if(keyEvent.getCode() == KeyCode.W){
                DireccionArriba direccion = new DireccionArriba();

                //Algo
                Juego.getInstance().moverVehiculo(direccion);
              //  vehiculo.actualizar(float pixelX, float pixelY);
                vehiculo.actualizar(direccion);

            }
            Juego.getInstance().moverVehiculo(direccion);
            vehiculo.actualizar(direccion);
            vehiculo.dibujar();
            keyEvent.consume();
        }catch (Exception ignored){
            //Excepcion de no se puede mover
        }
*/
    }

}
