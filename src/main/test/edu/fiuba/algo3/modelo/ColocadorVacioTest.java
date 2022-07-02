package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.General.Escenario;
import org.junit.jupiter.api.Test;

public class ColocadorVacioTest {

    @Test
    public void elEscenarioSeInicializaConUnColocadorVacioYCuandoSeLePideAgregarObstaculosYSorpresasComoAsiTambienLaMetaNoAgregaNada() {
        Escenario.resetInstance(4, 4);
        Escenario.getInstance().agregarObstaculosYSorpresas();
        Escenario.getInstance().agregarMeta();
    }
}
