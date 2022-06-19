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
    private Casillero casilleroInicial = new Casillero(fila, columna);
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void seCreaUnjuegoYnoEstaVacio() {
        Vehiculo moto = new Moto(casilleroInicial);
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
        Vehiculo moto = new Moto(casilleroInicial);
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
        Vehiculo moto = new Moto(casilleroInicial);
        Jugador jugador1 = new Jugador(nombre, moto);
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo auto = new Auto(casillero);
        Jugador jugador2 = new Jugador(nombre, auto);
        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
        }};
        Juego juego = new Juego(jugadores);

        for(int i = 0; i < 4; i++) {
            juego.moverVehiculo(new DireccionDerecha()); // 4 Movimientos a la derecha
        }
        int nuevaColumna = 3;
        Casillero nuevoCasillero = new Casillero(fila, nuevaColumna);

        assertTrue(moto.verificarCasillero(nuevoCasillero));
        assertTrue(auto.verificarCasillero(nuevoCasillero));
    }


    @Test
    public void seCreaUnJuegoCon3JugadoresYSeCambiaCorrectamenteDeJugadorActivoAlMoverse() {
        Vehiculo moto = new Moto(casilleroInicial);
        Jugador jugador1 = new Jugador(nombre, moto);
        Casillero casillero1 = new Casillero(fila, columna);
        Vehiculo auto = new Auto(casillero1);
        Jugador jugador2 = new Jugador(nombre, auto);
        Casillero casillero2 = new Casillero(fila, columna);
        Vehiculo auto2 = new Auto(casillero2);
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
    public void seCreaUnJuegoCon3JugadoresYSeMuevenLasPosicionesDeberianSerIndependientes() {
        Vehiculo moto = new Moto(casilleroInicial);
        Jugador jugador1 = new Jugador(nombre, moto);

        Casillero casillero1 = new Casillero(fila, columna);
        Vehiculo auto = new Auto(casillero1);
        Jugador jugador2 = new Jugador(nombre, auto);

        Casillero casillero2 = new Casillero(fila, columna);
        Vehiculo auto2 = new Auto(casillero2);
        Jugador jugador3 = new Jugador(nombre, auto2);
        Escenario.resetInstance(totalFilas, totalColumnas);
        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
            add(jugador3);
        }};
        Juego juego = new Juego(jugadores);

        for(int i = 0; i < 4; i++) {
            juego.moverVehiculo(new DireccionDerecha()); // 4 Movimientos a la derecha
        }
        juego.moverVehiculo(new DireccionAbajo());
        
        Casillero casilleroDeJugador1 = new Casillero(1, 3);
        Casillero casilleroDeJugador2 = new Casillero(2, 2);
        Casillero casilleroDeJugador3 = new Casillero(1, 2);

        assertTrue(moto.verificarCasillero(casilleroDeJugador1));
        assertTrue(auto.verificarCasillero(casilleroDeJugador2));
        assertTrue(auto2.verificarCasillero(casilleroDeJugador3));
    }
}