package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Escenario {
	private int filas;
	private int columnas;
	private HashMap<String, EntreCalle> entreCalles;
	
	public Escenario() {
		this.asignarFilas(4);
		this.asignarColumnas(4);
		this.entreCalles = new HashMap<>();
		this.llenar();

	}
	
	public Escenario(int unasFilas, int unasColumnas) {
		this.asignarFilas(unasFilas);
		this.asignarColumnas(unasColumnas);
		this.entreCalles = new HashMap<>();
		this.llenar();
	}
	
	public void asignarFilas(int unasFilas) {
		this.filas = unasFilas;
	}
	
	public void asignarColumnas(int unasColumnas) {
		this.columnas = unasColumnas;
	}
	
	public int filas() {
		return this.filas;
	}
	
	public int columnas() {
		return this.columnas;
	}
	
	public EntreCalle entreCalle(String clave) {
		return this.entreCalles.get(clave);
	}
	
	public void colocar(EntreCalle unaEntreCalle, String unaClave) {
		this.entreCalles.put(unaClave, unaEntreCalle);
	}
	
	public boolean estaOcupado(String clave) {
		return (this.entreCalles.get(clave) != null);
	}
	
	private void llenar() {
		for(int fila = 1; fila <= filas; fila++) {
			for(int columna = 1; columna <= columnas; columna++) {
				EntreCalle entreCalle = new EntreCalle();
				Direccion direccion = new Direccion(fila,columna);
				this.colocar(entreCalle, direccion.asString());
			}
		}
	}
}