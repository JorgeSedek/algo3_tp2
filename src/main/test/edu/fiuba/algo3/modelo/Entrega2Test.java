package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Juego;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Entrega2Test {
    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaFavorableDeberiaTenerXMovimientos() {
        Vehiculo moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", moto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Sorpresa favorable = new Favorable();

        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // 12 movimientos sumados

        favorable.recibirSorpresa((Moto) moto, juego.obtenerJugador());

        assertTrue(juego.obtenerJugador().verificarMovimiento(10));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaDesfavorableDeberiaTenerXMovimientos() {
        Vehiculo moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", moto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Sorpresa desfavorable = new Desfavorable();

        for (int i = 0; i < 6; i++) {
            juego.moverVehiculo(new DireccionDerecha());
            juego.moverVehiculo(new DireccionAbajo());
        }
        // 12 movimientos sumados

        desfavorable.recibirSorpresa((Moto) moto, juego.obtenerJugador());

        assertTrue(juego.obtenerJugador().verificarMovimiento(14));
    }

    @Test
    public void UnaMotoSeMuevePorLaCiudad4VecesYSeEncuentraUnaSorpresaCambioDeVehiculoDeberiaConvertirseEnAuto() {
        Vehiculo moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Martin", moto);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Sorpresa cambioVehiculo = new CambioVehiculo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());
        // 4 movimientos sumados

        cambioVehiculo.recibirSorpresa((Moto) moto, juego.obtenerJugador());

        Vehiculo auto = new Auto(new Ubicacion(1,1), new MovimientoNormal());
        for (int i = 0; i < 3; i++) {
            auto.mover(new DireccionDerecha());
        }
        auto.mover(new DireccionAbajo());
        // 4 movimientos sumados

        assertTrue(juego.obtenerJugador().mismoVehiculo(auto));
    }

    @Test
    public void UnCamionSeEncuentraConSorpresaCambioDeVehiculoYUnPiquete(){
        Vehiculo camion = new Camioneta(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Cr", camion);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Sorpresa cambioVehiculo = new CambioVehiculo();
        Obstaculo piquete = new Piquete();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        cambioVehiculo.recibirSorpresa((Camioneta) camion, juego.obtenerJugador());
        piquete.pasarObstaculo((Moto)juego.obtenerJugador().obtenerVehiculo(), juego.obtenerJugador());

        assertTrue(juego.obtenerJugador().verificarMovimiento(6));
    }

    @Test
    public void UnCamionSeMueve4VecesPorLaCiudadYSeEncuentra4VecesConPozoDeveriaSer7Movimientos(){
        Vehiculo camion = new Camioneta(new Ubicacion(1,1), new MovimientoNormal());
        Jugador jugador = new Jugador("Cr", camion);
        Escenario escenario = new Escenario(8, 8);
        Juego juego = new Juego(escenario, jugador);
        Obstaculo pozo = new Pozo();

        for (int i = 0; i < 3; i++) {
            juego.moverVehiculo(new DireccionDerecha());
        }
        juego.moverVehiculo(new DireccionAbajo());

        for(int i=0; i<4; i++){
            pozo.pasarObstaculo((Camioneta) camion, juego.obtenerJugador());
        }

        assertTrue(juego.obtenerJugador().verificarMovimiento(7));
    }

}


/*
Caso de uso 1
Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.
Caso de uso 2
Un vehículo atraviesa la ciudad y encuentra una sorpresa desfavorable.
Caso de uso 3
Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo.
Caso de uso 4
A cargo del equipo.
Caso de uso 5
A cargo del equipo.


 */