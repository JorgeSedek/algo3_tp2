package edu.fiuba.algo3.modelo;

abstract class Vehiculo {

    private final Ubicacion ubicacion;

    public Vehiculo() {
        this.ubicacion = new Ubicacion(1,1);
    }

    public Ubicacion obtenerUbicacion () {
        return this.ubicacion;
    }

    public void mover(Direccion direccion){
        direccion.mover(this.ubicacion);
    }

}
