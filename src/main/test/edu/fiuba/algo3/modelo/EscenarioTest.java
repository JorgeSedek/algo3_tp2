package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class EscenarioTest {
	@Test
	public void seCreaUnaDireccionYnoEstaVacia() {
		Ubicacion ubicacion = new Ubicacion();
		assertTrue(ubicacion != null);
	}
	
	@Test
	public void seCreaUnaDireccionConParametrosYnoEstaVacia() {
		Ubicacion ubicacion = new Ubicacion(4,4);
		assertTrue(ubicacion != null);
	}
	
	@Test 
	public void unaDireccionDevuelveSusFilasYcolumnasComoString() {
		Ubicacion ubicacion = new Ubicacion(4,4);
		assertEquals(ubicacion.asString(),"4-4");
		ubicacion = new Ubicacion(5,5);
		assertEquals(ubicacion.asString(),"5-5");
	}
	
	@Test
	public void unaDireccionDevuelveCorrectamenteFilaYColumna() {
		Ubicacion ubicacion = new Ubicacion(7,7);
		assertEquals(ubicacion.fila(),7);
		assertEquals(ubicacion.columna(),7);
		ubicacion = new Ubicacion(8,8);
		assertEquals(ubicacion.fila(),8);
		assertEquals(ubicacion.columna(),8);
	}
	
	@Test
	public void creoEscenarioConParametrosYnoEstaVacio() {
		int unasFilas = 4;
		int unasColumnas = 4;
		Escenario escenario = new Escenario(unasFilas, unasColumnas);
		assertNotNull(escenario);
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
		Escenario escenario = new Escenario(4, 4);
		EntreCalle entreCalle = new EntreCalle(1, 1);
		String clave = "1-1";
		assertEquals(escenario.entreCalle(clave).obtenerDireccionString(), entreCalle.obtenerDireccionString());
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
	public void seCompartenCallesEntreLasEntreCallesAdyacentesDeUnaMismaFila() {
		Escenario escenario = new Escenario(15, 11);

		EntreCalle entrecalle_izq = escenario.entreCalle("5-3"); // Fila 5, columna 3
		EntreCalle entrecalle_der = escenario.entreCalle("5-4"); // Fila 5, columna 4

		// La calle de la derecha de la entrecalle 5-3 debería ser la de la izquierda de la 5-4
		assertEquals(entrecalle_izq.obtenerCalleDerecha(), entrecalle_der.obtenerCalleIzquierda());
		assertNotEquals(entrecalle_izq.obtenerCalleDerecha(), entrecalle_der.obtenerCalleInferior());
	}

	@Test
	public void seCompartenCallesEntreLasEntreCallesAdyacentesDeUnaMismaColumna() {
		Escenario escenario = new Escenario(15, 11);

		EntreCalle entrecalle_sup = escenario.entreCalle("5-2"); // Fila 5, columna 3
		EntreCalle entrecalle_inf = escenario.entreCalle("6-2"); // Fila 5, columna 4

		// La calle inferior de la entrecalle 5-2 debería ser la superior de la de la 6-2
		assertEquals(entrecalle_sup.obtenerCalleInferior(), entrecalle_inf.obtenerCalleSuperior());

		assertNotEquals(entrecalle_sup.obtenerCalleDerecha(), entrecalle_inf.obtenerCalleIzquierda());
	}

	@Test
	public void seCompartenTodasLasCallesEntreLasEntreCallesAdyacentesDeLaPrimerFila() {
		Escenario escenario = new Escenario(15, 11);
		Ubicacion ubicacion_izq = new Ubicacion(1,1);
		Ubicacion ubicacion_der = new Ubicacion(1,2);

		for (int i = 1; i <= 10; i++) {

			EntreCalle entrecalle_izq = escenario.entreCalle(ubicacion_izq.asString());
			EntreCalle entrecalle_der = escenario.entreCalle(ubicacion_der.asString());

			// La calle de la derecha de la entrecalle1 1-i debería ser la de la izquierda de la 1-(i+1)
			assertEquals(entrecalle_izq.obtenerCalleDerecha(), entrecalle_der.obtenerCalleIzquierda());

			ubicacion_izq.incrementarColumna();
			ubicacion_der.incrementarColumna();
		}
	}

	@Test
	public void seCompartenTodasLasCallesEntreLasEntreCallesAdyacentesDeLaUltimaFila() {
		Escenario escenario = new Escenario(15, 11);
		Ubicacion ubicacion_izq = new Ubicacion(15,1);
		Ubicacion ubicacion_der = new Ubicacion(15,2);

		for (int i = 1; i <= 10; i++) {

			EntreCalle entrecalle_izq = escenario.entreCalle(ubicacion_izq.asString());
			EntreCalle entrecalle_der = escenario.entreCalle(ubicacion_der.asString());

			// La calle de la derecha de la entrecalle1 15-i debería ser la de la izquierda de la 15-(i+1)
			assertEquals(entrecalle_izq.obtenerCalleDerecha(), entrecalle_der.obtenerCalleIzquierda());

			ubicacion_izq.incrementarColumna();
			ubicacion_der.incrementarColumna();
		}
	}

	@Test
	public void seCompartenTodasLasCallesEntreLasEntreCallesAdyacentesDeLaPrimerColumna() {
		Escenario escenario = new Escenario(15, 11);
		Ubicacion ubicacion_sup = new Ubicacion(1,1);
		Ubicacion ubicacion_inf = new Ubicacion(2,1);

		for (int i = 1; i <= 14; i++) {

			EntreCalle entrecalle_sup = escenario.entreCalle(ubicacion_sup.asString());
			EntreCalle entrecalle_inf = escenario.entreCalle(ubicacion_inf.asString());

			// La calle de superior de la entrecalle1 i-1 debería ser la de la izquierda de la (i+1)-1
			assertEquals(entrecalle_sup.obtenerCalleInferior(), entrecalle_inf.obtenerCalleSuperior());

			ubicacion_sup.incrementarFila();
			ubicacion_inf.incrementarFila();
		}
	}

	@Test
	public void seCompartenTodasLasCallesEntreLasEntreCallesAdyacentesDeLaUltimaColumna() {
		Escenario escenario = new Escenario(15, 11);
		Ubicacion ubicacion_sup = new Ubicacion(1,11);
		Ubicacion ubicacion_inf = new Ubicacion(2,11);

		for (int i = 1; i <= 14; i++) {

			EntreCalle entrecalle_sup = escenario.entreCalle(ubicacion_sup.asString());
			EntreCalle entrecalle_inf = escenario.entreCalle(ubicacion_inf.asString());

			// La calle de superior de la entrecalle1 i-11 debería ser la de la izquierda de la (i+1)-11
			assertEquals(entrecalle_sup.obtenerCalleInferior(), entrecalle_inf.obtenerCalleSuperior());

			ubicacion_sup.incrementarFila();
			ubicacion_inf.incrementarFila();
		}
	}

	@Test
	public void seVerificaQueCiertasCallesTenganEntreCallesAdyacentes(){
		Escenario escenario = new Escenario(15, 15);
		Calle calle1 = escenario.entreCalle("1-1").obtenerCalleDerecha();
		Calle calle2 = escenario.entreCalle("1-2").obtenerCalleIzquierda();
		assertEquals(calle1, calle2);

		Calle calle3 = escenario.entreCalle("1-1").obtenerCalleInferior();
		Calle calle4 = escenario.entreCalle("2-1").obtenerCalleSuperior();
		assertEquals(calle3, calle4);
	}


}