package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoCambioVehiculo extends EfectoDecorador {
    private Vehiculo vehiculoNuevo;

    public EfectoCambioVehiculo(Efecto efecto, Auto auto) {
        super(efecto);
        this.vehiculoNuevo = new Camioneta(auto.ubicacion());
        vehiculoNuevo.incrementarMovimientos(auto.movimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Camioneta camioneta) {
        super(efecto);
        this.vehiculoNuevo = new Moto(camioneta.ubicacion());
        vehiculoNuevo.incrementarMovimientos(camioneta.movimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Moto moto) {
        super(efecto);
        this.vehiculoNuevo = new Auto(moto.ubicacion());
        vehiculoNuevo.incrementarMovimientos(moto.movimientos());
    }

    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        vehiculo.establecerCambio(vehiculoNuevo);
    }
}