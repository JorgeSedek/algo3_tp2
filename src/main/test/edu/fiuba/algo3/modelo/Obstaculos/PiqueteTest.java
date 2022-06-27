package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
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
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo moto = new Moto(ubicacion);
        Jugador jugador = new Jugador(nombre, moto);
        Efecto efecto = new EfectoGeneral();

        efecto = moto.atravesar(piquete, efecto);
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
        Efecto efecto = new EfectoGeneral();

        efecto = auto.atravesar(piquete, efecto);
        efecto.aplicar(jugador);

        int cantidadMovimientos = 0;

        assertTrue(jugador.verificarMovimientos(cantidadMovimientos));
    }

    @Test
    public void unJugadorPasaPorUnPiqueteConCamionetaNoDeberiaSumarseMovimientosAJugador() {
        Obstaculo piquete = new Piquete();
        Ubicacion ubicacion = (new Ubicacion(fila, columna));
        Vehiculo camioneta = new Camioneta(ubicacion);
        Jugador jugador = new Jugador(nombre, camioneta);
        Efecto efecto = new EfectoGeneral();

        efecto = camioneta.atravesar(piquete, efecto);
        efecto.aplicar(jugador);

        int cantidadMovimientos = 0;

        assertTrue(jugador.verificarMovimientos(cantidadMovimientos));
    }
}
