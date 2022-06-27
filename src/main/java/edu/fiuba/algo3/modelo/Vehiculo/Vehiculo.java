package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;


public abstract class Vehiculo {
    protected Ubicacion ubicacion;
    protected Direccion direccion;

    public Vehiculo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.direccion = new DireccionDerecha();
    }

    public void asignarDireccion(Direccion direccion){
        this.direccion = direccion;
    }

    public abstract Efecto atravesar(Obstaculo obstaculo, Efecto efecto);

    public abstract Efecto atravesar(Sorpresa sorpresa, Efecto efecto);

    public Efecto atravesar(Meta meta, Efecto efectoInicial) {
        return meta.atravesar(this, efectoInicial);
    }

    public Efecto mover(Direccion direccion) {
        this.asignarDireccion(direccion);
        direccion.mover(ubicacion);
        Casillero nuevoCasillero = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        direccion.mover(ubicacion);
        Efecto efecto = nuevoCasillero.atravesar(this);

        return efecto;
    }

    public void moverSinItems(){
        this.direccion.mover(ubicacion);
    }

    public void cambiarDireccionContraria(){
        this.direccion= this.direccion.direccionOpuesta();
    }

    public boolean verificarUbicacion(Ubicacion ubicacion) {
        return this.ubicacion.equals(ubicacion);
    }

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }
}