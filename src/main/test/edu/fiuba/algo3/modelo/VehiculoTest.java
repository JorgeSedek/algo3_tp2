package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void seActualizoLaUbicacionDelVehiculo () {
        EntreCalle una_entrecalle = new EntreCalle();
        EntreCalle otra_entreCalle = new EntreCalle();
        Moto moto = new Moto();

        moto.nuevaUbicacion(una_entrecalle);
        assertEquals(moto.obtenerUbicacion(), una_entrecalle);
        assertNotEquals(moto.obtenerUbicacion(), otra_entreCalle);
    }
}
