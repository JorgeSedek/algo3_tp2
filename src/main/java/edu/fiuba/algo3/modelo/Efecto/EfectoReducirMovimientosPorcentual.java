package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;

public class EfectoReducirMovimientosPorcentual extends EfectoDecorador {
    private int porcentajeReduccion;

    public EfectoReducirMovimientosPorcentual(Efecto efecto, int porcentajeReduccion) {
        super(efecto);
        this.porcentajeReduccion = porcentajeReduccion;
    }

    @Override
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        double reduccion = jugador.porcentajeMovimientos(this.porcentajeReduccion);
        jugador.reducirMovimientos( (int) reduccion);
    }
}
