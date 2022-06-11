package edu.fiuba.algo3.modelo;

public class Juego {
    private Escenario escenario;
    private Jugador jugador;

    public Juego(String nombre, Vehiculo vehiculo, int filas, int columnas) {
        escenario = new Escenario(filas, columnas);
        jugador = new Jugador(nombre, vehiculo, escenario);
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
