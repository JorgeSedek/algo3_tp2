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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {
    private String nombre = "Tomas";
    private String nombre2 = "Juan";

    private int fila = 1;
    private int columna = 1;
    private int fila2 = 2;
    private int columna2 = 2;

    private Jugador jugador2 = new Jugador(nombre2, new Moto(new Casillero(new Ubicacion(fila2, columna2))));
    private int totalFilas = 8;
    private int totalColumnas = 8;

    private Escenario escenario = Escenario.getInstance();

    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaFavorableDeberiaTener10Movimientos() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);

        escenario = Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        Sorpresa favorable = new Favorable();

        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos

        moto.recibe(favorable);

        int movimientosEsperados = 10;

        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }



    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaDesfavorableDeberiaTener14Movimientos() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);

        escenario = Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        Sorpresa desfavorable = new Desfavorable();

        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos

        moto.recibe(desfavorable);

        int movimientosEsperados = 15;

        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaCambioDeVehiculoDeberiaConvertirseEnAuto() {

        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, vehiculo);

        escenario = Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        Sorpresa cambioVehiculo = new CambioVehiculo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());


        vehiculo.recibe(cambioVehiculo);
        jugador.cambiarVehiculo(vehiculo.cambio());

        Vehiculo vehiculoEsperado = new Auto(casillero);

        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }

   @Test
    public void UnaCamionetaSeEncuentraConSorpresaCambioDeVehiculoYUnPiqueteDeberiaPoderPasarElPiqueteYTener6Movimientos(){

        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, vehiculo);


        escenario = Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Obstaculo piquete = new Piquete();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());


       vehiculo.recibe(cambioVehiculo);
       jugador.cambiarVehiculo(vehiculo.cambio());
       jugador.obtenerVehiculo().recibe(piquete);

       int movimientosEsperados = 6;

       int fila = 2;
       int columna = 4;

       Vehiculo vehiculoEsperado = new Moto(new Casillero(new Ubicacion(fila,columna)));

       assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
       assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }


    @Test
    public void UnaCamionetaSeMueve4VecesPorLaCiudadYSeEncuentra4VecesConPozoDeberiaTener7Movimientos(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo vehiculo = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, vehiculo);

        escenario = Escenario.resetInstance(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador, jugador2);
        Obstaculo pozo = new Pozo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        for(int i=0; i<4; i++){
            vehiculo.recibe(pozo);
        }

        int movimientosEsperados = 7;

        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }
}
