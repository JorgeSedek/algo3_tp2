package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public interface Sorpresa {
    void atravezar(Auto auto);

    void atravezar(Camioneta camioneta);

    void atravezar(Moto moto);
}
