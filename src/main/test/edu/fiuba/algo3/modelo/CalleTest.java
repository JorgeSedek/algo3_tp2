package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalleTest {
    @Test
    public void seCreaUnaCalleYnoEstaVacia(){
        Calle calle = new Calle();
        assertTrue(calle != null);
        assertFalse(calle == null);
    }

    @Test
    public void CalleDevuelveEntrecalles(){
        Calle calle = new Calle();
        EntreCalle entreCalle1 = calle.entreCallePrimera();
        EntreCalle entreCalle2 = calle.entreCalleSegunda();

        assertTrue(entreCalle1 != null);
        assertTrue(entreCalle2 != null);

    }

    @Test
    public void lasEntreCallesDeCalleSonDistintasEntreEllas(){
        Calle calle = new Calle();
        EntreCalle entreCalle1 = calle.entreCallePrimera();
        EntreCalle entreCalle2 = calle.entreCalleSegunda();

        assertFalse(entreCalle1 == entreCalle2);
    }

    @Test
    public void calleConParametrosNoEstaVacia(){
        EntreCalle entrecalle1 = new EntreCalle();
        EntreCalle entrecalle2 = new EntreCalle();

        Calle calle = new Calle(entrecalle1, entrecalle2);
        assertFalse(calle == null);
    }

    @Test
    public void calleTiene2EntreCallesYAlingresarUnaEntreCalleDevuelveLaOtra(){
        EntreCalle entrecalle1 = new EntreCalle();
        EntreCalle entrecalle2 = new EntreCalle();

        Calle calle = new Calle(entrecalle1, entrecalle2);
        EntreCalle entreCalleRecivida = calle.otraEntreCalle(entrecalle1);
        assertEquals(entreCalleRecivida, entrecalle2);
        entreCalleRecivida = calle.otraEntreCalle(entrecalle2);
        assertEquals(entreCalleRecivida, entrecalle1);
    }

    @Test
    public void calleTieneUnPozoYdevuelvePozo(){
        Calle calle = new Calle();
        Pozo obstaculo = new Pozo();
        calle.asignarObstaculo(obstaculo);
        assertEquals(obstaculo, calle.obstaculo());
    }
}
