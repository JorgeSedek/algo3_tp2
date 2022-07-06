package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EscenarioRandom {
    private String nombre = "Martin";

    private int filaInicial = 2;

    private int columnaInicial = 2;

    @Test
    public void elEscenarioRandomCreaLaMetaYUnAutoLaAtraviesa() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        // Reseteo el escenario y el juego
        Escenario.resetInstance(1, 1); // De esta manera la meta solo puede estar en un unico lugar (2,3)
        Juego.resetInstance(jugadores);

        // Le agrego una meta al escenario (se agrega de forma random, pero por el tamaño va a estar en (2,3)
        Escenario.getInstance().agregarObjetosRandom();

        // Act
        Juego.getInstance().moverVehiculo(new DireccionDerecha());

        // Assert
        List<Puntaje> puntajes = Juego.getInstance().obtenerPuntajes();
        Puntaje puntajeJugador = puntajes.get(0);

        assertEquals(puntajes.size(), 1);
        assertEquals(puntajeJugador.obtenerNombreJugador(), nombre);
        assertEquals(puntajeJugador.obtenerPuntuacion(), 1);
    }
}
