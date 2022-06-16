package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Favorable implements Sorpresa {
    public void atravesar(Auto auto) {
        _atravesar(auto);
    }

    public void atravesar(Camioneta camioneta) {
        _atravesar(camioneta);
    }

    public void atravesar(Moto moto) {
        _atravesar(moto);
    }

    private void _atravesar(Vehiculo vehiculo) {
        int porcentajeDisminucion = 20;
        int disminucion = vehiculo.porcentajeMovimientos(porcentajeDisminucion);
        vehiculo.disminuirMovimientos(disminucion);
    }
}
