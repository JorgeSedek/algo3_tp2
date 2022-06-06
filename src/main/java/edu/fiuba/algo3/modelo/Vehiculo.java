package edu.fiuba.algo3.modelo;

abstract class Vehiculo {
    private String ubicacion;

    void mover (String direccion) {
        this.ubicacion = direccion;
    }

    void nuevaUbicacion (String nueva_ubicacion) {
        this.ubicacion = nueva_ubicacion;
    }

    String obtenerUbicacion () {
        return this.ubicacion;
    }
}
