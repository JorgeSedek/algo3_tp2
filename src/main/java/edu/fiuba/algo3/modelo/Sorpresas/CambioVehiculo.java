package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class CambioVehiculo implements Sorpresa{

    @Override
    public void recibirSorpresa(Vehiculo vehiculo, Jugador jugador) {
        Vehiculo nuevoVehiculo = null;
        if (vehiculo instanceof Auto) {
            nuevoVehiculo = new Camioneta(vehiculo.obtenerUbicacion());
        }
        if (vehiculo instanceof Moto) {
            nuevoVehiculo = new Auto(vehiculo.obtenerUbicacion());
        }
        if (vehiculo instanceof Camioneta) {
            nuevoVehiculo = new Moto(vehiculo.obtenerUbicacion());
        }
        jugador.cambiarVehiculo(nuevoVehiculo);
    }
}
/*
    public void recibirSorpresa(Moto moto, Jugador jugador) {
        Vehiculo auto = new Auto(moto.obtenerUbicacion());
        jugador.cambiarVehiculo(auto);
    }

    public void recibirSorpresa(Auto auto, Jugador jugador){
        Vehiculo camioneta = new Camioneta(auto.obtenerUbicacion());
        jugador.cambiarVehiculo(camioneta);
    }

    public void recibirSorpresa(Camioneta camion, Jugador jugador){
        Vehiculo moto = new Moto(camion.obtenerUbicacion());
        jugador.cambiarVehiculo(moto);
    }
}
*/