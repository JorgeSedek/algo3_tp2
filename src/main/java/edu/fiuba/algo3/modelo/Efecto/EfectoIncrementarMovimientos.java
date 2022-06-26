package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoIncrementarMovimientos extends EfectoDecorador {
    private int incremento;
    
    public EfectoIncrementarMovimientos(Efecto efecto, int incremento) {
        super(efecto);
        this.incremento = incremento;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.incrementarMovimientos(this.incremento);
    }
}
