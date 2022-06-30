package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Efecto.Efecto;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Jugador jugadorActivo;
    private int numJugador;
    private List<Puntaje> puntuaciones;
    private static Juego INSTANCE = null;

    private Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.numJugador = 0;
        this.jugadorActivo = jugadores.get(numJugador);
        this.puntuaciones = new ArrayList<Puntaje>();
    }

    private synchronized static void createInstance(List<Jugador> jugadores) {
        INSTANCE = new Juego(jugadores);
    }

    public static Juego getInstance() {
        return INSTANCE; // Cuidado que si no se llamo primero al resetInstance, devuelve un null
    }

    // Resetea el juego a un estado inicial (con un array de jugadores)
    public static void resetInstance(List<Jugador> jugadores) {
        createInstance(jugadores);
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
        // puntuaciones.sort();
        // Metodo que ordene la lista de puntuaciones de menor a mayor
    }

    public List<Puntaje> obtenerPuntajes() {
        return puntuaciones;
    }

    // Deberia llevarnos a la pantalla de puntuaciones, donde se muestran los
    // por ejemplo, 10 puntajes mas altos (o quiza que devuelva un array
    // con los puntajes ya ordenados)
    private void mostrarTopPuntuaciones() {
        System.out.println("Felicidades, llegaste a la meta!"); // Momentaneo
    }


    // Se usa para tests
    public boolean verificarMovJugadorActivo(int movimientosEsperados){
        return (this.jugadorActivo.verificarMovimientos(movimientosEsperados));
    }

    // Se usa para tests
    public boolean verificarAtributosNoNulos(){
        return (this.jugadores != null & this.jugadorActivo != null);
    }

    // Se usa para tests
    public boolean verificarJugadorActivo(Jugador jugador) {
        return this.jugadorActivo == jugador;
    }

    public boolean verificarUbicacionJugadorActivo(Ubicacion ubicacion){
        return jugadorActivo.verificarUbicacion(ubicacion);
    }
}
