package edu.fiuba.algo3.modelo;

public class Jugador {

    private int puntaje;
    private Vehiculo vehiculo;
    private String nombre;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.puntaje = 0;
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
    }

    public void tuTurno(Direccion direccion){
        this.vehiculo.mover(direccion);
    }

    public int puntaje(){return this.puntaje;}

    public void aumentarPuntaje(int incremento){this.puntaje += incremento;}

    public void restarPuntaje(int disminuir){this.puntaje -= disminuir;}

    public String obtenerNombre(){return this.nombre;}
}

