package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Efecto.EfectoIncrementarMovimientosPorcentual;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;

public class Desfavorable implements Sorpresa {
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
        int porcentajeIncremento = 25;
        Logger.getInstance().imprimir("Recibiste una sorpresa Desfavorable, tus movimientos se aumentan un " + porcentajeIncremento + "%");
        return new EfectoIncrementarMovimientosPorcentual(efecto, porcentajeIncremento);
    }
}
