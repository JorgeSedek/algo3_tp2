package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientosPorcentual;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Desfavorable implements Sorpresa {
    private int porcentajeIncremento = 25;

    public Efecto atravesar(Auto auto, Efecto efecto) {
        return this.calcularEfecto(efecto);
    }

    public Efecto atravesar(Camioneta camioneta, Efecto efecto) {
        return this.calcularEfecto(efecto);
    }

    public Efecto atravesar(Moto moto, Efecto efecto) {
        return this.calcularEfecto(efecto);
    }

    private Efecto calcularEfecto(Efecto efecto) {
        return new EfectoIncrementarMovimientosPorcentual(efecto, porcentajeIncremento);
    }
}
