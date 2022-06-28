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

	// Es una calle si no es un edificio y nos es una entrecalle
	public boolean hayCalle(){
		return !(this.hayEntrecalle() || this.hayEdificio());
	}

	public void mover(DireccionAbajo direccion) {
		Escenario escenario = Escenario.getInstance();
		if (escenario.filaDentroDeLimites(fila)) {
			this.fila += 1;
		}
	}

	public void mover(DireccionDerecha direccion) {
		Escenario escenario = Escenario.getInstance();
		if (escenario.columnaDentroDeLimites(columna)) {
			this.columna += 1;
		}
	}

	public void mover(DireccionArriba direccion) {
		Escenario escenario = Escenario.getInstance();
		if (escenario.filaDentroDeLimites(fila)) {
			this.fila -= 1;
		}
	}

	public void mover(DireccionIzquierda direccion) {
		Escenario escenario = Escenario.getInstance();
		if (escenario.columnaDentroDeLimites(columna)) {
			this.columna -= 1;
		}

	}
	/*
	public Ubicacion copia(){
		return new Ubicacion(this.fila,this.columna);
	}
	*/


}