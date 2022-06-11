package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {
    @Test
    public void UbicacionSeComparaCorrectamenteConOtraUbicacion(){
        Ubicacion ubicacion = new Ubicacion(2,3);
        assertTrue(ubicacion.equals(new Ubicacion(2,3)));
        assertFalse(ubicacion.equals(new Ubicacion(4,3)));
        assertFalse(ubicacion.equals(new Ubicacion(2,5)));
    }
    @Test
    public void AutoSeMueveEnDistintasDireccionesYDevuelveLaUbicacionCorrecta(){
        Vehiculo vehiculo = new Auto(new Ubicacion(1,1), new MovimientoNormal());

        vehiculo.mover(new DireccionDerecha());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,2)));

        vehiculo.mover(new DireccionIzquierda());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,1)));

        vehiculo.mover(new DireccionAbajo());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(2,1)));

        vehiculo.mover(new DireccionArriba());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,1)));
    }

    @Test
    public void MotoSeMueveEnDistintasDireccionesYDevuelveLaUbicacionCorrecta(){
        Vehiculo vehiculo = new Moto(new Ubicacion(1,1), new MovimientoNormal());

        vehiculo.mover(new DireccionDerecha());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,2)));

        vehiculo.mover(new DireccionIzquierda());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,1)));

        vehiculo.mover(new DireccionAbajo());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(2,1)));

        vehiculo.mover(new DireccionArriba());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,1)));
    }

    @Test
    public void CamionetaSeMueveEnDistintasDireccionesYDevuelveLaUbicacionCorrecta(){
        Vehiculo vehiculo = new Camioneta(new Ubicacion(1,1), new MovimientoNormal());

        vehiculo.mover(new DireccionDerecha());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,2)));

        vehiculo.mover(new DireccionIzquierda());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,1)));

        vehiculo.mover(new DireccionAbajo());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(2,1)));

        vehiculo.mover(new DireccionArriba());
        assertTrue(vehiculo.obtenerUbicacion().equals(new Ubicacion(1,1)));
    }
}
