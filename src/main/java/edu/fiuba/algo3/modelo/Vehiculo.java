package edu.fiuba.algo3.modelo;

abstract class Vehiculo {

    private Ubicacion ubicacion;

    public Vehiculo() {
        this.ubicacion = new Ubicacion();
    }

    /*
    Se comenta de momento porque no se utiliza

    public Vehiculo(int fila, int columna) {
        this.ubicacion = new Direccion(fila, columna);
    }
    */

    /*
    public Obstaculo moverIzquierda(Escenario escenario){
        Calle calle = escenario.entreCalle(ubicacion.asString()).obtenerCalleIzquierda();
        Obstaculo obstaculo = calle.obstaculo();
        ubicacion = (escenario.entreCalle(ubicacion.asString())).direccion();
        return obstaculo;
    }
    /
     */

    public Ubicacion obtenerUbicacion () {
        return this.ubicacion;
    }

    public void mover(Direccion direccion){
        direccion.mover(this.ubicacion);
    }

    public void moverDerecha() {
        this.ubicacion.incrementarColumna();
    }

    public void moverIzquierda() {
        this.ubicacion.disminuirColumna();
    }

    public void moverAbajo() {
        this.ubicacion.incrementarFila();
    }

    public void moverArriba() {
        this.ubicacion.disminuirFila();
    }
}
