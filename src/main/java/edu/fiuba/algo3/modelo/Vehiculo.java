package edu.fiuba.algo3.modelo;

abstract class Vehiculo {
    private Direccion ubicacion;

    void mover (Direccion direccion) {
        this.ubicacion = direccion;
    }

   public Obstaculo moverIzquierda(Escenario escenario){
        Calle calle = escenario.entreCalle(ubicacion.asString()).obtenerCalleIzquierda();
        Obstaculo obstaculo = calle.obstaculo();
        ubicacion = (escenario.entreCalle(ubicacion.asString())).direccion();
        return obstaculo;
   }
    Direccion obtenerUbicacion () {
        return this.ubicacion;
    }
}
