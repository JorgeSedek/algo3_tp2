package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PiqueteTest {
    private String nombre = "Pablo";
    private int fila = 1;
    private int columna = 1;

    @Test
    public void unJugadorPasaPorUnPiqueteConMotoDeberiaSumarse2MovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo moto = new Moto(casillero);
        Jugador jugador = new Jugador(nombre, moto);
        int cantidadMovimientos = 2;

        moto.recibe(piquete);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConAutoNoDeberiaSumarseMovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo auto = new Auto(casillero);
        Jugador jugador = new Jugador(nombre, auto);
        int cantidadMovimientos = 0;

        auto.recibe(piquete);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConCamionetaNoDeberiaSumarseMovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Casillero casillero = new Casillero(fila, columna);
        Vehiculo camioneta = new Camioneta(casillero);
        Jugador jugador = new Jugador(nombre, camioneta);
        int cantidadMovimientos = 0;

        camioneta.recibe(piquete);

        assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
    }
}
