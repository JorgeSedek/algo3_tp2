package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoIncrementarMovimientosPorcentual extends EfectoDecorador {
    private double porcentajeIncremento;

    public EfectoIncrementarMovimientosPorcentual(Efecto efecto, double porcentajeIncremento) {
        super(efecto);
        this.porcentajeIncremento = porcentajeIncremento;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        double incremento = vehiculo.porcentajeMovimientos(this.porcentajeIncremento);
        vehiculo.incrementarMovimientos( (int) incremento);
    }
}
