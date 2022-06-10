package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasilleroTest {
    @Test
    public void asignoVariasCallesYSeGuardan () {
        Casillero casillero = new Casillero();
        Calle calle_superior = new Calle();
        Calle calle_inferior = new Calle();
        Calle calle_izquierda = new Calle();
        Calle calle_derecha = new Calle();
        casillero.asignarCalles(calle_superior, calle_inferior, calle_izquierda, calle_derecha);

        assertEquals(casillero.obtenerCalleSuperior(), calle_superior);
        assertEquals(casillero.obtenerCalleInferior(), calle_inferior);
        assertEquals(casillero.obtenerCalleIzquierda(), calle_izquierda);
        assertEquals(casillero.obtenerCalleDerecha(), calle_derecha);

    }
}
