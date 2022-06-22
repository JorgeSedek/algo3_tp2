package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Escenario {

	private int filas;
	private int columnas;

	private ArrayList<Casillero> casilleros;

	private static Escenario INSTANCE = null;

	//private ArrayList<Calle> calle;

	private Escenario(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.casilleros = new ArrayList<>();
		this.llenar();
	}

	private synchronized static void createInstance(int filas, int columnas) {
		INSTANCE = new Escenario(filas, columnas);
	}

	public static Escenario getInstance() {
		if (INSTANCE == null) {
			int filas = 8;
			int columnas = 8;
			createInstance(filas, columnas);
		}
		return INSTANCE;
	}

	// Resetea el escenario a un estado inicial (con una cantidad de filas y columnas)
	public static void resetInstance(int filas, int columnas) {
		createInstance(filas, columnas);
	}

	// Completa el escenario con casilleros
	private void llenar() {
		for (int fila = 1; fila <= filas; fila++) {
			for (int columna = 1; columna <= columnas; columna++) {
				Casillero casillero = new Casillero(fila, columna);
			//	casillero.cargarCasillerosAdyacentes();
				this.casilleros.add(casillero);
			}
		}
	}

	/*
	DE MOMENTO NO SE UTILIZAN (de hecho quedarían obsoletos estos metodos respecto a la implementación
	actual ya que ahora un casillero es un cruce de calles, y no una calle). Se podría refactorizar
	para que a partir de una calle de un casillero haga lo pedido.

	private void llenarCalles(int indiceCasillero){
		if (indiceCasillero < columnas) {
			Casillero primerCasillero = casilleros.get(indiceCasillero);
			Casillero segundoCasillero = casilleros.get(indiceCasillero + 1);
			Calle calle = new Calle();
			int siguienteIndice = indiceCasillero + 1;
			this.llenarCalles(siguienteIndice);
		}
	}

	public void agregarVehiculoEnCasillero(Vehiculo vehiculo, Ubicacion ubicacion){
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.colocar(vehiculo);
	}
	*/


	public Casillero buscarCasilleroEn(Ubicacion ubicacion){
		List<Casillero> casillerosFiltrados = casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)).collect(Collectors.toList());
		int primerElemento = 0;
		return casillerosFiltrados.get(primerElemento);
	}

	public boolean filaDentroDeLimites(int fila){
		return (fila >= 1 & fila <= filas);
	}

	public boolean columnaDentroDeLimites(int columna){
		return (columna >= 1 & columna <= columnas);
	}

	public void agregarObstaculoEn(Ubicacion ubicacion, Obstaculo obstaculo) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.asignarObstaculo(obstaculo);
	}

	// Metodo para tests
	public boolean verificarNumeroDeFilas(int filas) {
		return this.filas == filas;
	}

	// Metodo para tests
	public boolean verificarNumeroDeColumnas(int columnas) {
		return this.columnas == columnas;
	}
}