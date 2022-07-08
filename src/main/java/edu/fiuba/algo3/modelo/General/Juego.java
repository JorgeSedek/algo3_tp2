package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

import java.util.List;

public class Juego {
    private final List<Jugador> JUGADORES;
    private Jugador jugadorActivo;
    private int numJugador;
    private static Juego INSTANCE = null;

    private Juego(List<Jugador> jugadores) {
        this.JUGADORES = jugadores;
        this.numJugador = 0;
        this.jugadorActivo = jugadores.get(numJugador);
    }

    private synchronized static void createInstance(List<Jugador> jugadores) {
        INSTANCE = new Juego(jugadores);
    }

    public static Juego getInstance() {
        return INSTANCE;
    }

    public static void resetInstance(List<Jugador> jugadores) {
        createInstance(jugadores);
    }

    public void moverVehiculo(Direccion direccion){
        if (jugadorActivo == null) {
            System.out.println("No quedan jugadores activos, no se realiza movimiento");
            return;
        }
        this.jugadorActivo.moverVehiculo(direccion);
        this.cambiarJugador();
    }

    public void cambiarJugador(){
        if(JUGADORES.size() > 0) {
            this.numJugador++;
            if (numJugador >= JUGADORES.size()) {
                this.numJugador = 0;
            }
            this.jugadorActivo = JUGADORES.get(numJugador);
        }
    }

    public void finalizar() {
        Logger.getInstance().imprimir("¡Felicidades " + this.jugadorActivo.nombre() + ", llegaste a la meta!");
        Ranking.getInstance().agregarPuntaje(this.jugadorActivo.obtenerPuntaje());
        this.JUGADORES.remove(jugadorActivo);
        if(this.JUGADORES.size() == 0) {
            this.jugadorActivo = null;
            Ranking.getInstance().mostrarRanking();
        }
    }

    public boolean hayJugadoresActivos(){
        return !(this.JUGADORES.size() == 0);
    }

    // Metodo para tests
    public boolean verificarMovJugadorActivo(int movimientosEsperados){
        return (this.jugadorActivo.verificarMovimientos(movimientosEsperados));
    }

    // Metodo para tests
    public boolean verificarAtributosNoNulos(){
        return (this.JUGADORES != null & this.jugadorActivo != null);
    }

    // Metodo para tests
    public boolean verificarJugadorActivo(Jugador jugador) {
        return this.jugadorActivo == jugador;
    }

    public Jugador obtenerJugadorActivo(){
        return this.jugadorActivo;
    }

}


