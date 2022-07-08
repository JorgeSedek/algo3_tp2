package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.*;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo {
    public Efecto atravesar(Auto auto) {
        Logger.getInstance().imprimir("No podes atravezar el piquete, volves a tu posición anterior");
        Efecto efecto = new EfectoGeneral();

        return new EfectoMoverAlReves(efecto, auto);
    }

    public Efecto atravesar(Camioneta camioneta) {
        Logger.getInstance().imprimir("No podes atravezar el piquete, volves a tu posición anterior");
        Efecto efecto = new EfectoGeneral();

        return new EfectoMoverAlReves(efecto, camioneta);
    }

    public Efecto atravesar(Moto moto) {
        int incremento = 2;
        Logger.getInstance().imprimir("Atravezaste un Piquete, se te suman " + incremento + " movimientos");
        Efecto efecto = new EfectoGeneral();
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }

    public boolean molestoEnElBorde() {
        return true;
    }
}
