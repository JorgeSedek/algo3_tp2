package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void seCreaUnJugadorDeberiaDevolverElNombreYSusMovimientosCorrectamente(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Jugador jugador = new Jugador(nombre,new Auto(ubicacion, new MovimientoNormal()));
        int movimentosIniciales = 0;

        assertEquals(jugador.obtenerNombre(), nombre);
        assertTrue(jugador.verificarMovimiento(movimentosIniciales));
    }

    @Test
    public void seAumentanLosMovimientosDeUnJugadorEn3DeberiaDevolverQueSusMovimientosSon3(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Jugador jugador = new Jugador(nombre,new Auto(ubicacion, new MovimientoNormal()));
        int incremento = 3;
        jugador.incrementarMovimientos(incremento);

        assertTrue(jugador.verificarMovimiento(incremento));
    }

    @Test
    public void seAumentaElPuntajeDeUnJugadorEn4YLuegoSeReduceEn3DeberiaTener1Movimiento(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Jugador jugador = new Jugador(nombre,new Auto(ubicacion, new MovimientoNormal()));
        int incremento = 4;
        int reduccion = 3;
        int totalMovimientos = incremento - reduccion;
        jugador.incrementarMovimientos(incremento);
        jugador.disminuirMovimientos(reduccion);

        assertTrue(jugador.verificarMovimiento(totalMovimientos));
    }
}
