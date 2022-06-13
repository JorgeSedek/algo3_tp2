package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
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
		Ubicacion ubicacion = new Ubicacion(fila, columna);
		Vehiculo auto = new Auto(ubicacion);
		Jugador jugador = new Jugador(nombre, auto);
		int cantidadMovimientos = 3;

		pozo.pasarObstaculo((Auto) auto, jugador);

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}
	
	@Test
	public void unJugadorPasaPorUnPozoConMotoDeberiaSumarse3MovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Ubicacion ubicacion = new Ubicacion(fila, columna);
		Vehiculo moto = new Moto(ubicacion);
		Jugador jugador = new Jugador(nombre, moto);
		int cantidadMovimientos = 3;

		pozo.pasarObstaculo((Moto) moto, jugador);

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}
	
	@Test
	public void unJugadorPasaPorUnPozoConCamionetaNoDeberiaSumarseMovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Ubicacion ubicacion = new Ubicacion(fila, columna);
		Vehiculo camioneta = new Camioneta(ubicacion);
		Jugador jugador = new Jugador(nombre, camioneta);
		int cantidadMovimientos = 0;

		pozo.pasarObstaculo((Camioneta) camioneta, jugador);

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}

	@Test
	public void unJugadorPasaPorUnPozo4VecesConCamionetaDeberiaSumarse3MovimientosAJugador() {
		Obstaculo pozo = new Pozo();
		Ubicacion ubicacion = new Ubicacion(fila, columna);
		Vehiculo camioneta = new Camioneta(ubicacion);
		Jugador jugador = new Jugador(nombre, camioneta);
		int cantidadMovimientos = 3;

		for(int i = 1; i <= 4; i++) {
			pozo.pasarObstaculo((Camioneta) camioneta, jugador);
		}

		assertTrue(jugador.verificarMovimiento(cantidadMovimientos));
	}
}