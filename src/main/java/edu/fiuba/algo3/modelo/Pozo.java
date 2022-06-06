package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {
	public void pasarObstaculo(Auto auto, Jugador jugador) {
		jugador.restarPuntaje(3);
	}
	
	public void pasarObstaculo(Moto moto, Jugador jugador) {
		jugador.restarPuntaje(3);
	}

	public void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador) {
		jugador.restarPuntaje(0);
	}
}
