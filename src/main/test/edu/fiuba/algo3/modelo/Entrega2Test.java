package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {
    private String nombre = "Tomas";
    private int fila = 1;
    private int columna = 1;
    private int totalFilas = 8;
    private int totalColumnas = 8;


    @Test
    public void UnaMotoSeMuevePorLaCiudad12VecesYSeEncuentraUnaSorpresaFavorableDeberiaTener10Movimientos() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        ObjetoUrbano favorable = new Favorable();

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
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        ObjetoUrbano desfavorable = new Desfavorable();

        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // Realizo 12 movimientos
        moto.recibe(desfavorable);
        int movimientosEsperados = 15;

        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

    /*@Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaCambioDeVehiculoDeberiaConvertirseEnAuto() {
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        ObjetoUrbano cambioVehiculo = new CambioVehiculo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        moto.recibe(cambioVehiculo);

        Vehiculo vehiculoEsperado = new Auto(ubicacion);

        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
    }*/

    /*@Test
    public void UnaCamionetaSeEncuentraConSorpresaCambioDeVehiculoYUnPiqueteDeberiaPoderPasarElPiqueteYTener6Movimientos(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, camioneta);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        ObjetoUrbano cambioVehiculo = new CambioVehiculo();
        ObjetoUrbano piquete = new Piquete();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        camioneta.recibe(cambioVehiculo);
        camioneta.recibe(piquete);

        int movimientosEsperados = 6;
        Vehiculo vehiculoEsperado = new Moto(ubicacion);

        assertTrue(jugador.mismoVehiculo(vehiculoEsperado));
        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }*/

    @Test
    public void UnaCamionetaSeMueve4VecesPorLaCiudadYSeEncuentra4VecesConPozoDeberiaTener7Movimientos(){
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, camioneta);
        Escenario escenario = new Escenario(totalFilas, totalColumnas);
        Juego juego = new Juego(escenario, jugador);
        ObjetoUrbano pozo = new Pozo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        for(int i=0; i<4; i++){
            camioneta.recibe(pozo);
        }

        int movimientosEsperados = 7;

        assertTrue(jugador.verificarMovimiento(movimientosEsperados));
    }

}