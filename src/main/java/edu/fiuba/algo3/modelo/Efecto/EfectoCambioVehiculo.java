package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;

public class EfectoCambioVehiculo extends EfectoDecorador {
    private final Vehiculo VEHICULONUEVO;

    public EfectoCambioVehiculo(Efecto efecto, Auto auto) {
        super(efecto);
        VEHICULONUEVO = new Camioneta(auto.obtenerUbicacion());
        VEHICULONUEVO.asignarDireccion(auto.obtenerDireccion());
    }

    public EfectoCambioVehiculo(Efecto efecto, Camioneta camioneta) {
        super(efecto);
        VEHICULONUEVO = new Moto(camioneta.obtenerUbicacion());
        VEHICULONUEVO.asignarDireccion(camioneta.obtenerDireccion());
    }

    public EfectoCambioVehiculo(Efecto efecto, Moto moto) {
        super(efecto);
        VEHICULONUEVO = new Auto(moto.obtenerUbicacion());
        VEHICULONUEVO.asignarDireccion(moto.obtenerDireccion());
    }

    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.cambiarVehiculo(VEHICULONUEVO);
    }
}