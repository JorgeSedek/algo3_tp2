package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Escenario {
	private int filas;
	private int columnas;
	private final HashMap<String, EntreCalle> entreCalles;
	
	public Escenario() {
		this.asignarFilas(4);
		this.asignarColumnas(4);
		this.entreCalles = new HashMap<>();
		this.llenar();
		this.actualizarFilas();

	}
	
	public Escenario(int unasFilas, int unasColumnas) {
		this.asignarFilas(unasFilas);
		this.asignarColumnas(unasColumnas);
		this.entreCalles = new HashMap<>();
		this.llenar();
		this.actualizarFilas();
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
				entreCalle.llenarCalles();
				Direccion direccion = new Direccion(fila,columna);
				this.colocar(entreCalle, direccion.asString());
			}
		}
	}


	private void actualizarFilas () {
		/*
		Actualiza las filas del escenario, de forma tal que se comparten las calles entre las entrecalles
		correspondientes, dentro de una misma fila (ej: La calle de la derecha de la
		entrecalle 1-1, es la calle de la izquierda de la entrecalle 1-2)
		 */
		for(int fila = 1; fila <= filas; fila++) {
			for (int columna = 2; columna <= columnas; columna++) {
				EntreCalle entrecalleact = this.entreCalle(String.valueOf(fila) + String.valueOf(columna));
				EntreCalle entrecalleant = this.entreCalle(String.valueOf(fila) + String.valueOf(columna - 1));
				Calle calle = entrecalleant.obtenerCalleDerecha();

				entrecalleact.asignarCalleIzquierda(calle);
			}
		}
	}

}