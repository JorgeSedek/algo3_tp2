package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UbicacionTest {
    private int fila = 1;
    private int columna = 1;

    @Test
    public void creoUnaUbicacionConDiferentesFilasYColumnasDeberiaCrearseCorrectamente() {
        Ubicacion ubicacion = new Ubicacion(fila, columna);
        Ubicacion mismaUbicacion = new Ubicacion(fila, columna);

        assertTrue(ubicacion.equals(mismaUbicacion));

        int otraFila = 8;
        int otraColumna = 8;
        ubicacion = new Ubicacion(otraFila, otraColumna);
        mismaUbicacion = new Ubicacion(otraFila, otraColumna);

        assertTrue(ubicacion.equals(mismaUbicacion));
    }

    @Test
    public void seComparanDosUbicacionesDistintasDeberiaComprobarseQueSonDistintas(){
        Ubicacion primeraUbicacion = new Ubicacion(fila, columna);
        int filaDistinta = 2;
        int columnaDistinta = 2;
        Ubicacion segundaUbicacion = new Ubicacion(filaDistinta, columnaDistinta);

        assertFalse(primeraUbicacion.equals(segundaUbicacion));
    }
}
