package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class CambioVehiculo implements Sorpresa {
    public void atravezar(Auto auto) {
        Vehiculo nuevoVehiculo = new Camioneta(auto.casillero());
        nuevoVehiculo.incrementarMovimientos(auto.movimientos());
        auto.establecerCambio(nuevoVehiculo);
    }

    public void atravezar(Camioneta camioneta) {
        Vehiculo nuevoVehiculo = new Moto(camioneta.casillero());
        nuevoVehiculo.incrementarMovimientos(camioneta.movimientos());
        camioneta.establecerCambio(nuevoVehiculo);
    }

    public void atravezar(Moto moto) {
        Vehiculo nuevoVehiculo = new Auto(moto.casillero());
        nuevoVehiculo.incrementarMovimientos(moto.movimientos());
        moto.establecerCambio(nuevoVehiculo);
    }
}