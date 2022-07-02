package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoIncrementarMovimientosPorcentual extends EfectoDecorador {
    private final double PORCENTAJEINCREMENTO;

    public EfectoIncrementarMovimientosPorcentual(Efecto efecto, double porcentajeIncremento) {
        super(efecto);
        PORCENTAJEINCREMENTO = 100 + porcentajeIncremento;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.aplicarPorcentajeMovimientos(PORCENTAJEINCREMENTO);
    }
}
