package edu.fiuba.algo3.modelo;

public interface Obstaculo {
    void pasarObstaculo(Auto auto, Jugador jugador);
    void pasarObstaculo(Moto moto, Jugador jugador);
    void pasarObstaculo(CuatroXCuatro camioneta, Jugador jugador);
}
