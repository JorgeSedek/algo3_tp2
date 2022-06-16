package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Calle;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CalleTest {

    @Test
    public void seCreaUnaCalleSinElementosDeberiaEstarVacia() {
        Calle calle = new Calle();

        assertTrue(calle.verificarSorpresa(null));
        assertTrue(calle.verificarObstaculo(null));
    }

    @Test
    public void seCreaUnaCallConPozoDeberiaContenerlo() {
        Obstaculo pozo = new Pozo();
        Calle calle = new Calle();
        calle.agregarObstaculo(pozo);

        assertTrue(calle.verificarObstaculo(pozo));
    }

    @Test
    public void seCreaUnaCalleConSorpresaFavorableDeberiaContenerla() {
        Sorpresa favorable = new Favorable();
        Calle calle = new Calle();
        calle.agregarSorpresa(favorable);

        assertTrue(calle.verificarSorpresa(favorable));
    }
    @Test
    public void seCreaUnaCalleConSorpresaYObstaculoDeberiaContenerlos() {
        Obstaculo pozo = new Pozo();
        Sorpresa favorable = new Favorable();

        Calle calle = new Calle(pozo, favorable);

        assertTrue(calle.verificarObstaculo(pozo));
        assertTrue(calle.verificarSorpresa(favorable));
    }
}
