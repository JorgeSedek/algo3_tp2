package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Colocador.ColocadorItems;
import edu.fiuba.algo3.modelo.Colocador.ColocadorRandom;
import edu.fiuba.algo3.modelo.Colocador.ColocadorVacio;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Escenario {

	private int filas;
	private int columnas;
	private ColocadorItems colocador;
	private ArrayList<Casillero> casilleros;
	private static Escenario INSTANCE = null;

	private Escenario(int filas, int columnas) {
		this.filas = filas * 2 + 1;
		this.columnas = columnas * 2 + 1;
		this.casilleros = new ArrayList<>();
		this.llenarConCasilleros();
		this.colocador = new ColocadorVacio();
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
	private void llenarConCasilleros() {
		for (int fila = 1; fila <= filas; fila++) {
			for (int columna = 1; columna <= columnas; columna++) {
				Casillero casillero = new Casillero(fila, columna);
				this.casilleros.add(casillero);
			}
		}
	}

	public Casillero buscarCasilleroEn(Ubicacion ubicacion){
		List<Casillero> casillerosFiltrados = casilleros.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)).collect(Collectors.toList());
		return casillerosFiltrados.get(0);
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

	public void agregarSorpresaEn(Ubicacion ubicacion, Sorpresa sorpresa) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.asignarSorpresa(sorpresa);
	}

	// Asigna un colocador random (si se desea crear un escenario de forma random)
	// Para que el colocador asigne de forma aleatoria los obstaculos y sorpresas al escenario
	// hay que llamar luego al metodo "agregarObstaculosYSorpresas"
	public void asignarColocadorRandom() {
		this.colocador = new ColocadorRandom();
	}

	public void agregarMetaEn(Ubicacion ubicacion, Meta meta) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.asignarMeta(meta);
	}

	/*
	// Asigna un colocador pasado por argumento
	public void asignarColocador(ColocadorItems colocador){
		this.colocador = colocador;
	}
	*/

	public int obtenerNumeroDeFilas() {
		return this.filas;
	}

	public int obtenerNumeroDeColumnas() {
		return this.columnas;
	}


	// Al llamar a este metodo, el escenario va a tener sorpresas y obstaculos segun su colocador
	// Por ejemplo, si su colocador es ColocadorRandom, va a tener sorpresas y obstaculos random
	public void agregarObstaculosYSorpresas() {
		colocador.agregarObstaculosYSorpresas(casilleros);
	}

	// Al llamar a este metodo, el escenario va a tener una meta segun su colocador
	// Por ejemplo, si su colocador es ColocadorRandom, va a tener una meta
	// en alguno de los "casilleros calle" de la ultima columna
	public void agregarMeta() {
		colocador.agregarMeta(casilleros);
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