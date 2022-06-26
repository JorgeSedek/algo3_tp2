package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Efecto.*;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

public class EfectoTest {
    private int fila = 1;
    private int columna = 1;
    Ubicacion ubicacion = (new Ubicacion(fila, columna));
    @Test
    public void seIncrementanLosMovimientosDeUnVehiculoEn30YSeReducenEn20DeberiaTener10Movimientos() {
        Vehiculo moto = new Moto(ubicacion);

        Efecto efecto = new EfectoGeneral();
        efecto = new EfectoIncrementarMovimientos(efecto, 30);
        efecto = new EfectoReducirMovimientos(efecto, 10);

    }
}
