package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Calle;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CalleTest {

    @Test
    public void seCreaUnaCalleSinObjetosUrbanosYEstaVacia() {
        Calle calle = new Calle();
        assertEquals(calle.obtenerObjetosUrbanos().size(), 0);
    }

    @Test
    public void seCreaUnaCalleSinObjetosUrbanosYAgregoUnObstaculo() {
        Calle calle = new Calle();
        calle.agregarObjetoUrbano(new Pozo());

        assertEquals(calle.obtenerObjetosUrbanos().size(), 1);
    }

    @Test
    public void seCreaUnaCalleConObstaculoYPuedoObtenerlo() {
        Pozo pozo = new Pozo();
        ArrayList<ObjetoUrbano> objetosUrbanos = new ArrayList<ObjetoUrbano>();

        objetosUrbanos.add(pozo);

        Calle calle = new Calle(objetosUrbanos);

        assertEquals(calle.obtenerObjetosUrbanos(), objetosUrbanos);
    }
}
