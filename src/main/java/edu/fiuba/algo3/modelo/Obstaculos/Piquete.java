package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public Efecto atravesar(Auto auto, Efecto efecto) {
        // No deberia poder pasar
        return efecto;

    }

    public Efecto atravesar(Camioneta camioneta, Efecto efecto) {
        // No deberia poder pasar
        return efecto;

    }

    public Efecto atravesar(Moto moto, Efecto efecto) {
        int incremento = 2;
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }
}
