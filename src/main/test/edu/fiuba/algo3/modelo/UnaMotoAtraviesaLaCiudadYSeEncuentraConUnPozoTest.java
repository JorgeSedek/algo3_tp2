package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

public class UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoTest {

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozo () {
        String nombre = "Martin";
        Vehiculo vehiculo = new Moto();
        GPS juego = new GPS(nombre, vehiculo);
    }
}
