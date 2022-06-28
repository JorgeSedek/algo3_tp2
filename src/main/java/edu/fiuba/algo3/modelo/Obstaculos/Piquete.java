package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.*;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public Efecto atravesar(Auto auto) {
        Efecto efecto = new EfectoGeneral();
        return new EfectoMoverAlReves(efecto, auto);

    }

    public Efecto atravesar(Camioneta camioneta) {
        Efecto efecto = new EfectoGeneral();
        return new EfectoMoverAlReves(efecto, camioneta);

    }

    public Efecto atravesar(Moto moto) {
        int incremento = 2;
        Efecto efecto = new EfectoGeneral();
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }
}
