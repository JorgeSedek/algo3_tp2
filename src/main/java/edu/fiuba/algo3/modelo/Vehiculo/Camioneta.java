package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Ubicacion ubicacion) {
        super(ubicacion);
        this.pozos_atravesados = 0;
    }

    public void atravesar(Obstaculo obstaculo) {
        obstaculo.atravesar(this);
    }

    public void atravesar(Sorpresa sorpresa) {
        sorpresa.atravesar(this);
    }

    public boolean pasoLimitePozos() {
        int maximoPozosAtravezadosGratis = 3;
        return this.pozos_atravesados > maximoPozosAtravezadosGratis;
    }

    public void atravezoPozo() {
        this.pozos_atravesados++;
    }
}
