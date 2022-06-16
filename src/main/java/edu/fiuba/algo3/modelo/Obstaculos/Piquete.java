package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public void atravezar(Auto auto) {
    }

    public void atravezar(Camioneta camioneta) {

    }

    public void atravezar(Moto moto) {
        int incremento = 2;
        moto.incrementarMovimientos(incremento);
    }
}
