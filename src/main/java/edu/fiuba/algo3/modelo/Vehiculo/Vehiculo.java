package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.CollitionHandler;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;

import java.util.HashMap;

public abstract class Vehiculo {
    protected Casillero casillero;
    protected HashMap<Class, CollitionHandler> urbanoMap;
    protected int movimientos;

    public Vehiculo(Casillero casillero) {
        this.casillero = casillero;
        this.initUrbanoMap();
    }

    private void initUrbanoMap() {
        urbanoMap = new HashMap<>();
        urbanoMap.put(Pozo.class, (x) -> recibePozo(x));
        urbanoMap.put(Piquete.class, (x) -> recibePiquete(x));
        urbanoMap.put(Favorable.class, (x) -> recibeFavorable(x));
        urbanoMap.put(Desfavorable.class, (x) -> recibeDesfavorable(x));
        urbanoMap.put(CambioVehiculo.class, (x) -> recibeCambioVehiculo(x));
    }

    protected abstract Vehiculo recibePozo(ObjetoUrbano x);
    protected abstract Vehiculo recibePiquete(ObjetoUrbano x);
    protected abstract Vehiculo recibeFavorable(ObjetoUrbano x);
    protected abstract Vehiculo recibeDesfavorable(ObjetoUrbano x);
    protected abstract Vehiculo recibeCambioVehiculo(ObjetoUrbano x);



    public Vehiculo recibe(ObjetoUrbano otroObjetoUrbano) {
        CollitionHandler handler = this.urbanoMap.get(otroObjetoUrbano.getClass());
       Vehiculo vehiculo = handler.collideWith(otroObjetoUrbano);
        return vehiculo;
    }

    public void asignarMovimientos(int cantMovimientos) {
        this.movimientos = cantMovimientos;
    }

    public Ubicacion obtenerUbicacion () {
        return this.casillero.ubicacion();
    }

    public Casillero casillero() {
        return this.casillero;
    }

    public void mover(Direccion direccion) {
        direccion.mover(this.casillero);
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void disminuirMovimientos(int disminucion){this.movimientos -= disminucion;}

    public int movimientos(){return this.movimientos;}

    // Metodos para Tests
    public boolean verificarCasillero(Casillero nuevoCasillero) {
        return this.casillero.equals(nuevoCasillero);
    }
}