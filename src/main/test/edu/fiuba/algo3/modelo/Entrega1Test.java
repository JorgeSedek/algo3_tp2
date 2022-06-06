package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

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
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().puntaje(), -3);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        Auto vehiculo = new Auto();
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        Direccion origen = new Direccion(2,1);
        Direccion destino = new Direccion(3,4);

        juego.iniciarJuego(origen); // Posiciona al vehiculo en origen

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().puntaje(), -3);

    }

    @Test
    public void Una4x4AtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        Direccion origen = new Direccion(2,1);
        Direccion destino = new Direccion(3,4);

        juego.iniciarJuego(origen); // Posiciona al vehiculo en origen

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().puntaje(), -2);

    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPiquete() {
        String nombre = "Cristian";
        Moto vehiculo = new Moto();
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Piquete piquete = new Piquete();

        Direccion origen = new Direccion(2,1);
        Direccion destino = new Direccion(3,4);

        juego.iniciarJuego(origen); // Posiciona al vehiculo en origen

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        piquete.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().puntaje(), -2);

    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPiqueteYPozo(){
        String nombre = "Cristian";
        Moto vehiculo = new Moto();
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Piquete piquete = new Piquete();
        Pozo pozo = new Pozo();

        Direccion origen = new Direccion(2,1);
        Direccion destino = new Direccion(3,4);

        juego.iniciarJuego(origen); // Posiciona al vehiculo en origen

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        piquete.pasarObstaculo(vehiculo, juego.obtenerJugador());
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().puntaje(), -5);
    }

    @Test
    public void Una4X4PasaPorPozoMultiplesVeces(){
        String nombre = "Cristian";
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        Direccion origen = new Direccion(2,1);
        Direccion destino = new Direccion(3,4);

        juego.iniciarJuego(origen); // Posiciona al vehiculo en origen

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");

        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().puntaje(), -7);
    }
}
