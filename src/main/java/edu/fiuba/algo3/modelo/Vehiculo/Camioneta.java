package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Ubicacion;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Ubicacion ubicacion, Movimiento movimiento) {
        super(ubicacion, movimiento);
    }

    public int sumarVecesPasadosEnPozo(){
        pozos_atravesados = pozos_atravesados + 1;
        return pozos_atravesados;
    }
}
