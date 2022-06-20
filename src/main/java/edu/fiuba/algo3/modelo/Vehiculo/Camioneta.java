package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Casillero casillero) {
        super(casillero);
        this.pozos_atravesados = 0;
    }

    public void recibe(Obstaculo obstaculo) {
        Efecto efectoAplicar = obstaculo.atravesar(this);
        efectoAplicar.aplicar(this);
    }

    public void recibe(Sorpresa sorpresa) {
        Efecto efectoAplicar = sorpresa.atravesar(this);
        efectoAplicar.aplicar(this);
    }

    public boolean pasoLimitePozos() {
        int maximoPozosAtravezadosGratis = 3;
        return this.pozos_atravesados > maximoPozosAtravezadosGratis;
    }

    public void atravezoPozo() {
        this.pozos_atravesados++;
    }
}
