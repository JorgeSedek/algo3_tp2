package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CambiarVehiculoTest {
    private String nombre = "Tomas";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void jugadorTieneMotoYAtraviesaSorpresaCambioDeVehiculoDeberiaCambiarAAuto(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Vehiculo vehiculoEsperado = new Auto(ubicacion);

        cambioVehiculo.recibirSorpresa((Moto) moto, jugador);

        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }

    @Test
    public void jugadorTieneAutoYAtraviesaSorpresaCambioVehiculoDeberiaCambiarACamioneta(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Vehiculo vehiculoEsperado = new Camioneta(ubicacion);

        cambioVehiculo.recibirSorpresa((Auto) auto, jugador);

        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }

    @Test
    public void jugadorTieneCamionetaYAtraviesaCambioVehiculoDeberiaCambiarAMoto(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Vehiculo vehiculoEsperado = new Moto(ubicacion);

        cambioVehiculo.recibirSorpresa((Camioneta) camioneta, jugador);

        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }

    @Test
    public void jugadorTieneMotoYAtraviesaSorpresaCambioDeVehiculoDeberiaCambiarAAutoYPermanecerEnSuUbicacion(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Vehiculo vehiculoEsperado = new Auto(new Ubicacion(2,4));

        cambioVehiculo.recibirSorpresa((Moto) moto, jugador);

        assertFalse(jugador.mismoVehiculo(vehiculoEsperado));
    }
}
