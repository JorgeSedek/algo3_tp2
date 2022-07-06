package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Math.IMath;
import edu.fiuba.algo3.modelo.Meta.MetaFinal;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Policia;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PruebasPuntaAPunta {
    private String nombre = "Martin";
    private String nombre2 = "Pepito";
    private int totalFilas = 4;
    private int totalColumnas = 4;
    private int filaInicial = 2;
    private int columnaInicial = 2;

    @Test
    public void seJuegaUnaPartidaCompletaCon1Jugador() {
        Logger.getInstance().activar();

        IMath mathMock = mock(IMath.class);
        when(mathMock.random()).thenReturn(0.1);
        Escenario.resetInstance(totalFilas, totalColumnas);
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(2,3), new Piquete());
        Escenario.getInstance().agregarSorpresaEn(new Ubicacion(2,3), new CambioVehiculo());
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(3,2), new Pozo());
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(3,4), new Pozo());
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(4,5), new Policia(mathMock));
        Escenario.getInstance().agregarSorpresaEn(new Ubicacion(7,6), new Favorable());
        Escenario.getInstance().agregarSorpresaEn(new Ubicacion(8,7), new Desfavorable());
        Escenario.getInstance().agregarMetaEn(new Ubicacion(8, 9), new MetaFinal());

        Vehiculo auto = new Auto(new Ubicacion(filaInicial, columnaInicial));
        Jugador jugador1 = new Jugador(nombre, auto);

        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
        }};
        Juego.resetInstance(jugadores);

        int movEsperadosJugador1 = 0;

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 2,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionArriba()); // 2,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionIzquierda()); // 2,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 4,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionArriba()); // 2,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 4,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionArriba()); // 2,2 Jugador 1
        movEsperadosJugador1 += 4;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 4,2 Jugador 1
        movEsperadosJugador1 += 4;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 4,4 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 4,6 Jugador 1
        movEsperadosJugador1 += 4;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 6,6 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 8,6 Jugador 1
        movEsperadosJugador1++;
        movEsperadosJugador1 = (int) (movEsperadosJugador1 * 0.8);
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 8,8 Jugador 1
        movEsperadosJugador1++;
        movEsperadosJugador1 = (int) (movEsperadosJugador1 * 1.25);
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionArriba()); // 6,8 Jugador 1
        movEsperadosJugador1++;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 6,8 Jugador 1
        movEsperadosJugador1++;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 8,8 Jugador 1
        movEsperadosJugador1++;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 8,8 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // FIN Jugador 1

        Logger.getInstance().desactivar();
    }

    @Test
    public void seJuegaUnaPartidaCompletaCon2Jugadores() {
        Logger.getInstance().activar();

        IMath mathMock = mock(IMath.class);
        when(mathMock.random()).thenReturn(0.1);
        Escenario.resetInstance(totalFilas, totalColumnas);
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(2,3), new Piquete());
        Escenario.getInstance().agregarSorpresaEn(new Ubicacion(2,3), new CambioVehiculo());
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(3,2), new Pozo());
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(3,4), new Pozo());
        Escenario.getInstance().agregarObstaculoEn(new Ubicacion(4,5), new Policia(mathMock));
        Escenario.getInstance().agregarSorpresaEn(new Ubicacion(7,6), new Favorable());
        Escenario.getInstance().agregarSorpresaEn(new Ubicacion(8,7), new Desfavorable());
        Escenario.getInstance().agregarMetaEn(new Ubicacion(8, 9), new MetaFinal());

        Vehiculo moto = new Moto(new Ubicacion(filaInicial, columnaInicial));
        Jugador jugador1 = new Jugador(nombre, moto);
        Vehiculo camioneta = new Camioneta(new Ubicacion(filaInicial, columnaInicial));
        Jugador jugador2 = new Jugador(nombre2, camioneta);

        List<Jugador> jugadores = new ArrayList<>() {{
            add(jugador1);
            add(jugador2);
        }};
        Juego.resetInstance(jugadores);

        int movEsperadosJugador1 = 0;
        int movEsperadosJugador2 = 0;

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 2,2 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));
        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 2,4 Jugador 2
        movEsperadosJugador2 += 3;
        assertTrue(jugador2.verificarMovimientos(movEsperadosJugador2));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 4,2 Jugador 1
        movEsperadosJugador1 += 4;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));
        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 4,4 Jugador 2
        movEsperadosJugador2 += 4;
        assertTrue(jugador2.verificarMovimientos(movEsperadosJugador2));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 4,4 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));
        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 4,6 Jugador 2
        movEsperadosJugador2 += 4;
        assertTrue(jugador2.verificarMovimientos(movEsperadosJugador2));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 4,6 Jugador 1
        movEsperadosJugador1 += 4;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));
        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 6,6 Jugador 2
        movEsperadosJugador2 += 1;
        assertTrue(jugador2.verificarMovimientos(movEsperadosJugador2));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 6,6 Jugador 1
        movEsperadosJugador1 += 1;
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));
        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 8,6 Jugador 2
        movEsperadosJugador2++;
        movEsperadosJugador2 = (int) (movEsperadosJugador2 * 0.8);
        assertTrue(jugador2.verificarMovimientos(movEsperadosJugador2));

        Juego.getInstance().moverVehiculo(new DireccionAbajo()); // 8,6 Jugador 1
        movEsperadosJugador1++;
        movEsperadosJugador1 = (int) (movEsperadosJugador1 * 0.8);
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));
        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 8,8 Jugador 2
        movEsperadosJugador2++;
        movEsperadosJugador2 = (int) (movEsperadosJugador2 * 1.25);
        assertTrue(jugador2.verificarMovimientos(movEsperadosJugador2));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 8,8 Jugador 1
        movEsperadosJugador1++;
        movEsperadosJugador1 = (int) (movEsperadosJugador1 * 1.25);
        assertTrue(jugador1.verificarMovimientos(movEsperadosJugador1));

        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // FIN Jugador 2
        Juego.getInstance().moverVehiculo(new DireccionDerecha()); // FIN Jugador 1

        Logger.getInstance().desactivar();
    }
}

