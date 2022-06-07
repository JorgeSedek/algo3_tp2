package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {
	public void pasarObstaculo(Auto auto, Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}
	
	public void pasarObstaculo(Moto moto, Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}

	public void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador) {
		int veces_atravezados = camioneta.sumarVecesPasadosEnPozo();

		if(veces_atravezados > 3) {
			jugador.incrementarMovimientos(3);
		}

	}
}
