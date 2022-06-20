package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Efecto.*;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EfectoTest {
    private int fila = 1;
    private int columna = 1;
    private Casillero casilleroInicial = new Casillero(fila, columna);

    @Test
    public void seIncrementanLosMovimientosDeUnVehiculoEn30YSeReducenEn20DeberiaTener10Movimientos() {
        Vehiculo moto = new Moto(casilleroInicial);

        Efecto efecto = new EfectoGeneral();
        efecto = new EfectoIncrementarMovimientos(efecto, 30);
        efecto = new EfectoReducirMovimientos(efecto, 10);
        efecto.aplicar(moto);

        assertEquals(moto.movimientos(), 20);
    }
}
