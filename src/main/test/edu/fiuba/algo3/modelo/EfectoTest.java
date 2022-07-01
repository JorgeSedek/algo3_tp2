package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Efecto.*;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EfectoTest {
    private int fila = 1;
    private int columna = 1;
    Ubicacion ubicacion = (new Ubicacion(fila, columna));
    @Test
    public void seIncrementanLosMovimientosDeUnVehiculoEn30YSeReducenEn10DeberiaTener20Movimientos() {
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador("Martin", moto);

        Efecto efecto = new EfectoGeneral();
        efecto = new EfectoIncrementarMovimientos(efecto, 30); // Se acumulan los efectos
        efecto = new EfectoReducirMovimientos(efecto, 10);

        efecto.aplicar(jugador); // Se deberian aplicar todos los efectos y en orden

        assertTrue(jugador.verificarMovimientos(20));
    }
}