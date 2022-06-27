package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;
    private int maximoPozosAtravezadosGratis;

    public Camioneta(Ubicacion ubicacion) {
        super(ubicacion);
        this.pozos_atravesados = 0;
        this.maximoPozosAtravezadosGratis = 3;
    }

    public Efecto atravesar(Obstaculo obstaculo, Efecto efecto) {
        return obstaculo.atravesar(this, efecto);
    }

    public Efecto atravesar(Sorpresa sorpresa, Efecto efecto) {
        return sorpresa.atravesar(this, efecto);
    }

    public boolean pasoLimitePozos() {
        return this.pozos_atravesados > maximoPozosAtravezadosGratis;
    }

    public void atravezoPozo() {
        this.pozos_atravesados++;
    }
}
