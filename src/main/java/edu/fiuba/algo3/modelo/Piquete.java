package edu.fiuba.algo3.modelo;

public class Piquete implements Obstaculo{
    public void pasarObstaculo(Auto auto, Jugador jugador){
    }
    public void pasarObstaculo(Moto moto, Jugador jugador){
        jugador.incrementarMovimientos(2);
    }
    public void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador){
    }
}
