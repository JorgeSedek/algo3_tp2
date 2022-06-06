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

        switch (movimiento){
            case "derecha":
                this.ubicacion.incrementarColumna();
                this.jugador.moverVehiculo(this.ubicacion);
            break;
            case "izquierda":
                this.ubicacion.disminuirColumna();
                this.jugador.moverVehiculo(this.ubicacion);
            break;
            case "abajo":
                this.ubicacion.incrementarFila();
                this.jugador.moverVehiculo(this.ubicacion);
            break;
            case "arriba":
                this.ubicacion.disminuirFila();
                this.jugador.moverVehiculo(this.ubicacion);
            break;
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
