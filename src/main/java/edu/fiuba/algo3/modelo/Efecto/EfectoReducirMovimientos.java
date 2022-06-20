package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoReducirMovimientos extends EfectoDecorador {
    private int reduccion;

    public EfectoReducirMovimientos(Efecto efecto, int reduccion) {
        super(efecto);
        this.reduccion = reduccion;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        vehiculo.reducirMovimientos(this.reduccion);
    }
}
