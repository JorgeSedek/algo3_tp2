package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {
    private int totalFilas = 8;
    private int totalColumnas = 8;
    private int fila = 2;
    private int columna = 2;

    @Test
    public void unaDireccionAbajoRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionAbajo = new DireccionAbajo();
        direccionAbajo.mover(ubicacion);
        int nuevaFila = 3;
        Ubicacion ubicacionEsperado = new Ubicacion(nuevaFila, columna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionAbajoRecibeUnUbicacionYLoMuevePeroChocaElBordeDeberiaEstarEnLaMismaUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(16, 16);
        Direccion direccionAbajo = new DireccionAbajo();
        direccionAbajo.mover(ubicacion);
        direccionAbajo.mover(ubicacion);
        Ubicacion ubicacionEsperado = new Ubicacion(16, 16);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionArribaRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionArriba = new DireccionArriba();
        direccionArriba.mover(ubicacion);
        int nuevaFila = 1;
        Ubicacion ubicacionEsperado = new Ubicacion(nuevaFila, columna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionArribaRecibeUnUbicacionYLoMuevePeroChocaElBordeDeberiaEstarEnLaMismaUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionArriba = new DireccionArriba();
        direccionArriba.mover(ubicacion);
        direccionArriba.mover(ubicacion);
        Ubicacion ubicacionEsperado = new Ubicacion(fila, columna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionDerechaRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionDerecha = new DireccionDerecha();
        direccionDerecha.mover(ubicacion);
        int nuevaColumna = 3;
        Ubicacion ubicacionEsperado = new Ubicacion(fila, nuevaColumna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionDerechaoRecibeUnUbicacionYLoMuevePeroChocaElBordeDeberiaEstarEnLaMismaUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(16, 16);
        Direccion direccionDerecha = new DireccionDerecha();
        direccionDerecha.mover(ubicacion);
        direccionDerecha.mover(ubicacion);
        Ubicacion ubicacionEsperado = new Ubicacion(16, 16);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionIzquierdaRecibeUnUbicacionYLoMueveDeberiaEstarEnOtraUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionIzquierda = new DireccionIzquierda();
        direccionIzquierda.mover(ubicacion);
        int nuevaColumna = 1;
        Ubicacion ubicacionEsperado = new Ubicacion(fila, nuevaColumna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
    @Test
    public void unaDireccionIzquierdaRecibeUnUbicacionYLoMuevePeroChocaElBordeDeberiaEstarEnLaMismaUbicacion() {
        Escenario.resetInstance(totalFilas, totalColumnas);
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Direccion direccionIzquierda = new DireccionIzquierda();
        direccionIzquierda.mover(ubicacion);
        direccionIzquierda.mover(ubicacion);
        Ubicacion ubicacionEsperado = new Ubicacion(fila, columna);

        assertTrue(ubicacion.equals(ubicacionEsperado));
    }
}
