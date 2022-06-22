package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;


public abstract class Vehiculo {
    protected Movimiento movimiento;
    protected Ubicacion ubicacion;
    protected int movimientos;
    protected Vehiculo cambio;

    public Vehiculo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.movimientos = 0;
        this.movimiento = new MovimientoNormal();
    }

    public abstract void atravesar(Obstaculo obstaculo);

    public abstract void atravesar(Sorpresa sorpresa);

    public void atravesar(Casillero casillero){
        Vehiculo vehiculo = this;
        casillero.entregaSorpresa(vehiculo);
        casillero.entregaObstaculo(vehiculo);
    }

    public int porcentajeMovimientos(int porcentaje) {
        return this.movimientos * porcentaje / 100;
    }

    /*
    public Casillero casillero() {
        return this.casillero;
    }
    */
    public void mover(Direccion direccion) {
        movimiento.mover(ubicacion, direccion);
        Casillero nuevoCasillero = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        this.atravesar(nuevoCasillero);

        //Vehiculo vehiculo = this;
        //Escenario.getInstance().agregarVehiculoEnCasillero(vehiculo, ubicacion);
        //Casillero casilleroNuevo = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        //this.atravesar(casilleroNuevo);
        // movimiento.mover(ubicacion, direccion);
        // escenario.agregarEn(vehiculo, ubicacion);

    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void reducirMovimientos(int disminucion){this.movimientos -= disminucion;}

    /*
    // Metodo para tests
    public boolean verificarCasillero(Ubicacion nuevaUbicacion) {
        return this.ubicacion.equals(nuevaUbicacion);
    }
    */

    // Metodo para tests
    public boolean verificarMovimientos(int cantMovimientos){
        return (this.movimientos == cantMovimientos);
    }

    public void establecerCambio(Vehiculo vehiculo){
        this.cambio = vehiculo;
    }
    public Vehiculo cambio() {
        return this.cambio;
    }

    public int movimientos() {
        return this.movimientos;
    }

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }

    public boolean verificarUbicacion(Ubicacion ubicacion) {
        return this.ubicacion.equals(ubicacion);
    }

    public Casillero casillero(){
        return new Casillero(ubicacion);
    }

    //
}