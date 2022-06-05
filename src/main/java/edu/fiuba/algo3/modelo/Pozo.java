package edu.fiuba.algo3.modelo;

public class Pozo {
	public void pasarObstaculo(Auto unAuto, Jugador jugador) {
		jugador.restarPuntaje(3);
	}
	
	public void pasarObstaculo(Moto unaMoto, Jugador jugador) {
		jugador.restarPuntaje(3);
	}
	
	public void pasarObstaculo(CuatroXCuatro unaCamioneta, Jugador jugador) {
		jugador.restarPuntaje(0);
	}
}
