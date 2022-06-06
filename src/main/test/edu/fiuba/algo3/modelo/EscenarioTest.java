package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.EntreCalle;

import static org.junit.jupiter.api.Assertions.*;


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
		assertEquals(direccion.asString(),"4-4");
		direccion = new Direccion(5,5);
		assertEquals(direccion.asString(),"5-5");
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
		String clave = "1-1";
		escenario.colocar(entreCalle, clave);
		assertEquals(escenario.entreCalle(clave), entreCalle);
	}
	
	@Test
	public void seLlenaEscenario6x6YEstaOcupadoConObjeto() {
		int unasFilas = 6;
		int unasColumnas = 6;
		Escenario escenario = new Escenario(unasFilas, unasColumnas);
		assertTrue(escenario.estaOcupado("1-1"));
		assertTrue(escenario.estaOcupado("1-6"));
		assertTrue(escenario.estaOcupado("6-6"));
		assertFalse(escenario.estaOcupado("9-9"));
		assertFalse(escenario.estaOcupado("0-0"));
		assertFalse(escenario.estaOcupado("7-7"));
	}

	@Test
	public void seCompartenCallesEntreLasEntreCalles() {
		Escenario escenario = new Escenario(15, 11);

		EntreCalle entrecalle1 = escenario.entreCalle("5-3"); // Fila 5, columna 3
		EntreCalle entrecalle2 = escenario.entreCalle("5-4"); // Fila 5, columna 4

		// La calle de la derecha de la entrecalle 1-1 debería ser la de la izquierda de la 1-2
		assertEquals(entrecalle1.obtenerCalleDerecha(), entrecalle2.obtenerCalleIzquierda());

		assertNotEquals(entrecalle1.obtenerCalleDerecha(), entrecalle2.obtenerCalleInferior());
	}
}