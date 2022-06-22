package edu.fiuba.algo3.modelo;
/*
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest {
    private String nombre = "Martin";
    private int totalFilas = 9;
    private int totalColumnas = 9;
    private int filaInicial = 2;
    private int columnaInicial = 2;

    @Test
    public void seAgregaUnPozoAlEscenarioYUnAutoSeMueveYPasaDeberiaTener4Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);

        // Act
        Ubicacion ubicacionPozo = new Ubicacion(2,3);
        Escenario.getInstance().ponerPozoEn(ubicacionPozo);
        juego.moverVehiculo(new DireccionDerecha());

        assertTrue(auto.verificarMovimientos(4));

    }
}
*/