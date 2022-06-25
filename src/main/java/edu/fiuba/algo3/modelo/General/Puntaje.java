package edu.fiuba.algo3.modelo.General;

public class Puntaje {

    private String nombreJugador;

    private int puntuacion;

    public Puntaje(Jugador jugador){
        this.nombreJugador = jugador.obtenerNombre();
        this.puntuacion = convertirMovimientosAPuntaje(jugador.obtenerMovimientos());
    }

    // Convierte los movimientos de un jugador a un puntaje y lo devuelve
    private int convertirMovimientosAPuntaje(int movimientos) {
        int puntuacionBase = 1000;
        return puntuacionBase - movimientos; // A mayor movimientos, menor la puntuacion
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
