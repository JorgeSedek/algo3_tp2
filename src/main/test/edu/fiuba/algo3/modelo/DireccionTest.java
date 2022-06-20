package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {
    private int fila = 2;
    private int columna = 2;

    @Test
    public void unaDireccionAbajoRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionAbajo = new DireccionAbajo();
        direccionAbajo.mover(ubicacion);
        int nuevaFila = 3;
        Ubicacion ubicacionEsperado = new Ubicacion(nuevaFila, columna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionArribaRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionArriba = new DireccionArriba();
        direccionArriba.mover(ubicacion);
        int nuevaFila = 1;
        Ubicacion ubicacionEsperado = new Ubicacion(nuevaFila, columna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionDerechaRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionDerecha = new DireccionDerecha();
        direccionDerecha.mover(ubicacion);
        int nuevaColumna = 3;
        Ubicacion ubicacionEsperado = new Ubicacion(fila, nuevaColumna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }

    @Test
    public void unaDireccionIzquierdaRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionIzquierda = new DireccionIzquierda();
        direccionIzquierda.mover(ubicacion);
        int nuevaColumna = 1;
        Ubicacion ubicacionEsperado = new Ubicacion(fila, nuevaColumna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
}
