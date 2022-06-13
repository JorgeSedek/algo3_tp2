package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {
    private String nombre = "Martin";
    private int fila = 1;
    private int columna = 1;
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener7Movimientos () {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion, new MovimientoNormal());
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevaUbicacion = new Ubicacion(nuevaFila, nuevaColumna);
        int movimientosEsperados = 7;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        pozo.pasarObstaculo((Moto) moto, juego.obtenerJugador());

        assertTrue(moto.verificarUbicacion(nuevaUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnAutoSeMuevePorLaCiudad6VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener9Movimientos () {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion, new MovimientoNormal());
        Jugador jugador = new Jugador(nombre, auto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Ubicacion nuevaUbicacion = new Ubicacion(nuevaFila, nuevaColumna);
        int movimientosEsperados = 9;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        juego.moverVehiculo(new DireccionIzquierda());
        juego.moverVehiculo(new DireccionArriba());

        pozo.pasarObstaculo((Auto) auto, juego.obtenerJugador());

        assertTrue(auto.verificarUbicacion(nuevaUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaCamionetaSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener4Movimientos () {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo camioneta = new Camioneta(ubicacion, new MovimientoNormal());
        Jugador jugador = new Jugador(nombre, camioneta);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevaUbicacion = new Ubicacion(nuevaFila, nuevaColumna);
        int movimientosEsperados = 4;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        pozo.pasarObstaculo((Camioneta) camioneta, juego.obtenerJugador());

        assertTrue(camioneta.verificarUbicacion(nuevaUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPiqueteDeberiaEstarEnOtraUbicacionYTener6Movimientos() {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion, new MovimientoNormal());
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevaUbicacion = new Ubicacion(nuevaFila, nuevaColumna);
        int movimientosEsperados = 6;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        piquete.pasarObstaculo((Moto) moto, juego.obtenerJugador());

        assertTrue(moto.verificarUbicacion(nuevaUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoYUnPiqueteDeberiaEstarEnOtraUbicacionYTener9Movimientos(){
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion, new MovimientoNormal());
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevaUbicacion = new Ubicacion(nuevaFila, nuevaColumna);
        int movimientosEsperados = 9;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        pozo.pasarObstaculo((Moto) moto, juego.obtenerJugador());
        piquete.pasarObstaculo((Moto) moto, juego.obtenerJugador());

        assertTrue(moto.verificarUbicacion(nuevaUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }
}
