package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Escenario {

	private int filas;
	private int columnas;
	private ArrayList<Casillero> casilleros;

	public Escenario(int unasFilas, int unasColumnas) {
		this.filas = unasFilas;
		this.columnas = unasColumnas;
		this.casilleros = new ArrayList<>();
		this.llenar();
	}
	
	private void llenar() {
		for(int fila = 1; fila <= filas; fila++) {
			for(int columna = 1; columna <= columnas; columna++) {
				this.casilleros.add(new Casillero(fila, columna));

			}
		}
	}

	public void agregarEn(ObjetoUrbano objetoUrbano, Ubicacion ubicacion){
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.contiene(objetoUrbano);
	}

	public Casillero buscarCasilleroEn(Ubicacion ubicacion){
		return ((Casillero) this.casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)));
	}

	public ObjetoUrbano objetoUrbanoEn(Ubicacion ubicacion) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		return casillero.devolverContenido();
	}
}