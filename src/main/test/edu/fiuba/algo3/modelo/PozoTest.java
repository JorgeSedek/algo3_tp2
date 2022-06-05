package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import edu.fiuba.algo3.modelo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo;



public class PozoTest {
	@Test
	public void pasarObstaculoConAutoDevuelve3movimientos() {
		Pozo pozo = new Pozo();
		Auto auto = new Auto();
		
		int movimientos = pozo.pasarObstaculo(auto);
		assertEquals(3,movimientos);
	}
	
	@Test
	public void pasarObstaculoConMotoDevuelve3movimientos() {
		Pozo pozo = new Pozo();
		Moto moto = new Moto();
		
		int movimientos = pozo.pasarObstaculo(moto);
		assertEquals(3,movimientos);
	}
	
	@Test
	public void pasarObstaculoConCuatroXCuatroDevuelve2movimientos() {
		Pozo pozo = new Pozo();
		CuatroXCuatro camioneta = new CuatroXCuatro();
		
		int movimientos = pozo.pasarObstaculo(camioneta);
		assertEquals(2,movimientos);
	}
}
