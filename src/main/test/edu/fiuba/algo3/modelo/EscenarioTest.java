package edu.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.Escenario;
import edu.fiuba.algo3.EntreCalle;

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
		assertEquals(escenario.entreCalle("11").getClass().getName(), "edu.fiuba.algo3.EntreCalle");
		assertEquals(escenario.entreCalle("12").getClass().getName(), "edu.fiuba.algo3.EntreCalle");
		assertEquals(escenario.entreCalle("21").getClass().getName(), "edu.fiuba.algo3.EntreCalle");
		
	}
}