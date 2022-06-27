package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CambiarVehiculoTest {
    private String nombre = "Tomas";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void jugadorTieneMotoYAtraviesaSorpresaCambioDeVehiculoDeberiaCambiarAAuto(){
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        Efecto efecto = new EfectoGeneral();

        efecto = moto.atravesar(cambioVehiculo, efecto);
        efecto.aplicar(jugador);

        Vehiculo vehiculoEsperado = new Auto(ubicacion);
        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }

    @Test
    public void jugadorTieneAutoYAtraviesaSorpresaCambioVehiculoDeberiaCambiarACamioneta(){
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        Efecto efecto = new EfectoGeneral();

        efecto = auto.atravesar(cambioVehiculo, efecto);
        efecto.aplicar(jugador);

        Vehiculo vehiculoEsperado = new Camioneta(ubicacion);
        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }

    @Test
    public void jugadorTieneCamionetaYAtraviesaCambioVehiculoDeberiaCambiarAMoto(){
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        Efecto efecto = new EfectoGeneral();

        efecto = camioneta.atravesar(cambioVehiculo, efecto);
        efecto.aplicar(jugador);

        Vehiculo vehiculoEsperado = new Moto(ubicacion);
        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }
}
