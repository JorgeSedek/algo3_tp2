package edu.fiuba.algo3.modelo.Meta;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoFinalizarJuego;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoMoverAlReves;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class MetaFinal implements Meta{

    public Efecto atravesar(Vehiculo vehiculo) {
        Efecto efecto = new EfectoGeneral();
        //Efecto efecto = new EfectoMoverAlReves(new EfectoGeneral(), vehiculo); Esta es otra implementacion, donde se deja en el casillero anterior a la meta
        return new EfectoFinalizarJuego(efecto);
    }
}
