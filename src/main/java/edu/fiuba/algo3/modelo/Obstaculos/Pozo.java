package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Pozo implements Obstaculo {
    public void atravesar(Auto auto) {
        _atravesar(auto);
    }

    public void atravesar(Camioneta camioneta) {
        camioneta.atravezoPozo();
        if(camioneta.pasoLimitePozos()) {
            _atravesar(camioneta);
        }
    }

    public void atravesar(Moto moto) {
        _atravesar(moto);
    }

    private void _atravesar(Vehiculo vehiculo) {
        int incremento = 3;
        vehiculo.incrementarMovimientos(incremento);
    }
}

