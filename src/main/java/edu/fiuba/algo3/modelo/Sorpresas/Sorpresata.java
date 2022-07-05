package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoSorpresata;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Sorpresata implements Sorpresa {

    @Override
    public Efecto atravesar(Auto auto) {
        return this.calcularEfecto(auto);
    }


    @Override
    public Efecto atravesar(Camioneta camioneta) {
        return this.calcularEfecto(camioneta);
    }

    @Override
    public Efecto atravesar(Moto moto) {
        return this.calcularEfecto(moto);
    }

    private Efecto calcularEfecto(Vehiculo vehiculo) {
        Efecto efecto = new EfectoGeneral();
        return new EfectoSorpresata(efecto, vehiculo);
    }
}
