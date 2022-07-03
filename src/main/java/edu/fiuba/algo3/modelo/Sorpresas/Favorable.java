package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoReducirMovimientosPorcentual;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Favorable implements Sorpresa {
    public Efecto atravesar(Auto auto) {
        return this.calcularEfecto();
    }

    public Efecto atravesar(Camioneta camioneta) {
        return this.calcularEfecto();
    }

    public Efecto atravesar(Moto moto) {
        return this.calcularEfecto();
    }

    private Efecto calcularEfecto() {
        Efecto efecto = new EfectoGeneral();
        int porcentajeReduccion = 20;
        Logger.getInstance().imprimir("Recibiste una sorpresa Favorable, tus movimientos se reducen un " + porcentajeReduccion + "%");
        return new EfectoReducirMovimientosPorcentual(efecto, porcentajeReduccion);
    }
}
