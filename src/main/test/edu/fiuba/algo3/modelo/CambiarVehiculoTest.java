package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CambiarVehiculoTest {

    @Test
    public void jugadorTieneMotoYAtraviesaCambioVehiculoDeveCambiarAAuto(){

        Moto moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Cr", moto);
        //Auto auto = new Auto(moto.obtenerUbicacion(), moto.obtenerMovimiento());
        CambioVehiculo cambioVehi = new CambioVehiculo();

        cambioVehi.recibirSorpresa(jugador, moto);

        assertTrue(jugador.verificarVehiculoDatos(moto.obtenerUbicacion(), moto.obtenerMovimiento()));
    }

    @Test
    public void jugadorTieneAutoYAtraviesaCambioVehiculoDeveCambiarACamion(){

        Auto auto = new Auto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Cr", auto);
        CambioVehiculo cambioVehi = new CambioVehiculo();

        cambioVehi.recibirSorpresa(jugador, auto);

        assertTrue(jugador.verificarVehiculoDatos(auto.obtenerUbicacion(), auto.obtenerMovimiento()));
    }

    @Test
    public void jugadorTieneCamionYAtraviesaCambioVehiculoDeveCambiarAMoto(){

        Camioneta camion = new Camioneta(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Cr", camion);
        CambioVehiculo cambioVehi = new CambioVehiculo();

        cambioVehi.recibirSorpresa(jugador, camion);

        assertTrue(jugador.verificarVehiculoDatos(camion.obtenerUbicacion(), camion.obtenerMovimiento()));
    }

    @Test
    public void jugadorTieneMotoYAtraviesaCambioVehiculo(){

        Moto moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Cr", moto);
        Auto auto = new Auto(new Ubicacion(2,4), new MovimientoNormal());
        CambioVehiculo cambioVehi = new CambioVehiculo();

        cambioVehi.recibirSorpresa(jugador, moto);

        assertFalse(jugador.verificarVehiculoDatos(auto.obtenerUbicacion(), auto.obtenerMovimiento()));
    }
}