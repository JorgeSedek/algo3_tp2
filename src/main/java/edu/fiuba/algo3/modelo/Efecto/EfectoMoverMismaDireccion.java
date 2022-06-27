package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoMoverMismaDireccion extends EfectoDecorador {

    public EfectoMoverMismaDireccion(Efecto efecto) {
        super(efecto);
    }
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.moverVehiculoSinItems();
    }
}

