package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Jugador jugadorActivo;
    private int numJugador;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.numJugador = 1;
        this.jugadorActivo = jugadores.get(numJugador-1);
    }

    public void moverVehiculo(Direccion direccion){
        this.jugadorActivo.moverVehiculo(direccion);
        this.cambioJugador();
    }

    private void cambioJugador(){
        this.numJugador++;
        if(numJugador > jugadores.size()) {
            this.numJugador = 1;
        }
        this.jugadorActivo = jugadores.get(numJugador-1);
    }

    public boolean verificarMovJugadorActivo(int movimientosEsperados){
        return (this.jugadorActivo.verificarMovimiento(movimientosEsperados));
    }

    public boolean verificarAtributosNoNulos(){
        return (this.jugadores != null & this.jugadorActivo != null);
    }
}
