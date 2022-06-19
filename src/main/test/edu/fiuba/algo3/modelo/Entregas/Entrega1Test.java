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
    private String nombre2 = "Juan";


    private int fila = 1;
    private int columna = 1;

    private  int fila2 = 2;

    private  int columna2 = 2;
    private Jugador jugador2 = new Jugador(nombre2, new Moto((new Ubicacion(fila2, columna2))));
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener7Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(Escenario.getInstance(), jugador, jugador2);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 7;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.atravesar(pozo);

        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnAutoSeMuevePorLaCiudad6VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener9Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(Escenario.getInstance(), jugador, jugador2);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 1;
        int nuevaColumna = 3;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        juego.moverVehiculo(new DireccionIzquierda());
        juego.moverVehiculo(new DireccionArriba());

        auto.atravesar(pozo);

        assertTrue(auto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaCamionetaSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener4Movimientos () {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(Escenario.getInstance(), jugador, jugador2);
        Obstaculo pozo = new Pozo();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 4;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        camioneta.atravesar(pozo);

        assertTrue(camioneta.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPiqueteDeberiaEstarEnOtraUbicacionYTener6Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(Escenario.getInstance(), jugador, jugador2);
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 6;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.atravesar(piquete);

        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoYUnPiqueteDeberiaEstarEnOtraUbicacionYTener9Movimientos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(Escenario.getInstance(), jugador, jugador2);
        Obstaculo pozo = new Pozo();
        Obstaculo piquete = new Piquete();
        int nuevaFila = 2;
        int nuevaColumna = 4;
        Ubicacion nuevoUbicacion = (new Ubicacion(nuevaFila, nuevaColumna));
        int movimientosEsperados = 9;

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.atravesar(pozo);
        moto.atravesar(piquete);

        assertTrue(moto.verificarUbicacion(nuevoUbicacion));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }
}
