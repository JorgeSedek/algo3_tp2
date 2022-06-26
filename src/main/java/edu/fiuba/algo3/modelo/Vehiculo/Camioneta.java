package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Ubicacion ubicacion) {
        super(ubicacion);
        this.pozos_atravesados = 0;
    }

    public void atravesar(Obstaculo obstaculo, Jugador jugador) {
        Efecto efectoAplicar = obstaculo.atravesar(this);
        efectoAplicar.aplicar(this);
        efectoAplicar.aplicar(jugador);
    }

    public void atravesar(Sorpresa sorpresa, Jugador jugador) {
        Efecto efectoAplicar = sorpresa.atravesar(this);
        efectoAplicar.aplicar(this);
        efectoAplicar.aplicar(jugador);
    }

    public void atravesar(Obstaculo obstaculo) {
        Efecto efectoAplicar = obstaculo.atravesar(this);
        efectoAplicar.aplicar(this);

    }

    public void atravesar(Sorpresa sorpresa) {
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
