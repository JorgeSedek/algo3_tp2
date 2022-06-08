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
		this.actualizarColumnas();
	}
	
	public Escenario(int unasFilas, int unasColumnas) {
		this.asignarFilas(unasFilas);
		this.asignarColumnas(unasColumnas);
		this.entreCalles = new HashMap<>();
		this.llenar();
		this.actualizarFilas();
		this.actualizarColumnas();
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
				entreCalle.asignaDireccion(direccion);
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
				Direccion direccionder = new Direccion(fila, columna);
				Direccion direccionizq = new Direccion(fila, columna - 1);

				EntreCalle entrecalleder = this.entreCalle(direccionder.asString());
				EntreCalle entrecalleizq = this.entreCalle(direccionizq.asString());

				Calle calle = entrecalleizq.obtenerCalleDerecha();

				calle.asignarEntreCalles(entrecalleizq, entrecalleder);
				entrecalleder.asignarCalleIzquierda(calle);


			}
		}
	}

	private void actualizarColumnas () {
		/*
		Actualiza las columnas del escenario, de forma tal que se comparten las calles entre las entrecalles
		correspondientes, dentro de una misma columna (ej: La calle inferior de la
		entrecalle 1-1, es la calle superior de la entrecalle 2-1)
		 */
		for(int fila = 2; fila <= filas; fila++) {
			for (int columna = 1; columna <= columnas; columna++) {
				Direccion direccioninf = new Direccion(fila, columna);
				Direccion direccionsup = new Direccion(fila - 1, columna);

				EntreCalle entrecalleinf = this.entreCalle(direccioninf.asString());
				EntreCalle entrecallesup = this.entreCalle(direccionsup.asString());

				Calle calle = entrecallesup.obtenerCalleInferior();

				calle.asignarEntreCalles(entrecallesup, entrecalleinf);
				entrecalleinf.asignarCalleSuperior(calle);


			}
		}
	}

}