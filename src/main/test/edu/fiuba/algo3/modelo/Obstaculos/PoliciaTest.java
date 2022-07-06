package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PoliciaTest {
    String nombre = "Tomas";
    private int fila = 2;
    private int col = 2;
    private int cantidadMovimientosSiParan = 3;
    private int cantidadMovimientosSiNoParan = 0;

    private double randomFallo = 0.1;
    private double randomExito = 0.9;
    private Ubicacion ubicacionInicial = (new Ubicacion(fila, col));

    @Test
    public void unaMotoPasaPorControlPolicialYLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Obstaculo policia = new Policia(mathMock);
        Vehiculo moto = new Moto(ubicacionInicial);
        Jugador jugador = new Jugador(nombre, moto);
        Efecto efecto = new EfectoGeneral();
        when(mathMock.random()).thenReturn(randomFallo);
        efecto = moto.atravesar(policia);
        efecto.aplicar(jugador);
        assertTrue(jugador.verificarMovimientos(cantidadMovimientosSiParan));
    }

    @Test
    public void unaMotoPasaPorControlPolicialYNoLoParanDeberiaTener0Movimientos() {
        IMath mathMock = mock(IMath.class);
        Obstaculo policia = new Policia(mathMock);
        Vehiculo moto = new Moto(ubicacionInicial);
        Jugador jugador = new Jugador(nombre, moto);
        Efecto efecto = new EfectoGeneral();
        when(mathMock.random()).thenReturn(randomExito);
        efecto = moto.atravesar(policia);
        efecto.aplicar(jugador);
        assertTrue(jugador.verificarMovimientos(cantidadMovimientosSiNoParan));
    }

    @Test
    public void unAutoPasaPorControlPolicialYLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Obstaculo policia = new Policia(mathMock);
        Vehiculo auto = new Auto(ubicacionInicial);
        Jugador jugador = new Jugador(nombre, auto);
        Efecto efecto = new EfectoGeneral();
        when(mathMock.random()).thenReturn(randomFallo);
        efecto = auto.atravesar(policia);
        efecto.aplicar(jugador);
        assertTrue(jugador.verificarMovimientos(cantidadMovimientosSiParan));
    }

    @Test
    public void unAutoPasaPorControlPolicialYNoLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Obstaculo policia = new Policia(mathMock);
        Vehiculo auto = new Auto(ubicacionInicial);
        Jugador jugador = new Jugador(nombre, auto);
        Efecto efecto = new EfectoGeneral();
        when(mathMock.random()).thenReturn(randomExito);
        efecto = auto.atravesar(policia);
        efecto.aplicar(jugador);
        assertTrue(jugador.verificarMovimientos(cantidadMovimientosSiNoParan));
    }

    @Test
    public void unaCamionetaPasaPorControlPolicialYLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Obstaculo policia = new Policia(mathMock);
        Vehiculo camioneta = new Camioneta(ubicacionInicial);
        Jugador jugador = new Jugador(nombre, camioneta);
        Efecto efecto = new EfectoGeneral();
        when(mathMock.random()).thenReturn(randomFallo);
        efecto = camioneta.atravesar(policia);
        efecto.aplicar(jugador);
        assertTrue(jugador.verificarMovimientos(cantidadMovimientosSiParan));
    }

    @Test
    public void unaCamionetaPasaPorControlPolicialYNoLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Obstaculo policia = new Policia(mathMock);
        Vehiculo camioneta = new Camioneta(ubicacionInicial);
        Jugador jugador = new Jugador(nombre, camioneta);
        Efecto efecto = new EfectoGeneral();
        when(mathMock.random()).thenReturn(randomExito);
        efecto = camioneta.atravesar(policia);
        efecto.aplicar(jugador);
        assertTrue(jugador.verificarMovimientos(cantidadMovimientosSiNoParan));
    }
}