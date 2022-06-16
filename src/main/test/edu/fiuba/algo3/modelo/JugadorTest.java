package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void seCreaUnJugadorDeberiaDevolverElNombreYSusMovimientosCorrectamente(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(casillero);
        Jugador jugador = new Jugador(nombre, auto);
        int movimentosIniciales = 0;

        assertEquals(jugador.obtenerNombre(), nombre);
        assertTrue(jugador.verificarMovimiento(movimentosIniciales));
    }

    @Test
    public void seAumentanLosMovimientosDeUnJugadorEn3DeberiaDevolverQueSusMovimientosSon3(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(casillero);
        Jugador jugador = new Jugador(nombre, auto);
        int incremento = 3;
        jugador.incrementarMovimientos(incremento);

        assertTrue(jugador.verificarMovimiento(incremento));
    }

    @Test
    public void seAumentanLosMovimientosDeUnJugadorEn4YLuegoSeReducenEn3DeberiaTener1Movimiento(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(casillero);
        Jugador jugador = new Jugador(nombre, auto);
        int incremento = 4;
        int reduccion = 3;
        int totalMovimientos = incremento - reduccion;
        jugador.incrementarMovimientos(incremento);
        jugador.disminuirMovimientos(reduccion);

        assertTrue(jugador.verificarMovimiento(totalMovimientos));
    }
}
