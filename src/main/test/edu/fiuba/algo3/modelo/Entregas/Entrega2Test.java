package edu.fiuba.algo3.modelo.Entregas;


import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.*;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;

import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {
    private String nombre = "Tomas";
    private int fila = 1;
    private int columna = 1;
    private int totalFilas = 8;
    private int totalColumnas = 8;

    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaFavorableDeberiaTener10Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Sorpresa favorable = new Favorable();

        // Act
        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos

        moto.atravesar(favorable);

        // Assert
        int movimientosEsperados = 10;

        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaDesfavorableDeberiaTener14Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Sorpresa desfavorable = new Desfavorable();

        // Act
        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos

        moto.atravesar(desfavorable);

        // Assert
        int movimientosEsperados = 15;

        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaCambioDeVehiculoDeberiaConvertirseEnAuto() {
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Moto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, vehiculo);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Sorpresa cambioVehiculo = new CambioVehiculo();

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        vehiculo.atravesar(cambioVehiculo);
        jugador1.cambiarVehiculo(vehiculo.cambio());

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
        Juego juego = new Juego(jugadores);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Obstaculo piquete = new Piquete();

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());


       vehiculo.atravesar(cambioVehiculo);
       jugador1.cambiarVehiculo(vehiculo.cambio());
       jugador1.obtenerVehiculo().atravesar(piquete);

       // Assert
       int movimientosEsperados = 6;

       int fila = 2;
       int columna = 4;

       Vehiculo vehiculoEsperado = new Moto((new Ubicacion(fila,columna)));

       assertTrue(jugador1.mismoVehiculo(vehiculoEsperado));
       assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
    }
    @Test
    public void UnaCamionetaSeMueve4VecesPorLaCiudadYSeEncuentra4VecesConPozoDeberiaTener7Movimientos(){
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Camioneta(ubicacion);
        Jugador jugador1 = new Jugador(nombre, vehiculo);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};

        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(jugadores);
        Obstaculo pozo = new Pozo();

        // Act
        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        for(int i=0; i<4; i++){
            vehiculo.atravesar(pozo);
        }

        // Assert
        int movimientosEsperados = 7;

        assertTrue(juego.verificarMovJugadorActivo(movimientosEsperados));
    }
}
