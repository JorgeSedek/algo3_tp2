package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Auto extends Vehiculo {
    public Auto(Ubicacion ubicacion) {
        super(ubicacion);
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
}

