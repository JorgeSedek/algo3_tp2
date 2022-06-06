package edu.fiuba.algo3.modelo;

abstract class Vehiculo {
    private Direccion ubicacion;

    void mover (Direccion direccion) {
        this.ubicacion = direccion;
    }

    Direccion obtenerUbicacion () {
        return this.ubicacion;
    }
}
