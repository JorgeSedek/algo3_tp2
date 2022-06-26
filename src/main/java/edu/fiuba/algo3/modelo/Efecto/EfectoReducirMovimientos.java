package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoReducirMovimientos extends EfectoDecorador {
    private int reduccion;

    public EfectoReducirMovimientos(Efecto efecto, int reduccion) {
        super(efecto);
        this.reduccion = reduccion;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.reducirMovimientos(this.reduccion);
    }
}
