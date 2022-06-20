package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void seComparanDosJUgadoresYsonElmismo(){
        String nombre2 = nombre;
       Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Vehiculo auto2 = auto;
        Jugador jugador = new Jugador(nombre, auto);
        Jugador jugador2 = new Jugador(nombre2, auto2);
        assertTrue(jugador.equals(jugador2));
    }

    @Test
    public void seComparanDosJUgadoresYNosonElmismo(){
        String nombre2 = "Jorge";
       Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Vehiculo auto2 = auto;
        Jugador jugador = new Jugador(nombre, auto);
        Jugador jugador2 = new Jugador(nombre2, auto2);
        assertFalse(jugador.equals(jugador2));
    }

    @Test
    public void seCreaUnJugadorDeberiaDevolverElNombreYSusMovimientosCorrectamente(){
       Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int movimentosIniciales = 0;

        assertEquals(jugador.obtenerNombre(), nombre);
        assertTrue(jugador.verificarMovimiento(movimentosIniciales));
    }

    @Test
    public void seAumentanLosMovimientosDeUnJugadorEn3DeberiaDevolverQueSusMovimientosSon3(){
       Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int incremento = 3;
        jugador.incrementarMovimientos(incremento);

        assertTrue(jugador.verificarMovimiento(incremento));
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
        jugador.disminuirMovimientos(reduccion);

        assertTrue(jugador.verificarMovimiento(totalMovimientos));
    }

}
