package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PoliciaTest {
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
        Policia policia = new Policia();
        policia.cambiarMath(mathMock);
        Vehiculo moto = new Moto(ubicacionInicial);
        when(mathMock.darNumeroAleatorio()).thenReturn(randomFallo);
        moto.atravesar(policia);
        assertTrue(moto.verificarMovimientos(cantidadMovimientosSiParan));
    }

    @Test
    public void unaMotoPasaPorControlPolicialYNoLoParanDeberiaTener0Movimientos() {
        IMath mathMock = mock(IMath.class);
        Policia policia = new Policia();
        policia.cambiarMath(mathMock);
        Vehiculo moto = new Moto(ubicacionInicial);
        when(mathMock.darNumeroAleatorio()).thenReturn(randomExito);
        moto.atravesar(policia);
        assertTrue(moto.verificarMovimientos(cantidadMovimientosSiNoParan));
    }

    @Test
    public void unAutoPasaPorControlPolicialYLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Policia policia = new Policia();
        policia.cambiarMath(mathMock);
        Vehiculo auto = new Auto(ubicacionInicial);
        when(mathMock.darNumeroAleatorio()).thenReturn(randomFallo);
        auto.atravesar(policia);
        assertTrue(auto.verificarMovimientos(cantidadMovimientosSiParan));
    }

    @Test
    public void unAutoPasaPorControlPolicialYNoLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Policia policia = new Policia();
        policia.cambiarMath(mathMock);
        Vehiculo auto = new Auto(ubicacionInicial);
        when(mathMock.darNumeroAleatorio()).thenReturn(randomExito);
        auto.atravesar(policia);
        assertTrue(auto.verificarMovimientos(cantidadMovimientosSiNoParan));
    }

    @Test
    public void unaCamionetaPasaPorControlPolicialYLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Policia policia = new Policia();
        policia.cambiarMath(mathMock);
        Vehiculo camioneta = new Camioneta(ubicacionInicial);
        when(mathMock.darNumeroAleatorio()).thenReturn(randomFallo);
        camioneta.atravesar(policia);
        assertTrue(camioneta.verificarMovimientos(cantidadMovimientosSiParan));
    }

    @Test
    public void unaCamionetaPasaPorControlPolicialYNoLoParanDeberiaTener3Movimientos() {
        IMath mathMock = mock(IMath.class);
        Policia policia = new Policia();
        policia.cambiarMath(mathMock);
        Vehiculo camioneta = new Camioneta(ubicacionInicial);
        when(mathMock.darNumeroAleatorio()).thenReturn(randomExito);
        camioneta.atravesar(policia);
        assertTrue(camioneta.verificarMovimientos(cantidadMovimientosSiNoParan));
    }
}