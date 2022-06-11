package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {
	@Test
	public void pasarObstaculoConAutoJugadorSeLeRestan3movimientos() {
		Pozo pozo = new Pozo();
		Auto auto = new Auto(new Ubicacion(1,1), new MovimientoNormal());
		Jugador jugador = new Jugador("pepe", auto/*, new Escenario(fila, columna)*/);

		pozo.pasarObstaculo(auto, jugador);
		assertEquals(jugador.movimientos(), 3);
	}
	
	@Test
	public void pasarObstaculoConMotoJugadorSeLeRestan3movimientos() {
		Pozo pozo = new Pozo();
		Moto moto = new Moto(new Ubicacion(1,1), new MovimientoNormal());
		Jugador jugador = new Jugador("pepe", moto/*, new Escenario(fila, columna)*/);

		pozo.pasarObstaculo(moto, jugador);
		assertEquals(jugador.movimientos(), 3);
	}
	
	@Test
	public void pasarObstaculoConCuatroXCuatroJugadorSeLeRestan0movimientos() {
		Pozo pozo = new Pozo();
		Camioneta camioneta = new Camioneta(new Ubicacion(1,1), new MovimientoNormal());
		Jugador jugador = new Jugador("pepe", camioneta/*, new Escenario(fila, columna)*/);

	    pozo.pasarObstaculo(camioneta, jugador);
		assertEquals(jugador.movimientos(), 0);
	}
}
