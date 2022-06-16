package edu.fiuba.algo3.modelo.General;

import java.util.ArrayList;

public class Escenario {

	private int filas;
	private int columnas;
	private ArrayList<Casillero> casilleros;

	public Escenario(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.casilleros = new ArrayList<>();
		this.llenar();
	}

	// Completa el escenario con casilleros
	private void llenar() {
		for (int fila = 1; fila <= filas; fila++) {
			for (int columna = 1; columna <= columnas; columna++) {
				this.casilleros.add(new Casillero(new Ubicacion(fila, columna)));
			}
		}
	}

	/*
	DE MOMENTO NO SE UTILIZAN (de hecho quedarían obsoletos estos metodos respecto a la implementación
	actual ya que ahora un casillero es un cruce de calles, y no una calle). Se podría refactorizar
	para que a partir de una calle de un casillero haga lo pedido.

	public void agregarEn(ObjetoUrbano objetoUrbano, Ubicacion ubicacion){
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.contiene(objetoUrbano);
	}

	public Casillero buscarCasilleroEn(Ubicacion ubicacion){
		return ((Casillero) this.casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)));
	}
	*/
}