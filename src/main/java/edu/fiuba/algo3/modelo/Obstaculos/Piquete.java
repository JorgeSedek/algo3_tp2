package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class Piquete implements Obstaculo{
    public void pasarObstaculo(Auto auto, Jugador jugador){
    }
    public void pasarObstaculo(Moto moto, Jugador jugador){
        jugador.incrementarMovimientos(2);
    }
    public void pasarObstaculo(Camioneta camioneta, Jugador jugador){
    }
}
