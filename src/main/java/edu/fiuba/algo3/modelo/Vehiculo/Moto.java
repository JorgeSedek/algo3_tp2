package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;

import java.util.HashMap;

public class Moto extends Vehiculo {
    public Moto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    protected void initUrbanoMap() {
        urbanoMap = new HashMap<>();
        urbanoMap.put(Pozo.class, (x) -> recibePozo(x));
        urbanoMap.put(Piquete.class, (x) -> recibePiquete(x));
    }

    private void recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.incrementarMovimientos(incremento);
    }

    private void recibePiquete(ObjetoUrbano x) {
        int incremento = 2;
        this.incrementarMovimientos(incremento);
    }
}
