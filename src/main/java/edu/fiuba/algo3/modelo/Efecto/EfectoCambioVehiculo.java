package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoCambioVehiculo extends EfectoDecorador {
    private Vehiculo vehiculoNuevo;

    public EfectoCambioVehiculo(Efecto efecto, Auto auto) {
        super(efecto);
        this.vehiculoNuevo = new Camioneta(auto.ubicacion());
        vehiculoNuevo.incrementarMovimientos(auto.obtenerMovimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Camioneta camioneta) {
        super(efecto);
        this.vehiculoNuevo = new Moto(camioneta.ubicacion());
        vehiculoNuevo.incrementarMovimientos(camioneta.obtenerMovimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Moto moto) {
        super(efecto);
        this.vehiculoNuevo = new Auto(moto.ubicacion());
        vehiculoNuevo.incrementarMovimientos(moto.obtenerMovimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Auto auto, Jugador jugador) {
        super(efecto);
        this.vehiculoNuevo = new Camioneta(auto.ubicacion());
        vehiculoNuevo.incrementarMovimientos(jugador.obtenerMovimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Camioneta camioneta, Jugador jugador) {
        super(efecto);
        this.vehiculoNuevo = new Moto(camioneta.ubicacion());
        vehiculoNuevo.incrementarMovimientos(jugador.obtenerMovimientos());
    }

    public EfectoCambioVehiculo(Efecto efecto, Moto moto, Jugador jugador) {
        super(efecto);
        this.vehiculoNuevo = new Auto(moto.ubicacion());
        vehiculoNuevo.incrementarMovimientos(jugador.obtenerMovimientos());
    }

    public void aplicar(Vehiculo vehiculo) {
        super.aplicar(vehiculo);
        vehiculo.establecerCambio(vehiculoNuevo);
    }

    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
       jugador.cambiarVehiculo(vehiculoNuevo);
    }
}