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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    private String nombre = "Martin";
    private int fila = 1;
    private int columna = 1;
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener7Movimientos () {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Casillero nuevoCasillero = new Casillero(new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 7;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.recibe(pozo);

        assertTrue(moto.verificarCasillero(nuevoCasillero));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnAutoSeMuevePorLaCiudad6VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener9Movimientos () {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(casillero);
        Jugador jugador = new Jugador(nombre, auto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Casillero nuevoCasillero = new Casillero(new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        juego.moverVehiculo(new DireccionIzquierda());
        juego.moverVehiculo(new DireccionArriba());

        auto.recibe(pozo);

        assertTrue(auto.verificarCasillero(nuevoCasillero));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaCamionetaSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener4Movimientos () {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, camioneta);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Casillero nuevoCasillero = new Casillero(new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 4;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        camioneta.recibe(pozo);

        assertTrue(camioneta.verificarCasillero(nuevoCasillero));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPiqueteDeberiaEstarEnOtraUbicacionYTener6Movimientos() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Casillero nuevoCasillero = new Casillero(new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 6;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.recibe(piquete);

        assertTrue(moto.verificarCasillero(nuevoCasillero));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoYUnPiqueteDeberiaEstarEnOtraUbicacionYTener9Movimientos(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Casillero nuevoCasillero = new Casillero(new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.recibe(pozo);
        moto.recibe(piquete);

        assertTrue(moto.verificarCasillero(nuevoCasillero));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }
}
