package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Jugador jugadorActivo;
    private int numJugador;

    private List<Puntaje> puntuaciones;

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

    // Finaliza el juego, agrega la puntuacion del jugador y nos lleva a la pantalla de puntuaciones
    public void finalizar() {
        this.agregarPuntuacion(jugadorActivo);
        this.mostrarTopPuntuaciones();
    }

    // Agrega la puntuacion de un jugador a las puntuaciones
    private void agregarPuntuacion(Jugador jugador) {
        Puntaje puntaje = jugador.obtenerPuntaje();
        puntuaciones.add(puntaje);
    }

    // Deberia llevarnos a la pantalla de puntuaciones, donde se muestran los
    // por ejemplo, 10 puntajes mas altos
    private void mostrarTopPuntuaciones() {

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
