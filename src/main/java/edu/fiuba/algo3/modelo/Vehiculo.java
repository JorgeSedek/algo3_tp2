package edu.fiuba.algo3.modelo;

abstract class Vehiculo {

    private Ubicacion ubicacion;
    private Movimiento movimiento;

    public Vehiculo() {
        int fila = 1;
        int columna = 1;
        this.ubicacion = new Ubicacion(fila,columna);
        this.movimiento = new MovimientoNormal();
    }



    public Ubicacion obtenerUbicacion () {

        return this.ubicacion;
    }



    public void mover(Direccion direccion){
        movimiento.asignarDireccion(direccion);
       this.ubicacion = movimiento.mover(this.ubicacion);

    }

}
