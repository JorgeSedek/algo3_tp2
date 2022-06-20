package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoDecorador implements Efecto {
    protected Efecto wrappee;

    public EfectoDecorador(Efecto efecto) {
        this.wrappee = efecto;
    }

    public void aplicar(Vehiculo vehiculo) {
        wrappee.aplicar(vehiculo);
    }
}
