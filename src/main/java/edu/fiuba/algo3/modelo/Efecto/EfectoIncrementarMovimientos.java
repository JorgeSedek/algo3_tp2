package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoIncrementarMovimientos extends EfectoDecorador {
    private final int INCREMENTO;
    
    public EfectoIncrementarMovimientos(Efecto efecto, int incremento) {
        super(efecto);
        INCREMENTO = incremento;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.incrementarMovimientos(INCREMENTO);
    }
}
