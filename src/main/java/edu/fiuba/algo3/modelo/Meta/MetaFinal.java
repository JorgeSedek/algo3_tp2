package edu.fiuba.algo3.modelo.Meta;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoFinalizarJuego;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class MetaFinal implements Meta{

    public Efecto atravesar(Vehiculo vehiculo, Efecto efecto) {
        return new EfectoFinalizarJuego(efecto);
    }
}
