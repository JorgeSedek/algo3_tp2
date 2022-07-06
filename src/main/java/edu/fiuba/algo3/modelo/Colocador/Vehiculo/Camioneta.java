package edu.fiuba.algo3.modelo.Colocador.Vehiculo;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;
    private final int MAXIMOPOZOSATRAVEZADOSGRATIS;

    public Camioneta(Ubicacion ubicacion) {
        super(ubicacion);
        this.pozos_atravesados = 0;
        this.MAXIMOPOZOSATRAVEZADOSGRATIS = 3;
    }

    public Efecto atravesar(Obstaculo obstaculo) {
        return obstaculo.atravesar(this);
    }

    public Efecto atravesar(Sorpresa sorpresa) {
        return sorpresa.atravesar(this);
    }

    public String asString() {
        return "Camioneta";
    }

    public boolean pasoLimitePozos() {
        this.pozos_atravesados++;
        return this.pozos_atravesados > MAXIMOPOZOSATRAVEZADOSGRATIS;
    }
}
