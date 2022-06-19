package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CasilleroTest {
    private int fila = 1;
    private int columna = 1;

    @Test
    public void comparoLaUbicacionDeUnCasilleroConElDeOtraUbicacion() {
        Casillero casillero = new Casillero(fila, columna);
        Ubicacion mismaUbicacion = new Ubicacion(fila, columna);

        assertTrue(casillero.equals(mismaUbicacion));

        int otraFila = 8;
        int otraColumna = 8;
        casillero = new Casillero(otraFila, otraColumna);
        mismaUbicacion = new Ubicacion(otraFila, otraColumna);

        assertTrue(casillero.equals(mismaUbicacion));
    }

    @Test
    public void seComparaUnCasilleroPorUbicacion(){
        Casillero casillero = new Casillero(fila, columna);
        int filaDistinta = 2;
        int columnaDistinta = 2;
        Ubicacion primeraUbicacion = new Ubicacion(filaDistinta, columnaDistinta);

        assertFalse(casillero.equals(primeraUbicacion));
    }
}


