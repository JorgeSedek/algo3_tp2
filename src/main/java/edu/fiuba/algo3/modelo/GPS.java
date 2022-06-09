package edu.fiuba.algo3.modelo;

public class GPS {
    private Escenario escenario;
    private Jugador jugador;

    public GPS (String nombre, Vehiculo vehiculo, int filas, int columnas) {
        escenario = new Escenario(filas, columnas);
        jugador = new Jugador(nombre, vehiculo);
    }

    public void moverVehiculoDerecha () {
        this.jugador.moverVehiculoDerecha();
    }
    public void moverVehiculoIzquierda () {
        this.jugador.moverVehiculoIzquierda();
    }

    public void moverVehiculoAbajo () {
        this.jugador.moverVehiculoAbajo();
    }

    public void moverVehiculoArriba () {
        this.jugador.moverVehiculoArriba();
    }

    public Jugador obtenerJugador () {
        return this.jugador;
    }

    public String obtenerUbicacionJugador () {
        return this.jugador.obtenerUbicacion().asString();
    }
}
