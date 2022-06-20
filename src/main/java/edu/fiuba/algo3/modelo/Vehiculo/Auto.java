package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Auto extends Vehiculo {
    public Auto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public void atravesar(Obstaculo obstaculo) {
        obstaculo.atravesar(this);
    }

    public void atravesar(Sorpresa sorpresa) {
        sorpresa.atravesar(this);
    }
}

