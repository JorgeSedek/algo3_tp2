package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoMoverAlrevez extends EfectoDecorador {

    public EfectoMoverAlrevez(Efecto efecto, Vehiculo vehiculo) {
        super(efecto);
        vehiculo.cambiarDireccionContraria();
    }
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.moverVehiculoSinItems();
    }
}

