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
    private int fila = 2;
    private int columna = 2;
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener7Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionPozo = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        int nuevaFila = 4;
        int nuevaColumna = 8;
        Ubicacion nuevoUbicacion = new Ubicacion(nuevaFila, nuevaColumna);
        int movimientosEsperados = 7;

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());

        // Assert
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void UnAutoSeMuevePorLaCiudad6VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener9Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionPozo = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        int nuevaFila = 2;
        int nuevaColumna = 6;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());
        Juego.getInstance().moverVehiculo(new DireccionIzquierda());
        Juego.getInstance().moverVehiculo(new DireccionArriba());

        // Assert
        assertTrue(auto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void UnaCamionetaSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener4Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador1 = new Jugador(nombre, camioneta);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionPozo = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        int nuevaFila = 4;
        int nuevaColumna = 8;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 4;

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());

        // Assert
        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));

    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPiqueteDeberiaEstarEnOtraUbicacionYTener6Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Obstaculo piquete = new Piquete();
        Ubicacion ubicacionPiquete = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        int nuevaFila = 4;
        int nuevaColumna = 8;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 6;

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());

        Casillero casilleroConPiquete = new Casillero(nuevaFila,nuevaColumna);
        casilleroConPiquete.asignarObstaculo(piquete);

        // Assert
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoYUnPiqueteDeberiaEstarEnOtraUbicacionYTener9Movimientos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionPozo = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacionPiquete = (new Ubicacion(2, 5));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        int nuevaFila = 4;
        int nuevaColumna = 8;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());

        // Assert
        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }
}
