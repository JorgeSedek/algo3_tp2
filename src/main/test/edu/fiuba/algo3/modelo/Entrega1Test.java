package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega1Test {

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener7Movimientos () {
        Vehiculo moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", moto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        pozo.pasarObstaculo((Moto) moto, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertTrue(juego.obtenerUbicacionJugador().equals(new Ubicacion(2, 4)));
        //assertEquals(juego.obtenerJugador().verificarMovimiento(7), true);
        assertTrue(juego.obtenerJugador().verificarMovimiento(7));
    }

    @Test
    public void UnAutoSeMuevePorLaCiudad6VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener9Movimientos () {
        Vehiculo auto = new Auto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", auto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        juego.moverVehiculo(new DireccionIzquierda());
        juego.moverVehiculo(new DireccionArriba());

        pozo.pasarObstaculo((Auto) auto, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertTrue(juego.obtenerUbicacionJugador().equals(new Ubicacion(1, 3)));
        assertTrue(juego.obtenerJugador().verificarMovimiento(9));
    }

    @Test
    public void UnaCamionetaSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoDeberiaEstarEnOtraUbicacionYTener4Movimientos () {
        Vehiculo camioneta = new Camioneta(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", camioneta);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        pozo.pasarObstaculo((Camioneta) camioneta, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertTrue(juego.obtenerUbicacionJugador().equals(new Ubicacion(2, 4)));
        assertTrue(juego.obtenerJugador().verificarMovimiento(4));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPiqueteDeberiaEstarEnOtraUbicacionYTener6Movimientos() {
        Vehiculo moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", moto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo piquete = new Piquete();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        piquete.pasarObstaculo((Moto) moto, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertTrue(juego.obtenerUbicacionJugador().equals(new Ubicacion(2, 4)));
        assertTrue(juego.obtenerJugador().verificarMovimiento(6));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraConUnPozoYUnPiqueteDeberiaEstarEnOtraUbicacionYTener9Movimientos(){
        Vehiculo moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", moto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();
        Obstaculo piquete = new Piquete();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        pozo.pasarObstaculo((Moto) moto, juego.obtenerJugador());
        piquete.pasarObstaculo((Moto) moto, juego.obtenerJugador());

        // La ubicacion se tendria que haber actualizado y la penalizacion efectuada
        assertTrue(juego.obtenerUbicacionJugador().equals(new Ubicacion(2, 4)));
        assertTrue(juego.obtenerJugador().verificarMovimiento(9));
    }
}
