package edu.fiuba.algo3.modelo;

public class Policia implements Obstaculo{
    public void pasarObstaculo(Auto auto, Jugador jugador){
        jugador.restarPuntaje(0);
    }
    public void pasarObstaculo(Moto moto, Jugador jugador){
        jugador.restarPuntaje(0);
    }
    public void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador){
        jugador.restarPuntaje(0);
    }
}
