package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoReducirMovimientosPorcentual extends EfectoDecorador {
    private final int PORCENTAJEREDUCCION;

    public EfectoReducirMovimientosPorcentual(Efecto efecto, int porcentajeReduccion) {
        super(efecto);
        PORCENTAJEREDUCCION = 100 - porcentajeReduccion;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.aplicarPorcentajeMovimientos(PORCENTAJEREDUCCION);
    }
}
