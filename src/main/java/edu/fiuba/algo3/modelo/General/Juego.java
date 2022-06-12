package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

public class Juego {
    private Escenario escenario;
    private Jugador jugador;

    public Juego(Escenario escenario, Jugador jugador) {
        this.escenario = escenario;
        this.jugador = jugador;
    }

    public void moverVehiculo(Direccion direccion){
        this.jugador.moverVehiculo(direccion);
    }

    public Jugador obtenerJugador () {
        return this.jugador;
    }

    public Ubicacion obtenerUbicacionJugador () {
        return this.jugador.obtenerUbicacion();
    }
}
