package edu.fiuba.algo3.aplicacion.Eventos;
/*
import edu.fiuba.algo3.modelo.Direccion.Direccion;
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

        try {
            if(keyEvent.getCode() == KeyCode.A){
                //Algo
                Juego.getInstance().moverVehiculo(new DireccionIzquierda());
                vehiculo.actualizar(float pixelX, float pixelY);
            }
            if(keyEvent.getCode() == KeyCode.S){
                //Algo
                Juego.getInstance().moverVehiculo(new DireccionAbajo());
                vehiculo.actualizar(float pixelX, float pixelY);
            }
            if(keyEvent.getCode() == KeyCode.D){
                //Algo
                Juego.getInstance().moverVehiculo(new DireccionDerecha());
                vehiculo.actualizar(float pixelX, float pixelY);
            }
            if(keyEvent.getCode() == KeyCode.W){
                //Algo
                Juego.getInstance().moverVehiculo(new DireccionArriba());
                vehiculo.actualizar(float pixelX, float pixelY);
            }
            keyEvent.consume();
        }catch (Exception ignored){
            //Excepcion de no se puede mover
        }

    }
}
*/