package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoIncrementarMovimientosPorcentual extends EfectoDecorador {
    private double porcentajeIncremento;

    public EfectoIncrementarMovimientosPorcentual(Efecto efecto, double porcentajeIncremento) {
        super(efecto);
        this.porcentajeIncremento = porcentajeIncremento;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        double incremento = jugador.porcentajeMovimientos(this.porcentajeIncremento);
        jugador.incrementarMovimientos( (int) incremento);
    }
}
