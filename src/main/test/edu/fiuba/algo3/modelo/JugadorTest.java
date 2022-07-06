package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void seCreaUnJugadorDeberiaDevolverElNombreYSusMovimientosCorrectamente(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int movimentosIniciales = 0;

        assertEquals(jugador.nombre(), nombre);
        assertTrue(jugador.verificarMovimientos(movimentosIniciales));
    }

    @Test
    public void seAumentanLosMovimientosDeUnJugadorEn3DeberiaDevolverQueSusMovimientosSon3(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int incremento = 3;

        jugador.incrementarMovimientos(incremento);

        assertTrue(jugador.verificarMovimientos(incremento));
    }

    @Test
    public void seAumentanLosMovimientosDeUnJugadorEn4YLuegoSeReducenEn3DeberiaTener1Movimiento(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int incremento = 4;
        int reduccion = 3;
        int totalMovimientos = incremento - reduccion;

        jugador.incrementarMovimientos(incremento);
        jugador.reducirMovimientos(reduccion);

        assertTrue(jugador.verificarMovimientos(totalMovimientos));
    }

}
