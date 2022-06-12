package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class EscenarioTest {
	@Test
	public void seCreaUnaUbicacionYnoEstaVacia() {
		int fila = 1;
		int columna = 1;
		Ubicacion ubicacion = new Ubicacion(fila, columna);
		assertTrue(ubicacion.noEstaVacia());
	}

	@Test
	public void unaUbicacionDevuelveCorrectamenteFilaYColumna() {
		int fila = 7;
		int columna = 7;

		Ubicacion ubicacion = new Ubicacion(fila, columna);
		assertEquals(ubicacion.fila(), fila);
		assertEquals(ubicacion.columna(), columna);

		fila = 8;
		columna = 8;
		ubicacion = new Ubicacion(fila, columna);
		assertEquals(ubicacion.fila(), fila);
		assertEquals(ubicacion.columna(), columna);
	}

	@Test
	public void SeComparaDosUbicacionesParaVerSiSonIguales(){
		int fila = 1;
		int columna = 1;

		Ubicacion primeraUbicacion = new Ubicacion(fila, columna);
		Ubicacion segundaUbicacion = new Ubicacion(fila, columna);
		assertTrue(primeraUbicacion.equals(segundaUbicacion));
		assertTrue(segundaUbicacion.equals(primeraUbicacion));

		int filaDistinta = 2;
		int columnaDistinta = 2;
		Ubicacion ubicacionDistinta = new Ubicacion(filaDistinta, columnaDistinta);
		assertFalse(primeraUbicacion.equals(ubicacionDistinta));
		assertFalse(ubicacionDistinta.equals(primeraUbicacion));
	}
	
	@Test
	public void creoEscenarioConParametrosYnoEstaVacio() {
		int unasFilas = 4;
		int unasColumnas = 4;
		Escenario escenario = new Escenario(unasFilas, unasColumnas);
		assertNotNull(escenario);
	}
	


	





}