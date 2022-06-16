package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Moto extends Vehiculo {
    public Moto(Casillero casillero) {
        super(casillero);
    }

    public void recibe(Obstaculo obstaculo) {
        obstaculo.atravesar(this);
    }

    public void recibe(Sorpresa sorpresa) {
        sorpresa.atravesar(this);
    }
}
