package edu.fiuba.algo3.modelo;

abstract class Vehiculo {

    private final Ubicacion ubicacion;

    public Vehiculo() {
        int fila = 1;
        int columna = 1;
        this.ubicacion = new Ubicacion(fila,columna);
    }



    public Ubicacion obtenerUbicacion () {

        return this.ubicacion;
    }

    public void mover(Direccion direccion){
        direccion.mover(this.ubicacion);
    }

}
