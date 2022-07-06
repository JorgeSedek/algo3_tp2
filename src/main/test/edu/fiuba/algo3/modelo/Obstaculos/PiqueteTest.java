package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Colocador.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PiqueteTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void unJugadorPasaPorUnPiqueteConMotoDeberiaSumarse2MovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);

        Efecto efecto = moto.atravesar(piquete);
        efecto.aplicar(jugador);

        int cantidadMovimientos = 2;

        assertTrue(jugador.verificarMovimientos(cantidadMovimientos));
    }



    @Test
    public void unJugadorPasaPorUnPiqueteConAutoNoDeberiaSumarseMovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo auto = new Auto(ubicacion);
        Jugador jugador = new Jugador(nombre, auto);

        Efecto efecto = auto.atravesar(piquete);
        efecto.aplicar(jugador);

        int cantidadMovimientos = 0;

        assertTrue(jugador.verificarMovimientos(cantidadMovimientos));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConAutoNoDeberiaCambiarUbicacion() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacionJugador = new Ubicacion(fila,columna);
        Ubicacion ubicacionBuscada = new Ubicacion(fila,columna);
        int columnaNueva = 2;
        Ubicacion ubicacion = (new Ubicacion(fila, columnaNueva));
        Escenario.getInstance().agregarObstaculoEn(ubicacion, piquete);
        Vehiculo auto = new Auto(ubicacionJugador);
        Jugador jugador = new Jugador(nombre, auto);
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Juego.resetInstance(jugadores);

        jugador.moverVehiculo(new DireccionDerecha());

        assertTrue(jugador.verificarUbicacion(ubicacionBuscada));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConCamionetaNoDeberiaCambiarUbicacion() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacion = (new Ubicacion(1, 2));
        Escenario.getInstance().agregarObstaculoEn(ubicacion, piquete);
        Ubicacion ubicacionJugador = new Ubicacion(fila,columna);
        Vehiculo camioneta = new Camioneta(ubicacionJugador);
        Jugador jugador = new Jugador(nombre, camioneta);
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Juego.resetInstance(jugadores);

        jugador.moverVehiculo(new DireccionDerecha());

        Ubicacion ubicacionBuscada = new Ubicacion(fila,columna);
        assertTrue(jugador.verificarUbicacion(ubicacionBuscada));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConMotoDeberiaCambiarUbicacion() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacionJugador = new Ubicacion(fila,columna);
        Ubicacion ubicacionBuscada = new Ubicacion(fila,columna);
        Ubicacion ubicacion = (new Ubicacion(1, 2));
        Escenario.getInstance().agregarObstaculoEn(ubicacion, piquete);
        Vehiculo moto = new Moto(ubicacionJugador);
        Jugador jugador = new Jugador(nombre, moto);
        List<Jugador> jugadores = new ArrayList<>(){
            {add(jugador);}
        };
        Juego.resetInstance(jugadores);

        jugador.moverVehiculo(new DireccionDerecha());

        assertFalse(jugador.verificarUbicacion(ubicacionBuscada));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConCamionetaNoDeberiaSumarseMovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);

        Efecto efecto = camioneta.atravesar(piquete);
        efecto.aplicar(jugador);

        int cantidadMovimientos = 0;

        assertTrue(jugador.verificarMovimientos(cantidadMovimientos));
    }



}
