package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Auto extends Vehiculo {
    public Auto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public Efecto atravesar(Obstaculo obstaculo, Efecto efectoInicial) {
        return obstaculo.atravesar(this, efectoInicial);
    }

    public Efecto atravesar(Sorpresa sorpresa, Efecto efectoInicial) {
        return sorpresa.atravesar(this, efectoInicial);
    }
}

