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

        Direccion origen = new Direccion(2,1);
        Direccion destino = new Direccion(3,4);

        juego.iniciarJuego(origen); // Posiciona al vehiculo en origen

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        
        assertEquals(juego.obtenerUbicacionJugador(), "3-4");




        /*
        juego.moverVehiculo(origen); // Inicializamos vehiculo en la posicion 1-1

        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        juego.moverVehiculo(destino); // Me muevo a la entrecalle de la derecha (pasando por una calle)

        assertEquals(juego.obtenerJugador().puntaje(), -3);
        */
    }
}
