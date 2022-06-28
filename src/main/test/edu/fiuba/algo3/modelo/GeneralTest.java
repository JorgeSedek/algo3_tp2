package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Meta.MetaFinal;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest {
    private String nombre = "Martin";
    private int totalFilas = 40;
    private int totalColumnas = 40;
    private int filaInicial = 2;
    private int columnaInicial = 2;

    @Test
    public void seAgregaUnPozoAlEscenarioDelJuegoYUnAutoSeMueveYPasaPorElDeberiaTener4Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Pozo pozo = new Pozo();
        Ubicacion ubicacionPozo = new Ubicacion(2,3);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        // Act
        Juego.getInstance().moverVehiculo(new DireccionDerecha());

        // Assert
        assertTrue(jugador1.verificarMovimientos(4));
    }

    @Test
    public void seAgregaUnaSorpresaFavorableAlEscenarioDelJuegoYUnAutoSeMueveYPasaPorEstaDeberiaTener10Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        // Act
        Sorpresa sorpresaFavorable = new Favorable();
        Ubicacion ubicacionSorpresa = new Ubicacion(2,25);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa, sorpresaFavorable);


        for (int i = 0; i < 12; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha()); // Me muevo 12 veces a la derecha
        }

        // Al momento de pasar por la sorpresa, tiene 11 movimientos, luego de aplicarse tiene 9
        // y por ultimo se mueve una vez mas a la derecha, teniendo 10 movimientos

        // Assert
        assertTrue(auto.verificarUbicacion(new Ubicacion(2,26)));
        assertTrue(jugador1.verificarMovimientos(10));
    }

    @Test
    public void seAgregaUnaSorpresaDesfavorableAlEscenarioDelJuegoYUnAutoSeMueveYPasaPorEstaDeberiaTener10Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador1 = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>() {{ add(jugador1); }};
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        // Act
        Sorpresa sorpresaDesfavorable = new Desfavorable();
        Ubicacion ubicacionSorpresa = new Ubicacion(2,25);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa, sorpresaDesfavorable);

        for (int i = 0; i < 12; i++) {
            Juego.getInstance().moverVehiculo(new DireccionDerecha()); // Me muevo 12 veces a la derecha
        }

        // Assert
        assertTrue(auto.verificarUbicacion(new Ubicacion(2,26)));
        assertTrue(jugador1.verificarMovimientos(15));
    }

    @Test
    public void SeAgregaUnaSorpresaDesvaforableYUnPozoAlEscenarioYCamionetaSeMueveDeberiaTener13(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador0 = new Jugador(nombre, camioneta);
        int cantMovimientos = 13;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador0);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Sorpresa sorpresaDes = new Desfavorable();
        Ubicacion ubicacionSorpresa = new Ubicacion(2,15);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa, sorpresaDes);
        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionObstaculo = new Ubicacion(2,7);
        Escenario.getInstance().agregarObstaculoEn(ubicacionObstaculo, pozo);

        for(int i=0; i<12; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }

        assertTrue(jugador0.verificarMovimientos(cantMovimientos));
    }

    @Test
    public void SeAgrega2SorpresasDesfavorablesYAutoPasaPorLasDosSuMovimientoDeberiaSer11(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador0 = new Jugador(nombre, auto);
        int cantMovimientos = 11;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador0);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Sorpresa sorpresaDes1 = new Desfavorable();
        Ubicacion ubicacionSorpresa1 = new Ubicacion(2,17);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa1, sorpresaDes1);
        Sorpresa sorpresaDes2 = new Desfavorable();
        Ubicacion ubicacionSorpresa2 = new Ubicacion(2,13);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa2, sorpresaDes2);

        for(int i=0; i<8; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }

        assertTrue(auto.verificarUbicacion(new Ubicacion(2,18)));
        assertTrue(jugador0.verificarMovimientos(cantMovimientos));
    }

    @Test
    public void unAutoPasaPorUnCasilleroQueTieneUnPozoYUnaSorpresaDesfavorableYSeAplicaPrimeroLaSorpresa(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int movimientosEsperados = 14;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Sorpresa sorpresaDesfavorable = new Desfavorable();
        Ubicacion ubicacionSorpresa = new Ubicacion(2,19);
        Escenario.getInstance().agregarSorpresaEn(ubicacionSorpresa, sorpresaDesfavorable);
        Pozo pozo = new Pozo();
        Ubicacion ubicacionPozo = new Ubicacion(2,19);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        for(int i=0; i<9; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }

        // 2-18 8 mov
        // 2-19 9 mov (se encuentra con la sorpresa y el obstaculo)
        // 2-20 (9 mov + 9 mov * 0.25 + 3) = 14
        // Notamos que primero se aplico la sorpresa y despues el obstaculo, sino los movimientos serian 15

        assertTrue(auto.verificarUbicacion(new Ubicacion(2,20)));
        assertTrue(jugador.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void unAutoIntentaPasarPorUnCasilleroQueTieneUnPiqueteNoDeberiaPoderPasar(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);
        int movimientosEsperados = 9;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Piquete piquete = new Piquete();
        Ubicacion ubicacionPiquete = new Ubicacion(2,19);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        for(int i=0; i<9; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }

        assertTrue(auto.verificarUbicacion(new Ubicacion(2,18)));
        assertTrue(jugador.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void unaCamionetaIntentaPasarPorUnCasilleroQueTieneUnPiqueteNoDeberiaPoderPasar(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        int movimientosEsperados = 9;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Piquete piquete = new Piquete();
        Ubicacion ubicacionPiquete = new Ubicacion(2,19);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        for(int i=0; i<9; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }

        assertTrue(camioneta.verificarUbicacion(new Ubicacion(2,18)));
        assertTrue(jugador.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void unaMotoIntentaPasarPorUnCasilleroQueTieneUnPiqueteDeberiaPoderPasarYRecibirPenalizacion(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        int movimientosEsperados = 11;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Piquete piquete = new Piquete();
        Ubicacion ubicacionPiquete = new Ubicacion(2,19);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        for(int i=0; i<9; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha());
        }

        assertTrue(moto.verificarUbicacion(new Ubicacion(2,20)));
        assertTrue(jugador.verificarMovimientos(movimientosEsperados));
    }

    @Test
    public void unaMotoPasaPorUnaMetaSeLlamaAlFinalizarDeJuegoYSeAgregaLaPuntuacionDelJugador(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        int movimientosEsperados = 9;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Meta meta = new MetaFinal();
        Ubicacion ubicacionMeta = new Ubicacion(2,19);
        Escenario.getInstance().agregarMetaEn(ubicacionMeta, meta);

        // Act
        for(int i=0; i<8; i++){
            Juego.getInstance().moverVehiculo(new DireccionDerecha()); // 8 movimientos a la derecha
        }

        // Si se mueve una vez mas a la derecha, pasa por la meta
        Juego.getInstance().moverVehiculo(new DireccionDerecha());

        // Assert 1
        assertTrue(moto.verificarUbicacion(new Ubicacion(2,20)));
        assertTrue(jugador.verificarMovimientos(movimientosEsperados));

        // Assert 2
        List<Puntaje> puntajes = Juego.getInstance().obtenerPuntajes();
        Puntaje puntajeJugador = puntajes.get(0);

        assertEquals(puntajes.size(), 1);
        assertEquals(puntajeJugador.obtenerNombreJugador(), nombre);
        assertEquals(puntajeJugador.obtenerPuntuacion(), movimientosEsperados);

    }

    @Test
    public void UnaCamionetaPasaPorUnCambioDeVehiculoYJustoDespuesPorUnPiqueteDeberiaPoderPasarloYTener2Movimientos() {
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador0 = new Jugador(nombre, camioneta);
        int cantMovimientos = 3;
        List<Jugador> jugadores = new ArrayList<>() {
            { add(jugador0);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacionCambioV = new Ubicacion(2, 3);
        Escenario.getInstance().agregarSorpresaEn(ubicacionCambioV, cambioVehiculo);
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacionPiquete = new Ubicacion(2, 3);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPiquete, piquete);

        Juego.getInstance().moverVehiculo(new DireccionDerecha());

        Ubicacion nuevaUbicacion = new Ubicacion(2,4);

        assertTrue(jugador0.verificarMovimientos(cantMovimientos));
        assertTrue(jugador0.verificarUbicacion(nuevaUbicacion));
    }

    @Test
    public void SeAgregaUnCambioVehiculoYUnPozoYAutoPasaPorLosDos(){
        Ubicacion ubicacion = (new Ubicacion(filaInicial, columnaInicial));
        Vehiculo auto = new Camioneta(ubicacion);
        Jugador jugador0 = new Jugador(nombre, auto);
        int cantMovimientos = 4;
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador0);}
        };
        Escenario.resetInstance(totalFilas, totalColumnas);
        Juego.resetInstance(jugadores);

        Sorpresa cambioVehiculo = new CambioVehiculo();
        Ubicacion ubicacionCambioV = new Ubicacion(2,3);
        Escenario.getInstance().agregarSorpresaEn(ubicacionCambioV, cambioVehiculo);
        Obstaculo pozo = new Pozo();
        Ubicacion ubicacionPozo = new Ubicacion(2,3);
        Escenario.getInstance().agregarObstaculoEn(ubicacionPozo, pozo);

        Juego.getInstance().moverVehiculo(new DireccionDerecha());

        assertTrue(jugador0.verificarMovimientos(cantMovimientos));
    }
}
