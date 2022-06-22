package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Jugador jugadorActivo;
    private int numJugador;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.numJugador = 0;
        this.jugadorActivo = jugadores.get(numJugador);
    }

    public void moverVehiculo(Direccion direccion){
        this.jugadorActivo.moverVehiculo(direccion);
        this.cambiarJugador();
    }

    public void cambiarJugador(){
        this.numJugador++;
        if(numJugador >= jugadores.size()) {
            this.numJugador = 0;
        }
        this.jugadorActivo = jugadores.get(numJugador);
    }


    // Se usa para tests
    public boolean verificarMovJugadorActivo(int movimientosEsperados){
        return (this.jugadorActivo.verificarMovimiento(movimientosEsperados));
    }

    // Se usa para tests
    public boolean verificarAtributosNoNulos(){
        return (this.jugadores != null & this.jugadorActivo != null);
    }

    // Se usa para tests
    public boolean verificarJugadorActivo(Jugador jugador) {
        return this.jugadorActivo == jugador;
    }
}
