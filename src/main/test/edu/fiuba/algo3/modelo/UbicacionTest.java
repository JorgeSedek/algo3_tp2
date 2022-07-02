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

    @Test
    public void seVerificaQueUnaUbicacionQueRepresentaUnaCalleSeaUnaCalle(){
        int filaCalle = 2;
        int columnaCalle = 1;
        Ubicacion ubicacion = new Ubicacion(filaCalle, columnaCalle);

        assertTrue(ubicacion.hayCalle());
        assertFalse(ubicacion.hayEdificio());
        assertFalse(ubicacion.hayEntrecalle());
    }

    @Test
    public void seVerificaQueOtraUnaUbicacionQueRepresentaUnaCalleSeaUnaCalle(){
        int filaCalle = 3;
        int columnaCalle = 2;
        Ubicacion ubicacion = new Ubicacion(filaCalle, columnaCalle);

        assertTrue(ubicacion.hayCalle());
        assertFalse(ubicacion.hayEdificio());
        assertFalse(ubicacion.hayEntrecalle());
    }

    @Test
    public void seVerificaQueUnaUbicaiconQueRepresentaUnaEntrecalleSeaUnaEntrecalle(){
        int filaEntrecalle = 2;
        int columnaEntrecalle = 2;
        Ubicacion ubicacion = new Ubicacion(filaEntrecalle, columnaEntrecalle);

        assertTrue(ubicacion.hayEntrecalle());
        assertFalse(ubicacion.hayEdificio());
        assertFalse(ubicacion.hayCalle());
    }

    @Test
    public void seVerificaQueUnaUbicaiconQueRepresentaUnEdificioSeaUnEdificio(){
        int filaEdificio = 1;
        int columnaEdificio = 1;
        Ubicacion ubicacion = new Ubicacion(filaEdificio, columnaEdificio);

        assertTrue(ubicacion.hayEdificio());
        assertFalse(ubicacion.hayEntrecalle());
        assertFalse(ubicacion.hayCalle());
    }

}
