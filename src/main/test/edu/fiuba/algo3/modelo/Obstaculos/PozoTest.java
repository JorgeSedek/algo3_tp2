package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PozoTest {
	private String nombre = "Pablo";
	private int fila = 1;
	private int columna = 1;

	@Test
	public void unJugadorPasaPorUnPozoConAutoDeberiaSumarse3MovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Casillero casillero = new Casillero(new Ubicacion(fila, columna));
		Vehiculo auto = new Auto(casillero);
		Jugador jugador = new Jugador(nombre, auto);
		int cantidadMovimientos = 3;

		auto.recibe(pozo);

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}
	
	@Test
	public void unJugadorPasaPorUnPozoConMotoDeberiaSumarse3MovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Casillero casillero = new Casillero(new Ubicacion(fila, columna));
		Vehiculo moto = new Moto(casillero);
		Jugador jugador = new Jugador(nombre, moto);
		int cantidadMovimientos = 3;

		moto.recibe(pozo);

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}
	
	@Test
	public void unJugadorPasaPorUnPozoConCamionetaNoDeberiaSumarseMovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Casillero casillero = new Casillero(new Ubicacion(fila, columna));
		Vehiculo camioneta = new Camioneta(casillero);
		Jugador jugador = new Jugador(nombre, camioneta);
		int cantidadMovimientos = 0;

		camioneta.recibe(pozo);

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}

	@Test
	public void unJugadorPasaPorUnPozo4VecesConCamionetaDeberiaSumarse3MovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Casillero casillero = new Casillero(new Ubicacion(fila, columna));
		Vehiculo camioneta = new Camioneta(casillero);
		Jugador jugador = new Jugador(nombre, camioneta);
		int cantidadMovimientos = 3;

		for(int i = 1; i <= 4; i++) {
			camioneta.recibe(pozo);
		}
		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}
}