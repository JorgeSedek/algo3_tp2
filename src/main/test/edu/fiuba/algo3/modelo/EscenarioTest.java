package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.EntreCalle;

public class EscenarioTest {
	@Test
	public void agregoUnEntreCalleYseGuarda() {
		Escenario escenario = new Escenario();
		EntreCalle entreCalle = new EntreCalle();
		String clave = "11";
		escenario.colocar(entreCalle, clave);
		assertEquals(escenario.entreCalle(clave), entreCalle);
	}
	
	@Test
	public void seLlenaEscenarioYhayEntreCallesDentro() {
		Escenario escenario = new Escenario();
		assertEquals(escenario.entreCalle("11").getClass().getName(), "edu.fiuba.algo3.modelo.EntreCalle");
		assertEquals(escenario.entreCalle("12").getClass().getName(), "edu.fiuba.algo3.modelo.EntreCalle");
		assertEquals(escenario.entreCalle("21").getClass().getName(), "edu.fiuba.algo3.modelo.EntreCalle");
		
	}
}