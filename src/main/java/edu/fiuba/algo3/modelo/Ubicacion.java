package edu.fiuba.algo3.modelo;

public class Ubicacion {
    private int fila;
    private int columna;
    
    public Ubicacion() {
    	this.fila = 1;
    	this.columna = 1;
    }
    
    public Ubicacion(int unaFila, int unaColumna) {
    	this.fila = unaFila;
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


