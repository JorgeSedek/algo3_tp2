package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {
	public void pasarObstaculo(Auto auto, Jugador jugador) {
		jugador.aumentarPuntaje(3);
	}
	
	public void pasarObstaculo(Moto moto, Jugador jugador) {
		jugador.aumentarPuntaje(3);
	}

	public void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador) {
		int veces_atravezados = camioneta.sumar_veces_pasados_en_pozo();

		if(veces_atravezados == 3) {
			jugador.aumentarPuntaje(3);
		}

	}
}
