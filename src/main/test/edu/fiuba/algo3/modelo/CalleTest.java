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
        Casillero casillero1 = calle.entreCallePrimera();
        Casillero casillero2 = calle.entreCalleSegunda();

        assertTrue(casillero1 != null);
        assertTrue(casillero2 != null);

    }

    @Test
    public void lasEntreCallesDeCalleSonDistintasEntreEllas(){
        Calle calle = new Calle();
        Casillero casillero1 = calle.entreCallePrimera();
        Casillero casillero2 = calle.entreCalleSegunda();

        assertFalse(casillero1 == casillero2);
    }

    @Test
    public void calleConParametrosNoEstaVacia(){
        Casillero entrecalle1 = new Casillero();
        Casillero entrecalle2 = new Casillero();

        Calle calle = new Calle(entrecalle1, entrecalle2);
        assertFalse(calle == null);
    }

    @Test
    public void calleTiene2EntreCallesYAlingresarUnaEntreCalleDevuelveLaOtra(){
        Casillero entrecalle1 = new Casillero();
        Casillero entrecalle2 = new Casillero();

        Calle calle = new Calle(entrecalle1, entrecalle2);
        Casillero casilleroRecivida = calle.otraEntreCalle(entrecalle1);
        assertEquals(casilleroRecivida, entrecalle2);
        casilleroRecivida = calle.otraEntreCalle(entrecalle2);
        assertEquals(casilleroRecivida, entrecalle1);
    }

    @Test
    public void calleTieneUnPozoYdevuelvePozo(){
        Calle calle = new Calle();
        Pozo obstaculo = new Pozo();
        calle.asignarObstaculo(obstaculo);
        assertEquals(obstaculo, calle.obstaculo());
    }
}
