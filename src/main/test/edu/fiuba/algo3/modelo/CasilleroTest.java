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

    /*
    @Test
    public void seVerificaQueLosCasillerosAdyacentesSeanLosCorrectos(){
        int fila = 2;
        int columna = 2;
        int filaIzquierda = 1;
        int filaDerecha = 3;
        int columnaArriba = 1;
        int columnaAbajo = 3;

        HashMap<Direccion, Casillero> casillerosAdyacentes = new HashMap<Direccion, Casillero>();

        Casillero casillero = new Casillero(fila,columna);
        casillero.cargarCasillerosAdyacentes();

        Casillero casilleroIzquierda = new Casillero(filaIzquierda,columna);
        Casillero casilleroDerecha = new Casillero(filaDerecha,columna);
        Casillero casilleroAbajo = new Casillero(fila,columnaAbajo);
        Casillero casilleroArriba = new Casillero(fila,columnaArriba);


        casillerosAdyacentes.put(new DireccionDerecha(), casilleroDerecha);
        casillerosAdyacentes.put(new DireccionIzquierda(), casilleroIzquierda);
        casillerosAdyacentes.put(new DireccionAbajo(), casilleroAbajo);
        casillerosAdyacentes.put(new DireccionArriba(), casilleroArriba);

        assertTrue(casillero.verificarCasillerosAdyacentes(casillerosAdyacentes));



    }
    */
}


