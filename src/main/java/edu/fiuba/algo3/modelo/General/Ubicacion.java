package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.*;

public class Ubicacion {
	private int fila;
	private int columna;

	public Ubicacion(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public boolean equals(Ubicacion ubicacion) {
		return (ubicacion.fila == this.fila & ubicacion.columna == this.columna);
	}

	// Es una EntreCalle si su fila y su columna es par
	public boolean hayEntrecalle(){
		return (this.fila % 2 == 0 & this.columna % 2 == 0);
	}


	// Es un edificio si su fila y su columna es impar
	public boolean hayEdificio() {
		return (this.fila % 2 == 1 & this.columna % 2 == 1);
	}

	// Es una calle si no es un edificio y no es una entrecalle
	public boolean hayCalle(){
		return !(this.hayEntrecalle() || this.hayEdificio());
	}

	public void mover(DireccionAbajo direccion) {
			this.fila += 1;
	}

	public void mover(DireccionDerecha direccion) {
			this.columna += 1;
	}

	public void mover(DireccionArriba direccion) {
			this.fila -= 1;
	}

	public void mover(DireccionIzquierda direccion) {
			this.columna -= 1;
	}

	public boolean voyAChocarBorde(DireccionArriba direccionArriba) {
		Escenario escenario = Escenario.getInstance();
		return !escenario.filaDentroDeLimites(fila - 1);
	}

	public boolean voyAChocarBorde(DireccionDerecha direccionDerecha) {
		Escenario escenario = Escenario.getInstance();
		return !escenario.columnaDentroDeLimites(columna + 1);
	}

	public boolean voyAChocarBorde(DireccionAbajo direccionAbajo) {
		Escenario escenario = Escenario.getInstance();
		return !escenario.filaDentroDeLimites(fila + 1);
	}

	public boolean voyAChocarBorde(DireccionIzquierda direccionIzquierda) {
		Escenario escenario = Escenario.getInstance();
		return !escenario.columnaDentroDeLimites(columna - 1);
	}

	/*
	public int obtenerFila() {
		return this.fila;
	}
	*/
	public int obtenerColumna() {
		return this.columna;
	}



}