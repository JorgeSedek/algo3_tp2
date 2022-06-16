package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Desfavorable implements Sorpresa {
    public void atravesar(Auto auto) {
        int porcentajeAumento = 25;
        int incremento = auto.porcentajeMovimientos(porcentajeAumento);
        auto.incrementarMovimientos(incremento);
    }

    public void atravesar(Camioneta camioneta) {
        int porcentajeAumento = 25;
        int incremento = camioneta.porcentajeMovimientos(porcentajeAumento);
        camioneta.incrementarMovimientos(incremento);
    }

    public void atravesar(Moto moto) {
        int porcentajeAumento = 25;
        int incremento = moto.porcentajeMovimientos(porcentajeAumento);
        moto.incrementarMovimientos(incremento);
    }
}
