package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoFinalizarJuego extends EfectoDecorador {
    public EfectoFinalizarJuego(Efecto efecto) {
        super(efecto);
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        Juego.getInstance().finalizar();
    }
}
