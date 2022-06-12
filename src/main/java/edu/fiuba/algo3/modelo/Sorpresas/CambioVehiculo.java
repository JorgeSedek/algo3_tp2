package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class CambioVehiculo implements Sorpresa{

    @Override
    public void recibirSorpresa(Jugador jugador, Moto moto) {
        Auto auto = new Auto(moto.obtenerUbicacion(), moto.obtenerMovimiento());
        jugador.cambiarVehiculo(auto);
        //return auto;
    }

    public void recibirSorpresa(Jugador jugador, Auto auto){
        Camioneta camioneta = new Camioneta(auto.obtenerUbicacion(), auto.obtenerMovimiento());
        jugador.cambiarVehiculo(camioneta);
    }

    public void recibirSorpresa(Jugador jugador, Camioneta camion){
        Moto moto = new Moto(camion.obtenerUbicacion(), camion.obtenerMovimiento());
        jugador.cambiarVehiculo(moto);
    }

}
