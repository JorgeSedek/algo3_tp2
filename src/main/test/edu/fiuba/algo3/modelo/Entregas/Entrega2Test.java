package edu.fiuba.algo3.modelo.Entregas;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.*;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;

import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {
    private String nombre = "Tomas";
    private int fila = 2;
    private int columna = 2;
    private int totalFilas = 20;
    private int totalColumnas = 20;

    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaFavorableDeberiaTener10Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        edu.fiuba.algo3.modelo.Sorpresas.Sorpresa favorable = new Favorable();
        Ubicacion ubicacionFavorable = (new Ubicacion(13, 14));
        Escenario.getInstance().agregarSorpresaEn(ubicacionFavorable, favorable);

        // Act
        for (int i = 0; i < 6; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
            Juego.getInstance().moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos

        // Assert
        int movimientosEsperados = 9;

        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaDesfavorableDeberiaTener14Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        edu.fiuba.algo3.modelo.Sorpresas.Sorpresa desfavorable = new Desfavorable();
        Ubicacion ubicacionDesfavorable = (new Ubicacion(13, 14));
        Escenario.getInstance().agregarSorpresaEn(ubicacionDesfavorable, desfavorable);

        // Act
        for (int i = 0; i < 6; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
            Juego.getInstance().moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos

        // Assert
        int movimientosEsperados = 15;

        assertTrue(Juego.getInstance().verificarMovJugadorActivo(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaCambioDeVehiculoDeberiaConvertirseEnAuto() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, vehiculo);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        edu.fiuba.algo3.modelo.Sorpresas.Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacionCambioV = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarSorpresaEn(ubicacionCambioV, cambioVehiculo);

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());

        // Assert
        Vehiculo vehiculoEsperado = new Auto(ubicacion);

        assertTrue(jugador1.mismoVehiculo(vehiculoEsperado));
    }

   @Test
    public void UnaCamionetaSeEncuentraConSorpresaCambioDeVehiculoYUnPiqueteDeberiaPoderPasarElPiqueteYTener6Movimientos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Camioneta(ubicacion);
        Jugador jugador1 = new Jugador(nombre, vehiculo);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        edu.fiuba.algo3.modelo.Sorpresas.Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacionCambioV = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarSorpresaEn(ubicacionCambioV, cambioVehiculo);

        Obstaculo piquete = new Piquete();
        Ubicacion ubicacionPiquete = (new Ubicacion(2, 5));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        // Act
        for (int i = 0; i < 3; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }
        Juego.getInstance().moverVehiculo(new DireccionAbajo());

       // Assert
       int movimientosEsperados = 6;
       int fila = 4;
       int columna = 8;
       Vehiculo vehiculoEsperado = new Moto((new Ubicacion(fila,columna)));

       assertTrue(jugador1.mismoVehiculo(vehiculoEsperado));
       assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }
    @Test
    public void UnaCamionetaSeMueve4VecesPorLaCiudadYSeEncuentra4VecesConPozoDeberiaTener7Movimientos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Camioneta(ubicacion);
        Jugador jugador1 = new Jugador(nombre, vehiculo);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionPozo = (new Ubicacion(2, 3));
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        // Act
        for (int i = 0; i < 2; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
            Juego.getInstance().moverVehiculo(new DireccionIzquierda());
        }

        // Assert
        int movimientosEsperados = 7;

        assertTrue(jugador1.verificarMovimientos(movimientosEsperados));
    }
}