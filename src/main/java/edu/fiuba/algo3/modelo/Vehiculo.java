package edu.fiuba.algo3.modelo;

abstract class Vehiculo {

    private Direccion ubicacion;

    public Vehiculo() {
        this.ubicacion = new Direccion();
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
    public Direccion obtenerUbicacion () {
        return this.ubicacion;
    }

    public void mover(String movimiento) {
        switch (movimiento){
            case "derecha":
                this.ubicacion.incrementarColumna();
                break;
            case "izquierda":
                this.ubicacion.disminuirColumna();
                break;
            case "abajo":
                this.ubicacion.incrementarFila();
                break;
            case "arriba":
                this.ubicacion.disminuirFila();
                break;
        }
    }
}
