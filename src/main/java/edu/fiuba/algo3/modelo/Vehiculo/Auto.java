package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;

public class Auto extends Vehiculo {
    public Auto(Casillero casillero) {
        super(casillero);
    }

    protected Vehiculo recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.incrementarMovimientos(incremento);
        return this;
    }

    protected Vehiculo recibePiquete(ObjetoUrbano x) {
        return this;
    }

    @Override
    protected Vehiculo recibePolicia(ObjetoUrbano x) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 5) {
            int disminucion = 3;
            this.disminuirMovimientos(disminucion);
        }
        return this;
    }

    protected Vehiculo recibeFavorable(ObjetoUrbano x) {
        int movimientosReducidos = this.movimientos() / 5;
        this.disminuirMovimientos(movimientosReducidos);
        return this;
    }

    protected Vehiculo recibeDesfavorable(ObjetoUrbano x) {
        int movimientosAumentados = this.movimientos() / 4;
        this.incrementarMovimientos(movimientosAumentados);
        return this;
    }



    protected Vehiculo recibeCambioVehiculo(ObjetoUrbano x) {
        Vehiculo nuevoVehiculo = new Camioneta(this.casillero());
        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarMovimientos(this.movimientos());
        return (nuevoVehiculo);
    }
}

