package edu.fiuba.algo3.modelo;

public class Direccion {
    private int fila;
    private int columna;
    
    public Direccion() {
    	this.asignarFila(1);
    	this.asignarColumna(1);
    }
    
    public Direccion(int unaFila, int unaColumna) {
    	this.asignarFila(unaFila);
    	this.asignarColumna(unaColumna);
    }
    
	public void asignarFila(int unaFila) {
		this.fila = unaFila;
	}
	
	public void asignarColumna(int unaColumna) {
		this.columna = unaColumna;
	}
	
	public int fila() {
		return this.fila;
	}
	
	public int columna() {
		return this.columna;
	}
	
	public void incrementarFila () {
		this.fila += 1;
	}
	public void incrementarColumna () {
		this.columna += 1;
	}

	public void disminuirFila () {
		this.fila -= 1;
	}

	public void disminuirColumna () {
		this.columna -= 1;
	}



	public String asString() {
			
		return (String.valueOf(this.fila) + "-" + String.valueOf(this.columna));
			
		}
	}


