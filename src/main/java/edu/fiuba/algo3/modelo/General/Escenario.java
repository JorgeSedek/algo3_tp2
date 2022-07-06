package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Colocador.ColocadorItems;
import edu.fiuba.algo3.modelo.Colocador.ColocadorRandom;
import edu.fiuba.algo3.modelo.Math.Random;
import edu.fiuba.algo3.modelo.Meta.Meta;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Escenario {
	private final int FILAS;
	private final int COLUMNAS;
	private final ArrayList<Casillero> CASILLEROS;
	private static Escenario INSTANCE = null;

	private Escenario(int filas, int columnas) {
		// Se multiplica por 2 y se suma 1 para que dados cualquier
		// fila y columna se cree un escenario identico al pedido
		this.FILAS = filas * 2 + 1;
		this.COLUMNAS = columnas * 2 + 1;
		this.CASILLEROS = new ArrayList<>();
		this.llenarConCasilleros();
	}

	private synchronized static void createInstance(int filas, int columnas) {
		INSTANCE = new Escenario(filas, columnas);
	}

	public static Escenario getInstance() {
		if(INSTANCE == null) {
			createInstance(8, 8);
		}
		return INSTANCE;
	}

	public static void resetInstance(int filas, int columnas) {
		createInstance(filas, columnas);
	}

	private void llenarConCasilleros() {
		for (int fila = 1; fila <= FILAS; fila++) {
			for (int columna = 1; columna <= COLUMNAS; columna++) {
				Casillero casillero = new Casillero(fila, columna);
				this.CASILLEROS.add(casillero);
			}
		}
	}

	public Casillero buscarCasilleroEn(Ubicacion ubicacion){
		List<Casillero> casillerosFiltrados = CASILLEROS.stream().filter(casilleroBuscado -> casilleroBuscado.equals(ubicacion)).collect(Collectors.toList());
		return casillerosFiltrados.get(0);
	}

	public boolean excedeLimites(int fila, int columna) {
		return ((fila < 1 || fila  > FILAS) || (columna < 1 || columna > COLUMNAS));
	}

	public boolean esBorde(int fila, int columna) {
		return ((fila == 1 || fila == FILAS) || (columna == 1 || columna == COLUMNAS));
	}

	public void agregarObstaculoEn(Ubicacion ubicacion, Obstaculo obstaculo) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.asignarObstaculo(obstaculo);
	}

	public void agregarSorpresaEn(Ubicacion ubicacion, Sorpresa sorpresa) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.asignarSorpresa(sorpresa);
	}

	public void agregarMetaEn(Ubicacion ubicacion, Meta meta) {
		Casillero casillero = this.buscarCasilleroEn(ubicacion);
		casillero.asignarMeta(meta);
	}

	public boolean correspondeMeta(int columna) {
		return this.COLUMNAS == columna;
	}

	public void agregarObjetosRandom() {
		ColocadorItems colocador = new ColocadorRandom(new Random());
		colocador.agregarObjetosAEscenario(CASILLEROS);
	}

	// Metodo util para la interfaz
	public int obtenerFilas() {
		return this.FILAS;
	}

	// Metodo util para la interfaz
	public int obtenerColumnas() {
		return this.COLUMNAS;
	}


	// Metodos para tests
	public boolean verificarNumeroDeFilas(int filas) {
		return this.FILAS == filas;
	}

	public boolean verificarNumeroDeColumnas(int columnas) {
		return this.COLUMNAS == columnas;
	}

}