package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FavorableTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void unJugadorPasaPorUnaSorpresaFavorableConMotoDeberiaDescontarse20PorcientoDeMovimientosAJugador() {
        Sorpresa favorable = new Favorable();
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        Efecto efecto = new EfectoGeneral();

        int cantidadMovimientosHechos = 10;
        int cantidadMovimientosEsperados = (int) (cantidadMovimientosHechos * 0.8);

        jugador.incrementarMovimientos(cantidadMovimientosHechos);
        efecto = moto.atravesar(favorable);
        efecto.aplicar(jugador);

        assertTrue(jugador.verificarMovimientos(cantidadMovimientosEsperados));
    }

    @Test
    public void unJugadorPasaPorUnaSorpresaFavorableConAutoDeberiaDescontarse20PorcientoDeMovimientosAJugador() {
        Sorpresa favorable = new Favorable();
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        Efecto efecto = new EfectoGeneral();

        int cantidadMovimientosHechos = 10;
        int cantidadMovimientosEsperados = (int) (cantidadMovimientosHechos * 0.8);

        jugador.incrementarMovimientos(cantidadMovimientosHechos);
        efecto = auto.atravesar(favorable);
        efecto.aplicar(jugador);

        assertTrue(jugador.verificarMovimientos(cantidadMovimientosEsperados));
    }

    @Test
    public void unJugadorPasaPorUnaSorpresaFavorableConCamionetaDeberiaDescontarse20PorcientoDeMovimientosAJugador() {
        Sorpresa favorable = new Favorable();
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        Efecto efecto = new EfectoGeneral();

        int cantidadMovimientosHechos = 10;
        int cantidadMovimientosEsperados = (int) (cantidadMovimientosHechos * 0.8);

        jugador.incrementarMovimientos(cantidadMovimientosHechos);
        efecto = camioneta.atravesar(favorable);
        efecto.aplicar(jugador);

        assertTrue(jugador.verificarMovimientos(cantidadMovimientosEsperados));
    }
}
