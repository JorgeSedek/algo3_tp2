package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public interface Obstaculo {
    void pasarObstaculo(Auto auto, Jugador jugador);
    void pasarObstaculo(Moto moto, Jugador jugador);
    void pasarObstaculo(Camioneta camioneta, Jugador jugador);
}
