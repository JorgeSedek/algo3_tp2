package edu.fiuba.algo3.modelo.General;

public class Puntaje {
    private String nombreJugador;

    private int puntuacion;

    public Puntaje(Jugador jugador){
        this.nombreJugador = jugador.nombre();
        this.puntuacion = jugador.movimientos();
    }

    public String obtenerNombreJugador() {
        return this.nombreJugador;
    }

    public int obtenerPuntuacion() {
        return this.puntuacion;
    }

}
