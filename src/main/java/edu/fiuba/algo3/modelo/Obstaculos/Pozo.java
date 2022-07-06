package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientos;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Pozo implements Obstaculo {
    public Efecto atravesar(Auto auto) {
        return this.calcularEfecto();
    }

    public Efecto atravesar(Camioneta camioneta) {
        if(camioneta.pasoLimitePozos()) {
            return this.calcularEfecto();
        }
        Logger.getInstance().imprimir("Atravezaste un Pozo, no se te suman movimientos");
        return new EfectoGeneral();
    }

    public Efecto atravesar(Moto moto) {
        return this.calcularEfecto();
    }

    private Efecto calcularEfecto() {
        Efecto efecto = new EfectoGeneral();
        int incremento = 3;
        Logger.getInstance().imprimir("Atravezaste un Pozo, se te suman " + incremento + " movimientos");
        return new EfectoIncrementarMovimientos(efecto, incremento);
    }
}

