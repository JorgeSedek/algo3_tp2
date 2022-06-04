package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntreCalleTest {
    @Test
    public void asignoVariasCallesYSeGuardan () {
        EntreCalle entreCalle = new EntreCalle();
        Calle calle_superior = new Calle();
        Calle calle_inferior = new Calle();
        Calle calle_izquierda = new Calle();
        Calle calle_derecha = new Calle();
        entreCalle.asignarCalles(calle_superior, calle_inferior, calle_izquierda, calle_derecha);

        assertEquals(entreCalle.obtenerCalleSuperior(), calle_superior);
        assertEquals(entreCalle.obtenerCalleInferior(), calle_inferior);
        assertEquals(entreCalle.obtenerCalleIzquierda(), calle_izquierda);
        assertEquals(entreCalle.obtenerCalleDerecha(), calle_derecha);

    }
}
