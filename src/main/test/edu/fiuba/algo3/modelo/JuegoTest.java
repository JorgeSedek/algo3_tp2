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

        for(int i = 1; i <= 4; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        int nuevaColumna = 3;
        Casillero nuevoCasillero = new Casillero(fila, nuevaColumna);

        assertTrue(moto.verificarCasillero(nuevoCasillero));
        assertTrue(auto.verificarCasillero(nuevoCasillero));
    }
}