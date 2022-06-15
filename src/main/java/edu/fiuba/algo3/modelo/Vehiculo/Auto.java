package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;

public class Auto extends Vehiculo {
    public Auto(Casillero casillero) {
        super(casillero);
    }

    protected void recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.incrementarMovimientos(incremento);

    }

    protected void recibePiquete(ObjetoUrbano x) {

    }

    @Override
    protected void recibePolicia(ObjetoUrbano x) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 5) {
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
        Vehiculo nuevoVehiculo = new Camioneta(this.casillero());
        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarMovimientos(this.movimientos());
        this.cambio = nuevoVehiculo;

    }
}

