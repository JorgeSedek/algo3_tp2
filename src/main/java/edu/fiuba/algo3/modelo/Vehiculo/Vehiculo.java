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

    public abstract Efecto atravesar(Obstaculo obstaculo);

    public abstract Efecto atravesar(Sorpresa sorpresa);

    public Efecto atravesar(Meta meta) {
        return meta.atravesar(this);
    }

    public Casillero mover(Direccion direccion) {
        this.direccion = direccion;
        direccion.mover(ubicacion);
        Casillero nuevoCasillero = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        direccion.mover(ubicacion);
        return nuevoCasillero;
    }

    public void moverSentidoOpuesto(){
        this.direccion.mover(ubicacion);
        this.direccion.mover(ubicacion);
    }

    public void cambiarDireccionContraria(){
        this.direccion= this.direccion.direccionOpuesta();
    }

    public void asignarDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion obtenerDireccion() {
        return this.direccion;
    }

    // Se usa para tests
    public boolean verificarUbicacion(Ubicacion ubicacion) {
        return this.ubicacion.equals(ubicacion);
    }

    public Ubicacion obtenerUbicacion() {
        return this.ubicacion;
    }
}