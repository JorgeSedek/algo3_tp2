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
			this.fila++;
	}

	public void mover(DireccionDerecha direccion) {
			this.columna++;
	}

	public void mover(DireccionArriba direccion) {
			this.fila--;
	}

	public void mover(DireccionIzquierda direccion) {
			this.columna--;
	}

	public boolean voyAChocarBorde(DireccionArriba direccionArriba) {
		return Escenario.getInstance().excedeLimites(fila - 1, columna);
	}

	public boolean voyAChocarBorde(DireccionDerecha direccionDerecha) {
		return Escenario.getInstance().excedeLimites(fila, columna + 1);
	}

	public boolean voyAChocarBorde(DireccionAbajo direccionAbajo) {
		return Escenario.getInstance().excedeLimites(fila + 1, columna);
	}

	public boolean voyAChocarBorde(DireccionIzquierda direccionIzquierda) {
		return Escenario.getInstance().excedeLimites(fila, columna - 1);
	}

	public boolean podesTenerMeta() {
		return Escenario.getInstance().correspondeMeta(this.columna);
	}

	public int obtenerFila() {
		return this.fila;
	}

	public int obtenerColumna() {
		return this.columna;
	}
}