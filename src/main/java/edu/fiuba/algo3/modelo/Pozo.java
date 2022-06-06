package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {
	public void pasarObstaculo(Auto auto, Jugador jugador) {
		jugador.restarPuntaje(3);
	}
	
	public void pasarObstaculo(Moto moto, Jugador jugador) {
		jugador.restarPuntaje(3);
	}

	public void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador) {
		int veces_atravezados = camioneta.sumar_veces_pasados_en_pozo();

		if(veces_atravezados < 3) {
			jugador.restarPuntaje(2);
		}else {
			jugador.restarPuntaje(3);
		}

	}
}
