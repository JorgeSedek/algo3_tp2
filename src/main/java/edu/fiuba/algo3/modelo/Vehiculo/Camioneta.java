package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Casillero casillero) {
        super(casillero);
        this.pozos_atravesados = 0;
    }

    public void recibe(Obstaculo obstaculo) {
        obstaculo.atravezar(this);
    }

    public void recibe(Sorpresa sorpresa) {
        sorpresa.atravezar(this);
    }

    public boolean pasoLimitePozos() {
        int maximoPozosAtravezadosGratis = 3;
        return this.pozos_atravesados > maximoPozosAtravezadosGratis;
    }

    public void atravezoPozo() {
        this.pozos_atravesados++;
    }
}
