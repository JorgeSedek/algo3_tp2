package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;


public class Jugador {
    private Vehiculo vehiculo;
    private final String nombre;
    private int movimientos;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
        this.movimientos = 0;
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void reducirMovimientos(int disminucion){this.movimientos -= disminucion;}

    public void aplicarPorcentajeMovimientos(double porcentaje) {
        this.movimientos = (int) (movimientos * porcentaje / 100);
    }

    public void moverVehiculo(Direccion direccion){
        Logger.getInstance().imprimir("--------------------------------------------------------------------");
        Logger.getInstance().imprimir("Turno de: " + this.nombre);
        Logger.getInstance().imprimir("Vehiculo: " + this.vehiculo.asString());
        Logger.getInstance().imprimir("Movimientos: " + this.movimientos);
        Logger.getInstance().imprimir("Te moves para " + direccion.asString());
        this.movimientos++;
        Casillero casillero = this.vehiculo.mover(direccion);
        casillero.atravesar(this);
        //System.out.println("El vehiculo del jugador: " + this.nombre + " es un " + this.vehiculo.getClass() +" y esta en la fila: " + vehiculo.obtenerUbicacion().obtenerFila() + " columna: " + vehiculo.obtenerUbicacion().obtenerColumna());// TODO QUITAR MAS ADELANTE, SIRVE PARA DEBUGGEAR LA INTERFAZ GRAFICA
    }

    public void atravezar(Sorpresa sorpresa) {
        Efecto efecto = this.vehiculo.atravesar(sorpresa);
        efecto.aplicar(this);
    }

    public void atravezar(Obstaculo obstaculo) {
        Efecto efecto = this.vehiculo.atravesar(obstaculo);
        efecto.aplicar(this);
    }

    public void atravezar(Meta meta) {
        Efecto efecto = this.vehiculo.atravesar(meta);
        efecto.aplicar(this);
    }

    public void moverVehiculoSentidoOpuesto(){
        this.vehiculo.moverSentidoOpuesto();
    }

    // Se usa para tests
    public boolean verificarMovimientos(int cantMovimientos) {
        return this.movimientos == cantMovimientos;
    }

    public void cambiarVehiculo(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    // Se usa para tests
    public boolean mismoVehiculo(Vehiculo vehiculo) {
        // TODO cambiar la comparación
        return (this.vehiculo.getClass() == vehiculo.getClass() && this.vehiculo.verificarUbicacion(vehiculo.obtenerUbicacion()));
    }

    public Puntaje obtenerPuntaje() {
        return new Puntaje(this);
    }

    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }

    public String nombre() {
        return this.nombre;
    }

    public int movimientos() {
        return this.movimientos;
    }

    public boolean verificarUbicacion(Ubicacion ubicacion){
        return this.vehiculo.verificarUbicacion(ubicacion);
    }

    public boolean movimientosPar() {
        return this.movimientos % 2 == 0;
    }
}