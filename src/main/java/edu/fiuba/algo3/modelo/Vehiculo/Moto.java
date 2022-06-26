package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Moto extends Vehiculo {
    public Moto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public Efecto atravesar(Obstaculo obstaculo, Efecto efecto) {
        return obstaculo.atravesar(this, efecto);
    }

    public Efecto atravesar(Sorpresa sorpresa, Efecto efecto) {
        return sorpresa.atravesar(this, efecto);
    }
}
