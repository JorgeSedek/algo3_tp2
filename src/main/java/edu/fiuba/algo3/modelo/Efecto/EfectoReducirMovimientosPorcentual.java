package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoReducirMovimientosPorcentual extends EfectoDecorador {
    private int porcentajeReduccion;

    public EfectoReducirMovimientosPorcentual(Efecto efecto, int porcentajeReduccion) {
        super(efecto);
        this.porcentajeReduccion = porcentajeReduccion;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        int reduccion = vehiculo.porcentajeMovimientos(this.porcentajeReduccion);
        vehiculo.reducirMovimientos(reduccion);
    }
}
