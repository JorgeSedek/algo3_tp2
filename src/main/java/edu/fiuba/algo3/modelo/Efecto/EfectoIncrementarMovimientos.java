package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoIncrementarMovimientos extends EfectoDecorador {
    private int incremento;
    
    public EfectoIncrementarMovimientos(Efecto efecto, int incremento) {
        super(efecto);
        this.incremento = incremento;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        vehiculo.incrementarMovimientos(this.incremento);
    }
}
