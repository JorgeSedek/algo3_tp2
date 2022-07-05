package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Juego {
    private final List<Jugador> JUGADORES;
    private Jugador jugadorActivo;
    private int numJugador;
    private final List<Puntaje> PUNTUACIONES;
    private static Juego INSTANCE = null;

    private Juego(List<Jugador> jugadores) {
        this.JUGADORES = jugadores;
        this.numJugador = 0;
        this.jugadorActivo = jugadores.get(numJugador);
        this.PUNTUACIONES = new ArrayList<>();
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
        //System.out.println("Se mueve el vehiculo en la direccion: " + direccion.getClass()); //TODO SACAR, ES PARA DEBUGEAR EL MOVIMIENTO DEL VEHICULO
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
        this.agregarPuntuacion(jugadorActivo);
        this.JUGADORES.remove(jugadorActivo);
        if(this.JUGADORES.size() == 0) {
            this.jugadorActivo = null;
            this.mostrarTopPuntuaciones();
        }
    }

    // Devuelve true si hay jugadores activos
    public boolean hayJugadoresActivos(){
        return !(this.JUGADORES.size() == 0);
    }

    private void agregarPuntuacion(Jugador jugador) {
        Puntaje puntaje = jugador.obtenerPuntaje();
        PUNTUACIONES.add(puntaje);
    }

    public List<Puntaje> obtenerPuntajes() {
        return PUNTUACIONES;
    }

    private void mostrarTopPuntuaciones() {
        Logger.getInstance().imprimir("--------------------------------------------------------------------");
        Logger.getInstance().imprimir("Tabla de puntuaciones");
        Collections.sort(PUNTUACIONES, new OrdenarPorMovimientos());
        for(Puntaje puntaje : this.PUNTUACIONES) {
            Logger.getInstance().imprimir(puntaje.obtenerNombreJugador() + ' ' + puntaje.obtenerPuntuacion());
        }
        Logger.getInstance().imprimir("¡Felicidades " + PUNTUACIONES.get(0).obtenerNombreJugador() + ", ganaste!");
    }

    // Metodos para tests
    public boolean verificarMovJugadorActivo(int movimientosEsperados){
        return (this.jugadorActivo.verificarMovimientos(movimientosEsperados));
    }

    public boolean verificarAtributosNoNulos(){
        return (this.JUGADORES != null & this.jugadorActivo != null);
    }

    public boolean verificarJugadorActivo(Jugador jugador) {
        return this.jugadorActivo == jugador;
    }

    public boolean verificarUbicacionJugadorActivo(Ubicacion ubicacion){
        return jugadorActivo.verificarUbicacion(ubicacion);
    }

    public boolean verificarVehiculoJugadorActivo(Vehiculo vehiculo){
        return jugadorActivo.mismoVehiculo(vehiculo);
    }

    public Jugador obtenerJugadorActivo(){
        return this.jugadorActivo;
    }

}


