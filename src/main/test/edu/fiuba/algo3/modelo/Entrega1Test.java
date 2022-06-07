package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        Moto vehiculo = new Moto();

        // El vehiculo se inicializa en la posicion 1-1
        GPS gps = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        Direccion destino = new Direccion(2,4);

        for (int i = 0; i < 3; i++) {
            gps.moverVehiculo("derecha");
        }
        gps.moverVehiculo("abajo");
        pozo.pasarObstaculo(vehiculo, gps.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(gps.obtenerUbicacionJugador(), destino.asString());
        assertEquals(gps.obtenerJugador().movimientos(), 7);
    }

    /*
    @Test
    public void UnaMotoSeMueveIzquierdaSeEncuentraConUnPozo (){
        Escenario escenario = new Escenario(4,4);
        Calle calle = escenario.entreCalle("1-1").obtenerCalleIzquierda();
        Obstaculo pozo = new Pozo();
        calle.asignarObstaculo(pozo);
        Moto moto = new Moto();
        moto.mover(new Direccion());
        Jugador jugador = new Jugador("jorge", moto);
        moto.moverIzquierda(escenario).pasarObstaculo(moto,jugador);
        assertEquals(jugador.puntaje(),-3);
    }
*/
    @Test
    public void UnAutoAtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        Auto vehiculo = new Auto();

        // El vehiculo se inicializa en la posicion 1-1
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        Direccion destino = new Direccion(2,4);

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().movimientos(), 7);

    }

    @Test
    public void Una4x4AtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        CuatroXCuatro vehiculo = new CuatroXCuatro();

        // El vehiculo se inicializa en la posicion 1-1
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Pozo pozo = new Pozo();

        Direccion destino = new Direccion(2,4);

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().movimientos(), 4);

    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPiquete() {
        String nombre = "Cristian";
        Moto vehiculo = new Moto();

        // El vehiculo se inicializa en la posicion 1-1
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Piquete piquete = new Piquete();

        Direccion destino = new Direccion(2,4);

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        piquete.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().movimientos(), 6);

    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPiqueteYPozo(){
        String nombre = "Cristian";
        Moto vehiculo = new Moto();
        
        // El vehiculo se inicializa en la posicion 1-1
        GPS juego = new GPS(nombre, vehiculo, 8, 8);
        Piquete piquete = new Piquete();
        Pozo pozo = new Pozo();

        Direccion destino = new Direccion(2,4);

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo("derecha");
        }
        juego.moverVehiculo("abajo");
        piquete.pasarObstaculo(vehiculo, juego.obtenerJugador());
        pozo.pasarObstaculo(vehiculo, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertEquals(juego.obtenerUbicacionJugador(), destino.asString());
        assertEquals(juego.obtenerJugador().movimientos(), 9);
    }
/*
    Test
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
    */

}
