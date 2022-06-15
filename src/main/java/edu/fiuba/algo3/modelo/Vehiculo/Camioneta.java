package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Casillero casillero) {
        super(casillero);
    }

    protected Vehiculo recibePozo(ObjetoUrbano x) {
        pozos_atravesados++;
        if (pozos_atravesados > 3) {
            this.incrementarMovimientos(3);
        }
        return this;
    }

    protected Vehiculo recibePiquete(ObjetoUrbano x) {
        return this;
    }

    protected Vehiculo recibePolicia(ObjetoUrbano x) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 3) {
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
        Vehiculo nuevoVehiculo = new Moto(this.casillero());

        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarMovimientos(this.movimientos());
        return (nuevoVehiculo);
    }
}
