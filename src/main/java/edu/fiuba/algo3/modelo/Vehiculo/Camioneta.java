package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Casillero casillero) {
        super(casillero);
    }

    protected void recibePozo(ObjetoUrbano x) {
        pozos_atravesados++;
        if (pozos_atravesados > 3) {
            this.incrementarMovimientos(3);
        }

    }

    protected void recibePiquete(ObjetoUrbano x) {

    }

    protected void recibePolicia(ObjetoUrbano x) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 3) {
            int disminucion = 3;
            this.disminuirMovimientos(disminucion);
        }

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
        Vehiculo nuevoVehiculo = new Moto(this.casillero());

        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarMovimientos(this.movimientos());
        this.cambio = nuevoVehiculo;
    }
}
