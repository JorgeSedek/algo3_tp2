package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.General.Casillero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasilleroTest {
    private int fila = 1;
    private int columna = 1;

    @Test
    public void creoUnaCasilleroConDiferentesFilasYColumnasDeberiaCrearseCorrectamente() {
        Casillero casillero = new Casillero(fila, columna);
        Casillero mismaCasillero = new Casillero(fila, columna);

        assertTrue(casillero.equals(mismaCasillero));

        int otraFila = 8;
        int otraColumna = 8;
        casillero = new Casillero(otraFila, otraColumna);
        mismaCasillero = new Casillero(otraFila, otraColumna);

        assertTrue(casillero.equals(mismaCasillero));
    }

    @Test
    public void seComparanDosCasilleroesDistintasDeberiaComprobarseQueSonDistintas(){
        Casillero primeraCasillero = new Casillero(fila, columna);
        int filaDistinta = 2;
        int columnaDistinta = 2;
        Casillero segundaCasillero = new Casillero(filaDistinta, columnaDistinta);

        assertFalse(primeraCasillero.equals(segundaCasillero));
    }
}
