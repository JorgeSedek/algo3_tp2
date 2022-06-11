package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void seCreaCorrectamenteLaClaseJugador(){
        String nombre = "Pablo";
        int fila = 4;
        int columna = 4;
        Jugador jugador = new Jugador(nombre,new Auto(), new Escenario(fila, columna));
        assertEquals(jugador.obtenerNombre(),nombre);
        assertEquals(jugador.movimientos(),0);
    }

    @Test
    public void seAumentaCorrectamenteElPuntaje(){
        int incremento = 3;
        int fila = 4;
        int columna = 4;
        Jugador jugador = new Jugador("Pablo", new Auto(), new Escenario(fila, columna));
        jugador.incrementarMovimientos(incremento);
        assertEquals(jugador.movimientos(), incremento);
    }

    @Test
    public void seReduceCorrectamenteElPuntaje(){
        int reducir = 3;
        int fila = 4;
        int columna = 4;
        Jugador jugador = new Jugador("Pablo", new Auto(), new Escenario(fila, columna));
        jugador.disminuirMovimientos(reducir);
        assertEquals(jugador.movimientos(),-3);
    }
}
