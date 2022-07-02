package edu.fiuba.algo3.modelo.General;

public class Puntaje {
    private final String NOMBREJUGADOR;

    private final int PUNTUACION;

    public Puntaje(Jugador jugador){
        this.NOMBREJUGADOR = jugador.nombre();
        this.PUNTUACION = jugador.movimientos();
    }

    public String obtenerNombreJugador() {
        return this.NOMBREJUGADOR;
    }

    public int obtenerPuntuacion() {
        return this.PUNTUACION;
    }
}
