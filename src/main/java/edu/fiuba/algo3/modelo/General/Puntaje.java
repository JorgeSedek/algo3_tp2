package edu.fiuba.algo3.modelo.General;

public class Puntaje {

    private String nombreJugador;

    private int puntuacion;

    public Puntaje(Jugador jugador){
        this.nombreJugador = jugador.obtenerNombre();
        this.puntuacion = jugador.obtenerMovimientos();
    }

    /*
    DE MOMENTO NO SE UTILIZAN

    public String obtenerNombre(){
        return this.nombreJugador;
    }

    public int obtenerPuntuacion(){
        return this.puntuacion;
    }
    */
}
