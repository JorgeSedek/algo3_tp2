package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Calle;
import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CalleTest {

    @Test
    public void seCreaUnaCalleSinObjetosUrbanosDeberiaEstarVacia() {
        Calle calle = new Calle();
        int cantidadObstaculosYSorpresas = 0;

        assertTrue(calle.verificarCantidadObjetosUrbanos(cantidadObstaculosYSorpresas));
    }

    @Test
    public void seCreaUnaCalleSinObjetosUrbanosYAgregoUnPozoNoDeberiaEstarVacia() {
        Obstaculo pozo = new Pozo();
        Calle calle = new Calle();
        calle.agregarObjetoUrbano(pozo);
        int cantidadObstaculosYSorpresas = 1;

        assertTrue(calle.verificarCantidadObjetosUrbanos(cantidadObstaculosYSorpresas));
    }

    @Test
    public void seCreaUnaCalleConObjetosUrbanosDeberiaPoderObtenerLosObjetosUrbanos() {
        Obstaculo pozo = new Pozo();
        ArrayList<ObjetoUrbano> objetosUrbanos = new ArrayList<ObjetoUrbano>();
        objetosUrbanos.add(pozo);
        Calle calle = new Calle(objetosUrbanos);

        assertEquals(calle.obtenerObjetosUrbanos(), objetosUrbanos);
    }
}
