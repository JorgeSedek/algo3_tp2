package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class EscenarioTest {
	private int filas = 4;
	private int columnas = 4;
	@Test
	public void escenarioEsElMismo() {
		assertEquals(Escenario.getInstance(), Escenario.getInstance());
	}

	@Test
    public void alResetearEscenarioYaNoEsElMismo() {
        assertNotEquals(Escenario.getInstance(), Escenario.resetInstance(filas, columnas));
    }

	@Test
	public void elEscenarioSeReseteoCorrectamente() {
		int filasIniciales = 8;
		int columnasIniciales = 8;
		assertTrue(Escenario.getInstance().verificarNumeroDeFilas(filasIniciales));
		assertTrue(Escenario.getInstance().verificarNumeroDeColumnas(columnasIniciales));

		Escenario.resetInstance(filas, columnas);
		assertTrue(Escenario.getInstance().verificarNumeroDeFilas(filas));
		assertTrue(Escenario.getInstance().verificarNumeroDeColumnas(columnas));
	}
}
