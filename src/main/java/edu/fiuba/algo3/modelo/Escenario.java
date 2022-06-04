package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Escenario {
	private int filas;
	private int columnas;
	private HashMap<String, EntreCalle> entreCalles;
	
	public Escenario() {
		this.filas = 4;
		this.columnas = 4;
		this.entreCalles = new HashMap<>();
		this.llenar();

	}
	
	
	
	private String claveEntreCalles(int unaFila, int unaColumna) {
		String claveEntreCalles;
		claveEntreCalles = String.valueOf(unaFila) + String.valueOf(unaColumna);
		return claveEntreCalles;
	}
	
	public EntreCalle entreCalle(String clave) {
		return this.entreCalles.get(clave);
	}
	
	public void colocar(EntreCalle unaEntreCalle, String unaClave) {
		this.entreCalles.put(unaClave, unaEntreCalle);
	}
	
	private void llenar() {
		for(int fila = 1; fila <= filas; fila++) {
			for(int columna = 1; columna <= columnas; columna++) {
				EntreCalle entreCalle = new EntreCalle();
				this.colocar(entreCalle, this.claveEntreCalles(fila, columna));
			}
		}
	}
}