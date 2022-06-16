package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

public class Juego {
    private Escenario escenario;
    private Jugador jugadorActivo;
    private Jugador jugadorEspera;

    public Juego(Escenario escenario, Jugador jugador1, Jugador jugador2) {
        this.escenario = escenario;
        this.jugadorActivo = jugador1;
        this.jugadorEspera = jugador2;
    }

    public void moverVehiculo(Direccion direccion){
        this.jugadorActivo.moverVehiculo(direccion);
    }

    public void cambioJugador(){
        Jugador jugadorAux = this.jugadorEspera;
        this.jugadorEspera = this.jugadorActivo;
        this.jugadorActivo = jugadorAux;
    }

    public boolean compararJugadorActivo(Jugador jugadorEsperado){
        return (this.jugadorActivo.equals(jugadorEsperado));
    }

    public boolean compararJugadorEspera(Jugador jugadorEsperado){
        return (this.jugadorEspera.equals(jugadorEsperado));
    }

    public boolean verificarMovJugadorActivo(int movimientosEsperados){
        return (this.jugadorActivo.verificarMovimiento(movimientosEsperados));
    }

    public boolean verificarMovJugadorEspera(int movimientosEsperados){
        return (this.jugadorEspera.verificarMovimiento(movimientosEsperados));
    }

    public boolean verificarAtributosNoNulos(){
        return (this.escenario != null & this.jugadorActivo != null & this.jugadorEspera != null);
    }
}
