package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FavorableTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void unJugadorPasaPorUnaSorpresaFavorableConMotoDeberiaDescontarse20PorcientoDeMovimientosAJugador() {
        Sorpresa favorable = new Favorable();
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        int cantidadMovimientosHechos = 10;
        int cantidadMovimientosEsperados = (int) (cantidadMovimientosHechos * 0.8);

        moto.incrementarMovimientos(cantidadMovimientosHechos);

        moto.recibe(favorable);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientosEsperados));
    }

    @Test
    public void unJugadorPasaPorUnaSorpresaFavorableConAutoDeberiaDescontarse20PorcientoDeMovimientosAJugador() {
        Sorpresa favorable = new Favorable();
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(casillero);
        Jugador jugador = new Jugador(nombre, auto);
        int cantidadMovimientosHechos = 10;
        int cantidadMovimientosEsperados = (int) (cantidadMovimientosHechos * 0.8);

        auto.incrementarMovimientos(cantidadMovimientosHechos);

        auto.recibe(favorable);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientosEsperados));
    }

    @Test
    public void unJugadorPasaPorUnaSorpresaFavorableConCamionetaDeberiaDescontarse20PorcientoDeMovimientosAJugador() {
        Sorpresa favorable = new Favorable();
        Casillero casillero = new Casillero(new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, camioneta);
        int cantidadMovimientosHechos = 10;
        int cantidadMovimientosEsperados = (int) (cantidadMovimientosHechos * 0.8);

        camioneta.incrementarMovimientos(cantidadMovimientosHechos);

        camioneta.recibe(favorable);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientosEsperados));
    }
}
