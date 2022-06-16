package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Pozo implements Obstaculo {
    public void atravesar(Auto auto) {
        int incremento = 3;
        auto.incrementarMovimientos(incremento);
    }

    public void atravesar(Camioneta camioneta) {
        camioneta.atravezoPozo();
        if(camioneta.pasoLimitePozos()) {
            int incremento = 3;
            camioneta.incrementarMovimientos(incremento);
        }
    }

    public void atravesar(Moto moto) {
        int incremento = 3;
        moto.incrementarMovimientos(incremento);
    }
}

