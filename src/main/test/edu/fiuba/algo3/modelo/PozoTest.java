package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import edu.fiuba.algo3.modelo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo;



public class PozoTest {
	@Test
	public void pasarObstaculoConAutoJugadorSeLeRestan3movimientos() {
		Pozo pozo = new Pozo();
		Auto auto = new Auto();
		Jugador jugador = new Jugador("pepe", auto);
		
		pozo.pasarObstaculo(auto, jugador);
		assertEquals(jugador.puntaje(), 3);
	}
	
	@Test
	public void pasarObstaculoConMotoJugadorSeLeRestan3movimientos() {
		Pozo pozo = new Pozo();
		Moto moto = new Moto();
		Jugador jugador = new Jugador("pepe", moto);
		
		pozo.pasarObstaculo(moto, jugador);
		assertEquals(jugador.puntaje(), 3);
	}
	
	@Test
	public void pasarObstaculoConCuatroXCuatroJugadorSeLeRestan0movimientos() {
		Pozo pozo = new Pozo();
		CuatroXCuatro camioneta = new CuatroXCuatro();
		Jugador jugador = new Jugador("pepe", camioneta);
		
	    pozo.pasarObstaculo(camioneta, jugador);
		assertEquals(jugador.puntaje(), 0);
	}
}
