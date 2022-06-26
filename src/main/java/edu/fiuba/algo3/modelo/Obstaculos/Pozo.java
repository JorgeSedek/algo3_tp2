package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;


public class Pozo implements Obstaculo {
    private int incremento = 3;

    public Efecto atravesar(Auto auto, Efecto efecto) {
        return this.calcularEfecto(efecto);
    }

    public Efecto atravesar(Camioneta camioneta, Efecto efecto) {
        camioneta.atravezoPozo();
        if(camioneta.pasoLimitePozos()) {
            return this.calcularEfecto(efecto);
        }
        return efecto;
    }

    public Efecto atravesar(Moto moto, Efecto efecto) {
        return this.calcularEfecto(efecto);
    }

    private Efecto calcularEfecto(Efecto efecto) {
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }
}

