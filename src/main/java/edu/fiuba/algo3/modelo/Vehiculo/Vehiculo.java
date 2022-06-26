package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;


public abstract class Vehiculo {
    protected Ubicacion ubicacion;

    public Vehiculo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public abstract Efecto atravesar(Obstaculo obstaculo, Efecto efecto);

    public abstract Efecto atravesar(Sorpresa sorpresa, Efecto efecto);

    public Efecto mover(Direccion direccion) {
        direccion.mover(ubicacion);
        Casillero nuevoCasillero = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        direccion.mover(ubicacion);
        Efecto efecto = nuevoCasillero.atravesar(this);
        return efecto;
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
}