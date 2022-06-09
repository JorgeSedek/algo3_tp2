package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {
    @Test
    public void AutoseMueveEnDistintasDireccionesYdevuelveLaUbicacionCorrecta(){
        Vehiculo vehiculo = new Auto();
        vehiculo.mover(new Derecha());
        Ubicacion ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,2)));

        vehiculo.mover(new Izquierda());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,1)));

        vehiculo.mover(new Abajo());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(2,1)));

        vehiculo.mover(new Arriba());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,1)));

    }

    @Test
    public void MotoseMueveEnDistintasDireccionesYdevuelveLaUbicacionCorrecta(){
        Vehiculo vehiculo = new Moto();
        vehiculo.mover(new Derecha());
        Ubicacion ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,2)));

        vehiculo.mover(new Izquierda());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,1)));

        vehiculo.mover(new Abajo());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(2,1)));

        vehiculo.mover(new Arriba());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,1)));

    }

    @Test
    public void CamionetaseMueveEnDistintasDireccionesYdevuelveLaUbicacionCorrecta(){
        Vehiculo vehiculo = new CuatroXCuatro();
        vehiculo.mover(new Derecha());
        Ubicacion ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,2)));

        vehiculo.mover(new Izquierda());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,1)));

        vehiculo.mover(new Abajo());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(2,1)));

        vehiculo.mover(new Arriba());
        ubicacion = vehiculo.obtenerUbicacion();
        assertTrue(ubicacion.equals(new Ubicacion(1,1)));

    }



}
