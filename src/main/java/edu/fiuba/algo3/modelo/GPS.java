package edu.fiuba.algo3.modelo;

public class GPS {
    private Escenario escenario;
    private Jugador jugador;

    public GPS (String nombre, Vehiculo vehiculo, int filas, int columnas) {
        escenario = new Escenario(filas, columnas);
        jugador = new Jugador(nombre, vehiculo);
    }
    public void moverVehiculo(Direccion direccion){
        this.jugador.moverVehiculo(direccion);
    }


    public Jugador obtenerJugador () {
        return this.jugador;
    }

    public String obtenerUbicacionJugador () {
        return this.jugador.obtenerUbicacion().asString();
    }
}
