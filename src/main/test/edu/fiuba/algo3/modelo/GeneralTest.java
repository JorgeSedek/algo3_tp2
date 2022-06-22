package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest {
    private String nombre = "Martin";
    private int totalFilas = 40;
    private int totalColumnas = 40;
    private int filaInicial = 2;
    private int columnaInicial = 2;

    @Test
    public void seAgregaUnPozoAlEscenarioDelJuegoYUnAutoSeMueveYPasaPorElDeberiaTener4Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);

        // Act
        Pozo pozo = new Pozo();
        Ubicacion ubicacionPozo = new Ubicacion(2,3);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);
        juego.moverVehiculo(new DireccionDerecha());

        // Assert
        assertTrue(auto.verificarMovimientos(4));

    }

    @Test
    public void seAgregaUnaSorpresaFavorableAlEscenarioDelJuegoYUnAutoSeMueveYPasaPorEstaDeberiaTener10Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);

        // Act
        Sorpresa sorpresaFavorable = new Favorable();
        Ubicacion ubicacionSorpresa = new Ubicacion(2,13);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa, sorpresaFavorable);

        for (int i = 0; i < 10; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }

        // Assert
        assertTrue(auto.verificarMovimientos(10));

    }
}