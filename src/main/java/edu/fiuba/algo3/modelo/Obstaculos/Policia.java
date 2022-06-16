package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

/*

LA PROBABILIDAD NO FUNCIONA (siempre es 0)
NO SE ESTA UTILIZANDO DE MOMENTO

public class Policia implements Obstaculo {
    public void atravesar(Auto auto) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 5) {
            int incremento = 3;
            auto.incrementarMovimientos(incremento);
        }
    }

    public void atravesar(Camioneta camioneta) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 3) {
            int incremento = 3;
            camioneta.incrementarMovimientos(incremento);
        }
    }

    public void atravesar(Moto moto) {
        int probabilidad = (int) Math.random() * 10 + 1;
        if(probabilidad <= 8) {
            int incremento = 3;
            moto.incrementarMovimientos(incremento);
        }
    }
}

*/