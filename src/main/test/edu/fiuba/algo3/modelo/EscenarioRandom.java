package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EscenarioRandom {
    private String nombre = "Martin";
    private int totalFilas = 21; // Es el escenario de la consigna
    private int totalColumnas = 23; // Es el escenario de la consigna

    private int filaInicial = 2;

    private int columnaInicial = 2;

    @Test
    public void elEscenarioRandomSeCreoCorrectamente() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        // Reseteo el escenario y el juego
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        // Lleno de obstaculos, sorpresas y una meta al escenario
        Escenario.getInstance().asignarColocadorRandom();
        Escenario.getInstance().agregarObstaculosYSorpresas();
        Escenario.getInstance().agregarMeta();
    }
}
