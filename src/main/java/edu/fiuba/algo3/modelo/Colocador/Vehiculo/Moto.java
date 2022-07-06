package edu.fiuba.algo3.modelo.Colocador.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Moto extends Vehiculo {
    public Moto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public Efecto atravesar(Obstaculo obstaculo) {
        return obstaculo.atravesar(this);
    }

    public Efecto atravesar(Sorpresa sorpresa) {
        return sorpresa.atravesar(this);
    }

    public String asString() {
        return "Moto";
    }
}
