package edu.fiuba.algo3.modelo;

public class GPS {
    private Escenario escenario;
    private Jugador jugador;

    private Direccion ubicacion; // La ubicacion actual del jugador

    public GPS (String nombre, Vehiculo vehiculo, int filas, int columnas) {
        escenario = new Escenario(filas, columnas);
        jugador = new Jugador(nombre, vehiculo);
    }
    public void moverVehiculo (String movimiento) {
        if (movimiento == "derecha") {
            this.ubicacion.incrementarColumna();
            this.jugador.moverVehiculo(this.ubicacion);
        }

        if (movimiento == "izquierda") {
            this.ubicacion.disminuirColumna();
            this.jugador.moverVehiculo(this.ubicacion);
        }

        if (movimiento == "abajo") {
            this.ubicacion.incrementarFila();
            this.jugador.moverVehiculo(this.ubicacion);
        }

        if (movimiento == "arriba") {
            this.ubicacion.disminuirFila();
            this.jugador.moverVehiculo(this.ubicacion);
        }

    }

    public Jugador obtenerJugador () {
        return this.jugador;
    }

    public String obtenerUbicacionJugador () {
        return this.ubicacion.asString();
    }

     public void iniciarJuego (Direccion direccion) {
        this.ubicacion = direccion;
        this.jugador.moverVehiculo(direccion);
     }

}
