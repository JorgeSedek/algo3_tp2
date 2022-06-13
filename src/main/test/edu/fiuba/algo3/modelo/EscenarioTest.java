package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class EscenarioTest {
	private int filas = 4;
	private int columnas = 4;
	@Test
	public void creoEscenarioConParametrosYNoDeberiaEstarVacio() {
		Escenario escenario = new Escenario(filas, columnas);
		assertNotNull(escenario);
	}
}