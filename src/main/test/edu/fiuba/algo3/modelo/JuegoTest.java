package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    private String nombre = "Tomas";
    private int fila = 1;
    private int columna = 1;
    private Ubicacion ubicacionInicial = new Ubicacion(fila, columna);
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void seCreaUnjuegoYnoEstaVacio() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);

        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
        }};
        Juego juego = new Juego(jugadores);

        assertNotNull(juego);
    }

    @Test
    public void seCreaJuegoYlosAtributoNoSonNulos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);

        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
        }};
        Juego juego = new Juego(jugadores);

        assertTrue(juego.verificarAtributosNoNulos());
    }

    @Test

    public void seCreaUnJuegoCon2JugadoresYSeMuevenDeberianEstarEnLaMismaPosicion() {
        Vehiculo moto = new Moto(ubicacionInicial);
        Jugador jugador1 = new Jugador(nombre, moto);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador2 = new Jugador(nombre, auto);
        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
        }};
        Juego juego = new Juego(jugadores);

        for (int i = 0; i < 4; i++) {
            juego.moverVehiculo(new DireccionDerecha()); // 4 Movimientos a la derecha
        }
        int nuevaColumna = 3;
        Ubicacion nuevaUbicacion = new Ubicacion(fila, nuevaColumna);

        assertTrue(moto.verificarUbicacion(nuevaUbicacion));
        assertTrue(auto.verificarUbicacion(nuevaUbicacion));
    }

    @Test
    public void seHaceCambioDeJugadoresYatributosSiguenSiendoNoNulos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        Jugador jugador2 = new Jugador(nombre, moto);
        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
        }};
        Juego juego = new Juego(jugadores);

        juego.cambioJugador();

        assertTrue(juego.verificarAtributosNoNulos());

    }
    @Test
    public void seCreaUnJuegoCon3JugadoresYSeCambiaCorrectamenteDeJugadorActivoAlMoverse() {
        Vehiculo moto = new Moto(ubicacionInicial);
        Jugador jugador1 = new Jugador(nombre, moto);
        Ubicacion ubicacion1 = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion1);
        Jugador jugador2 = new Jugador(nombre, auto);
        Ubicacion ubicacion2 = new Ubicacion(fila, columna);
        Vehiculo auto2 = new Auto(ubicacion2);
        Jugador jugador3 = new Jugador(nombre, auto2);

        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
            add(jugador3);
        }};
        Juego juego = new Juego(jugadores);

        // Act and Assert
        assertTrue(juego.verificarJugadorActivo(jugador1));
        juego.moverVehiculo(new DireccionDerecha());
        assertTrue(juego.verificarJugadorActivo(jugador2));
        juego.moverVehiculo(new DireccionDerecha());
        assertTrue(juego.verificarJugadorActivo(jugador3));
        juego.moverVehiculo(new DireccionDerecha());
        assertTrue(juego.verificarJugadorActivo(jugador1));
    }

    @Test
    public void seCreaUnJuegoCon3JugadoresYLuegoDeMoverseLasUbicacionesSonIndependientesEntreLosJugadores() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);

        Ubicacion ubicacion1 = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion1);
        Jugador jugador2 = new Jugador(nombre, auto);

        Ubicacion ubicacion2 = new Ubicacion(fila, columna);
        Vehiculo auto2 = new Auto(ubicacion2);
        Jugador jugador3 = new Jugador(nombre, auto2);
        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
            add(jugador3);
        }};
        Juego juego = new Juego(jugadores);

        for (int i = 0; i < 4; i++) {
            juego.moverVehiculo(new DireccionDerecha()); // 4 Movimientos a la derecha
        }
        juego.moverVehiculo(new DireccionAbajo());

        Ubicacion ubicacionEsperadaDeJugador1 = new Ubicacion(1, 3);
        Ubicacion ubicacionEsperadaDeJugador2 = new Ubicacion(2, 2);
        Ubicacion ubicacionEsperadaDeJugador3 = new Ubicacion(1, 2);

        assertTrue(moto.verificarUbicacion(ubicacionEsperadaDeJugador1));
        assertTrue(auto.verificarUbicacion(ubicacionEsperadaDeJugador2));
        assertTrue(auto2.verificarUbicacion(ubicacionEsperadaDeJugador3));
    }
}
