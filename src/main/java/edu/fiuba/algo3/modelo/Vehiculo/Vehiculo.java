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
    private Casillero casillero;
    protected HashMap<Class, CollitionHandler> urbanoMap;
    protected int movimientos;

    public Vehiculo(Casillero casillero) {
        this.casillero = casillero;
        this.initUrbanoMap();
    }

    private void initUrbanoMap() {
        urbanoMap = new HashMap<>();
        urbanoMap.put(Pozo.class, this::recibePozo);
        urbanoMap.put(Piquete.class, this::recibePiquete);
        urbanoMap.put(Favorable.class, this::recibeFavorable);
        urbanoMap.put(Desfavorable.class, this::recibeDesfavorable);
        urbanoMap.put(CambioVehiculo.class, this::recibeCambioVehiculo);
    }

    protected abstract void recibePozo(ObjetoUrbano x);
    protected abstract void recibePiquete(ObjetoUrbano x);
    protected abstract void recibeFavorable(ObjetoUrbano x);
    protected abstract void recibeDesfavorable(ObjetoUrbano x);
    protected abstract void recibeCambioVehiculo(ObjetoUrbano x);

    public void recibe(ObjetoUrbano otroObjetoUrbano) {
        CollitionHandler handler = this.urbanoMap.get(otroObjetoUrbano.getClass());
        handler.recibir(otroObjetoUrbano);
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