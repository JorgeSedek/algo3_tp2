package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;

public interface Sorpresa {
    Efecto atravesar(Auto auto);

    Efecto atravesar(Camioneta camioneta);

    Efecto atravesar(Moto moto);
}
