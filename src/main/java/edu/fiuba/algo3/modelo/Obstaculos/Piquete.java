package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public void atravesar(Auto auto) {
        // No deberia poder pasar
    }

    public void atravesar(Camioneta camioneta) {
        // No deberia poder pasar
    }

    public void atravesar(Moto moto) {
        int incremento = 2;
        moto.incrementarMovimientos(incremento);
    }
}
