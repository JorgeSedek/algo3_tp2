package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Policia implements Obstaculo {
    public void atravesar(Auto auto) {
        double probabilidad = Math.random(); // Valor decimal entre 0 y 1
        if(probabilidad <= 0.5) {
            int incremento = 3;
            auto.incrementarMovimientos(incremento);
        }
    }

    public void atravesar(Camioneta camioneta) {
        double probabilidad = Math.random();
        if(probabilidad <= 0.3) {
            int incremento = 3;
            camioneta.incrementarMovimientos(incremento);
        }
    }

    public void atravesar(Moto moto) {
        double probabilidad = Math.random();
        if(probabilidad <= 0.8) {
            int incremento = 3;
            moto.incrementarMovimientos(incremento);
        }
    }
}