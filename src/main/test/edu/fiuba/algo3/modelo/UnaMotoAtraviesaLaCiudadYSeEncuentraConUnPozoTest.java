package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoTest {

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        Moto vehiculo = new Moto();
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        juego.moverVehiculo("11"); /* Inicializamos vehiculo en la posicion 1-1 */
        // 1-1 es la esquina superior izquierda

        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        juego.moverVehiculo("12"); // Me muevo a la entrecalle de la derecha

        assertEquals(juego.obtenerJugador().puntaje(), -3);
    }
}
