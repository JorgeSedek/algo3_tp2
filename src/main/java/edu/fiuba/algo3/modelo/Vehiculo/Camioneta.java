package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;

import java.util.HashMap;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Ubicacion ubicacion) {
        super(ubicacion);
    }

    protected void recibePozo(ObjetoUrbano x) {
        pozos_atravesados++;
        if (pozos_atravesados > 3) {
            this.incrementarMovimientos(3);
        }
    }

    protected void recibePiquete(ObjetoUrbano x) {
    }

    protected void recibeFavorable(ObjetoUrbano x) {
        int movimientosReducidos = this.movimientos() / 5;
        this.disminuirMovimientos(movimientosReducidos);
    }

    protected void recibeDesfavorable(ObjetoUrbano x) {
        int movimientosAumentados = this.movimientos() / 4;
        this.incrementarMovimientos(movimientosAumentados);
    }

    protected void recibeCambioVehiculo(ObjetoUrbano x) {
        Vehiculo nuevoVehiculo = new Moto(this.obtenerUbicacion());
        //this.cambiarVehiculo(nuevoVehiculo);
    }
}
