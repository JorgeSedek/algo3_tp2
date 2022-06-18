package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.*;
import edu.fiuba.algo3.modelo.General.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {
    private int fila = 2;
    private int columna = 2;

    @Test
    public void unaDireccionAbajoRecibeUnCasilleroYLoMueveDeberiaEstarEnOtraUbicacion() {
        Casillero casillero = new Casillero(fila, columna);
        Direccion direccionAbajo = new DireccionAbajo();
        direccionAbajo.mover(casillero);
        int nuevaFila = 3;
        Casillero casilleroEsperado = new Casillero(nuevaFila, columna);

        assertTrue(casillero.equals(casilleroEsperado));
    }

    @Test
    public void unaDireccionArribaRecibeUnCasilleroYLoMueveDeberiaEstarEnOtraUbicacion() {
        Casillero casillero = new Casillero(fila, columna);
        Direccion direccionArriba = new DireccionArriba();
        direccionArriba.mover(casillero);
        int nuevaFila = 1;
        Casillero casilleroEsperado = new Casillero(nuevaFila, columna);

        assertTrue(casillero.equals(casilleroEsperado));
    }

    @Test
    public void unaDireccionDerechaRecibeUnCasilleroYLoMueveDeberiaEstarEnOtraUbicacion() {
        Casillero casillero = new Casillero(fila, columna);
        Direccion direccionDerecha = new DireccionDerecha();
        direccionDerecha.mover(casillero);
        int nuevaColumna = 3;
        Casillero casilleroEsperado = new Casillero(fila, nuevaColumna);

        assertTrue(casillero.equals(casilleroEsperado));
    }

    @Test
    public void unaDireccionIzquierdaRecibeUnCasilleroYLoMueveDeberiaEstarEnOtraUbicacion() {
        Casillero casillero = new Casillero(fila, columna);
        Direccion direccionIzquierda = new DireccionIzquierda();
        direccionIzquierda.mover(casillero);
        int nuevaColumna = 1;
        Casillero casilleroEsperado = new Casillero(fila, nuevaColumna);

        assertTrue(casillero.equals(casilleroEsperado));
    }

}
