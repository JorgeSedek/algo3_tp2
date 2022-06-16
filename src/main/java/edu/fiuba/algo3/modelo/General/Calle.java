package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

import java.util.ArrayList;

public class Calle {
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;

    public Calle() {
        this.obstaculo = null;
        this.sorpresa = null;
    }

    public Calle(Obstaculo obstaculo, Sorpresa sorpresa) {
        this.obstaculo = obstaculo;
        this.sorpresa = sorpresa;
    }
    public Calle(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
        this.sorpresa = null;
    }
    public Calle(Sorpresa sorpresa) {
        this.obstaculo = null;
        this.sorpresa = sorpresa;
    }
}
