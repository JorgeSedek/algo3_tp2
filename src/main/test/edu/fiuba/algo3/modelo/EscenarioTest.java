package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.EntreCalle;


public class EscenarioTest {
	@Test
	public void seCreaUnaDireccionYnoEstaVacia() {
		Direccion direccion = new Direccion();
		assertTrue(direccion != null);
		assertFalse(direccion == null);
	}
	
	@Test
	public void seCreaUnaDireccionConParametrosYnoEstaVacia() {
		Direccion direccion = new Direccion(4,4);
		assertTrue(direccion != null);
		assertFalse(direccion == null);
	}
	
	@Test 
	public void unaDireccionDevuelveSusFilasYcolumnasComoString() {
		Direccion direccion = new Direccion(4,4);
		assertEquals(direccion.asString(),"44");
		direccion = new Direccion(5,5);
		assertEquals(direccion.asString(),"55");
	}
	
	@Test
	public void unaDireccionDevuelveCorrectamenteFilaYColumna() {
		Direccion direccion = new Direccion(7,7);
		assertEquals(direccion.fila(),7);
		assertEquals(direccion.columna(),7);
		direccion = new Direccion(8,8);
		assertEquals(direccion.fila(),8);
		assertEquals(direccion.columna(),8);
	}
	
	@Test
	public void creoEscenarioYnoEstaVacio() {
		Escenario escenario = new Escenario();
		assertTrue(escenario != null);
		assertFalse(escenario == null);
	}
	
	@Test
	public void creoEscenarioConParametrosYnoEstaVacio() {
		int unasFilas = 4;
		int unasColumnas = 4;
		Escenario escenario = new Escenario(unasFilas, unasColumnas);
		assertTrue(escenario != null);
		assertFalse(escenario == null);
	}
	
	@Test
	public void creoEscenarioYtieneFilasYcolumnas() {
		Escenario escenario = new Escenario();
		assertTrue(escenario.filas() > 0);
		assertTrue(escenario.columnas() > 0);
	}
	
	@Test
	public void EscenarioConParametrosAsignaFilasColumnasCorrectas(){
		int unasFilas = 4;
		int unasColumnas = 4;
		Escenario escenario = new Escenario(unasFilas, unasColumnas);
		assertEquals(unasFilas, escenario.filas());
		assertEquals(unasColumnas, escenario.columnas());
		escenario.asignarFilas(6);
		escenario.asignarColumnas(6);
		assertEquals(6, escenario.filas());
		assertEquals(6, escenario.columnas());
	}
	
	@Test
	public void agregoUnEntreCalleYseGuarda() {
		Escenario escenario = new Escenario();
		EntreCalle entreCalle = new EntreCalle();
		String clave = "11";
		escenario.colocar(entreCalle, clave);
		assertEquals(escenario.entreCalle(clave), entreCalle);
	}
	
	@Test
	public void seLlenaEscenario6x6YhayEntreCallesDentro() {
		int unasFilas = 6;
		int unasColumnas = 6;
		Escenario escenario = new Escenario(unasFilas, unasColumnas);
		assertTrue(escenario.estaOcupado("11"));
		assertTrue(escenario.estaOcupado("16"));
		assertTrue(escenario.estaOcupado("66"));
		assertFalse(escenario.estaOcupado("99"));
		assertFalse(escenario.estaOcupado("00"));
		assertFalse(escenario.estaOcupado("77"));
	}
}