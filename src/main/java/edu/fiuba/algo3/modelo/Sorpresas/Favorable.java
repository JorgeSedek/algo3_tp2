package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Favorable implements Sorpresa {
    public void atravesar(Auto auto) {
        int porcentajeDisminucion = 20;
        int disminucion = auto.porcentajeMovimientos(porcentajeDisminucion);
        auto.disminuirMovimientos(disminucion);
    }

    public void atravesar(Camioneta camioneta) {
        int porcentajeDisminucion = 20;
        int disminucion = camioneta.porcentajeMovimientos(porcentajeDisminucion);
        camioneta.disminuirMovimientos(disminucion);
    }

    public void atravesar(Moto moto) {
        int porcentajeDisminucion = 20;
        int disminucion = moto.porcentajeMovimientos(porcentajeDisminucion);
        moto.disminuirMovimientos(disminucion);
    }
}
