package edu.fiuba.algo3.modelo.Entregas;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.*;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    private String nombre = "Martin";
    private int fila = 1;
    private int columna = 1;
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener7Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 7;

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        Casillero casilleroConPozo = new Casillero(nuevaFila,nuevaColumna);
        casilleroConPozo.asignarObstaculo(pozo);
        moto.atravesar(casilleroConPozo);

        // Assert
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador1.verificarMovimiento(movimientosEsperados));

    }

    @Test
    public void UnAutoSeMuevePorLaCiudad6VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener9Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        juego.moverVehiculo(new DireccionIzquierda());
        juego.moverVehiculo(new DireccionArriba());

        Casillero casilleroConPozo = new Casillero(nuevaFila,nuevaColumna);
        casilleroConPozo.asignarObstaculo(pozo);
        auto.atravesar(casilleroConPozo);

        // Assert
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
        assertTrue(auto.verificarUbicacion(nuevoUbicacion));
    }

    @Test
    public void UnaCamionetaSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener4Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador1 = new Jugador(nombre, camioneta);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 4;

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        Casillero casilleroConPozo = new Casillero(nuevaFila,nuevaColumna);
        casilleroConPozo.asignarObstaculo(pozo);
        camioneta.atravesar(casilleroConPozo);

        // Assert
        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));

    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPiqueteDeberiaEstarEnOtraUbicacionYTener6Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 6;

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        Casillero casilleroConPiquete = new Casillero(nuevaFila,nuevaColumna);
        casilleroConPiquete.asignarObstaculo(piquete);
        moto.atravesar(casilleroConPiquete);

        // Assert
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));

    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoYUnPiqueteDeberiaEstarEnOtraUbicacionYTener9Movimientos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Obstaculo pozo = new Pozo();
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.atravesar(pozo);
        moto.atravesar(piquete);

        // Assert
        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));

    }
}
