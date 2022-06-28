package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Juego;

public class EfectoFinalizarJuego extends EfectoDecorador {
    public EfectoFinalizarJuego(Efecto efecto) {
        super(efecto);
        Juego.getInstance().finalizar();
    }
}
