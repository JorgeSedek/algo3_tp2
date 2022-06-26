package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public interface Sorpresa {
    Efecto atravesar(Auto auto, Efecto efecto);

    Efecto atravesar(Camioneta camioneta, Efecto efecto);

    Efecto atravesar(Moto moto, Efecto efecto);
}
