package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;

public class Moto extends Vehiculo {
    public Moto(Casillero casillero) {
        super(casillero);
    }

    protected void recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.calculadora.incrementarMovimientos(incremento);

    }

    protected void recibePiquete(ObjetoUrbano x) {
        int incremento = 2;
        this.calculadora.incrementarMovimientos(incremento);

    }

    protected void recibePolicia(ObjetoUrbano x) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 8) {
            int disminucion = 3;
            this.calculadora.disminuirMovimientos(disminucion);
        }

    }

    protected void recibeFavorable(ObjetoUrbano x) {
        int divisor = 5;
        int movimientosReducidos = this.calculadora.dividirMovimientos(divisor);
        this.calculadora.disminuirMovimientos(movimientosReducidos);

    }

    protected void  recibeDesfavorable(ObjetoUrbano x) {
        int divisor = 4;
        int movimientosAumentados = this.calculadora.dividirMovimientos(divisor);
        this.calculadora.incrementarMovimientos(movimientosAumentados);

    }


    protected void recibeCambioVehiculo(ObjetoUrbano x) {
        Vehiculo nuevoVehiculo = new Auto(this.casillero());
        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarCalculadoraMov(this.calculadora);
        this.cambio = nuevoVehiculo;

    }
}
