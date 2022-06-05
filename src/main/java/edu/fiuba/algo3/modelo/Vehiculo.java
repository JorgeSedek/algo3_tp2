package edu.fiuba.algo3.modelo;

abstract class Vehiculo {
    private EntreCalle ubicacion;

    void mover (Direccion direccion) {

    }

    void nuevaUbicacion (EntreCalle nueva_ubicacion) {
        this.ubicacion = nueva_ubicacion;
    }

    EntreCalle obtenerUbicacion () {
        return this.ubicacion;
    }
}
