package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Pozo implements Obstaculo {

	public void pasarObstaculo(Auto auto, Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}
	
	public void pasarObstaculo(Moto moto, Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}

	public void pasarObstaculo(Camioneta camioneta, Jugador jugador) {
		int veces_atravezados = camioneta.sumarVecesPasadosEnPozo();

		if(veces_atravezados > 3) {
			jugador.incrementarMovimientos(3);
		}

	}
}
