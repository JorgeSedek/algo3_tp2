package edu.fiuba.algo3.modelo.General;

public class Casillero {
    private int fila;
    private int columna;

    public Casillero(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public boolean equals(Casillero casillero) {
        return (casillero.fila == this.fila & casillero.columna == this.columna);
    }

    public void incrementarFila() {
        this.fila += 1;
    }

    public void incrementarColumna() {
        this.columna += 1;
    }

    public void disminuirFila() {
        this.fila -= 1;
    }

    public void disminuirColumna() {
        this.columna -= 1;
    }

}
