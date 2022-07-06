package edu.fiuba.algo3.modelo.Meta;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;

public class SinMeta implements Meta{
    public Efecto atravesar(Vehiculo vehiculo) {
        return new EfectoGeneral();
    }
}
