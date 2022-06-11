package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PozoTest {
	@Test
	public void pasarObstaculoConAutoJugadorSeLeRestan3movimientos() {
		Pozo pozo = new Pozo();
		Auto auto = new Auto();
		int fila = 4;
		int columna = 4;
		Jugador jugador = new Jugador("pepe", auto, new Escenario(fila, columna));
		
		pozo.pasarObstaculo(auto, jugador);
		assertEquals(jugador.movimientos(), 3);
	}
	
	@Test
	public void pasarObstaculoConMotoJugadorSeLeRestan3movimientos() {
		Pozo pozo = new Pozo();
		Moto moto = new Moto();
		int fila = 4;
		int columna = 4;
		Jugador jugador = new Jugador("pepe", moto, new Escenario(fila, columna));
		
		pozo.pasarObstaculo(moto, jugador);
		assertEquals(jugador.movimientos(), 3);
	}
	
	@Test
	public void pasarObstaculoConCuatroXCuatroJugadorSeLeRestan0movimientos() {
		Pozo pozo = new Pozo();
		CuatroXCuatro camioneta = new CuatroXCuatro();
		int fila = 4;
		int columna = 4;
		Jugador jugador = new Jugador("pepe", camioneta, new Escenario(fila,columna));
		
	    pozo.pasarObstaculo(camioneta, jugador);
		assertEquals(jugador.movimientos(), 0);
	}
}
