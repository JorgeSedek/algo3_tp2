package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoIncrementarMovimientosPorcentual extends EfectoDecorador {
    private int porcentajeIncremento;

    public EfectoIncrementarMovimientosPorcentual(Efecto efecto, int porcentajeIncremento) {
        super(efecto);
        this.porcentajeIncremento = porcentajeIncremento;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        int incremento = vehiculo.porcentajeMovimientos(this.porcentajeIncremento);
        vehiculo.incrementarMovimientos(incremento);
    }
}
