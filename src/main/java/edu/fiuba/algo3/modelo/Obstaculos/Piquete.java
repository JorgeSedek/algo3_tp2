package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.*;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public Efecto atravesar(Auto auto, Efecto efecto) {
        // No deberia poder pasar
        return new EfectoMoverAlrevez(new EfectoMoverMismaDireccion(efecto),auto);

    }

    public Efecto atravesar(Camioneta camioneta, Efecto efecto) {
        // No deberia poder pasar
        return new EfectoMoverAlrevez(new EfectoMoverMismaDireccion(efecto),camioneta);

    }

    public Efecto atravesar(Moto moto, Efecto efecto) {
        int incremento = 2;
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }
}
