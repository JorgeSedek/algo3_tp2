package edu.fiuba.algo3.modelo;

abstract class Vehiculo {
    private String ubicacion;

    void mover (String direccion) {
        this.ubicacion = direccion;
    }

    String obtenerUbicacion () {
        return this.ubicacion;
    }
}
