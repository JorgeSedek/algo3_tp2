package edu.fiuba.algo3.modelo.General;

public class Puntaje {
    private final String NOMBREJUGADOR;

    private final int PUNTUACION;

    public Puntaje(String nombre, int movimientos){
        this.NOMBREJUGADOR = nombre;
        this.PUNTUACION = movimientos;
    }

    public String obtenerNombreJugador() {
        return this.NOMBREJUGADOR;
    }

    public int obtenerPuntuacion() {
        return this.PUNTUACION;
    }
}
