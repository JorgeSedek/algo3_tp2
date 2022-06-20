package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public Efecto atravesar(Auto auto) {
        // No deberia poder pasar
        return new EfectoGeneral();

    }

    public Efecto atravesar(Camioneta camioneta) {
        // No deberia poder pasar
        return new EfectoGeneral();

    }

    public Efecto atravesar(Moto moto) {
        int incremento = 2;
        Efecto efecto = new EfectoGeneral();
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }
}
