package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;

import java.util.HashMap;

public abstract class Vehiculo extends ObjetoUrbano{

    private Ubicacion ubicacion;
    protected int cantMovimientos;


    public Vehiculo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.cantMovimientos = 0;


    }

    public void incrementarMovimientos(int incremento){
        this.cantMovimientos += incremento;
    }

    public int movimientos(){
        return this.cantMovimientos;
    }

    public Ubicacion obtenerUbicacion () {
        return this.ubicacion;
    }

    // Comentado de momento porque movimiento no se utiliza
    // public Movimiento obtenerMovimiento(){return this.movimiento;}



    public void mover(Direccion direccion) {
        direccion.mover(this.ubicacion);
    }

    // Metodos para Tests
    public boolean verificarUbicacion(Ubicacion nuevaUbicacion) {
        return this.ubicacion.equals(nuevaUbicacion);
    }
}



/*
POSIBLE SEGUNDA IMPLEMENTACION (Vehiculo ya no tiene una ubicacion, sino un casillero)

public abstract class Vehiculo {

    private Casillero casillero;



    public Vehiculo(Casillero casillero) {
        this.casillero = casillero;

    }

    public Casillero obtenerPosicion() {
        return this.casillero;
    }

    // Comentado de momento porque movimiento no se utiliza
    // public Movimiento obtenerMovimiento(){return this.movimiento;}

    public void mover(Direccion direccion) {
        this.casillero = this.casillero.obtenerCasilleroAdyacente(direccion);
    }

    // Metodos para Tests
    public boolean verificarUbicacion(Casillero otraPosicion) {
        return this.posicion.equals(otraPosicion);
    }
}


 */
