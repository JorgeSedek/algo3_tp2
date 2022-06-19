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

	public boolean hayEdificio(){
		return (this.fila % 2 == 0 & this.columna % 2 == 0);
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

	public void  mover(DireccionIzquierda direccion) {
		this.columna -= 1;
	}


}