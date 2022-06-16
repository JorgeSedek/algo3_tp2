package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    private String nombre = "Tomas";
    private String nombre2 = "Juan";

    private int fila = 1;
    private int columna = 1;
    private int fila2 = 2;
    private int columna2 = 2;

    private Jugador jugador2 = new Jugador(nombre2, new Moto(new Casillero(new Ubicacion(fila2, columna2))));
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void seCreaUnjuegoYnoEstaVacio() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        assertNotNull(juego);
    }

    @Test
    public void seCambiaElJugadorYJugadoresCambianTurno() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        assertTrue(juego.compararJugadorActivo(jugador));
        assertTrue(juego.compararJugadorEspera(jugador2));
        juego.cambioJugador();
        assertTrue(juego.compararJugadorActivo(jugador2));
        assertTrue(juego.compararJugadorEspera(jugador));
    }


    @Test
    public void seMueveJugadorSeCambiaJugadorYlosMovimientosSonLosCorrectos() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        juego.moverVehiculo(new DireccionDerecha());
        juego.moverVehiculo(new DireccionDerecha());
        int movimientosEsperados = 2;
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
        juego.cambioJugador();
        juego.moverVehiculo(new DireccionArriba());
        movimientosEsperados = 1;
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));

    }
}
