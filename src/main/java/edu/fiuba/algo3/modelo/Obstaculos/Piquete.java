package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public void atravesar(Auto auto) {
    }

    public void atravesar(Camioneta camioneta) {

    }

    public void atravesar(Moto moto) {
        int incremento = 2;
        moto.incrementarMovimientos(incremento);
    }
}
