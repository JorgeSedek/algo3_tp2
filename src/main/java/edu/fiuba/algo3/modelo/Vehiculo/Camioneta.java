package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;

import java.util.HashMap;

public class Camioneta extends Vehiculo {
    private int pozos_atravesados;

    public Camioneta(Ubicacion ubicacion) {
        super(ubicacion);
    }


    @Override
    protected void initUrbanoMap() {
        urbanoMap = new HashMap<>();
        urbanoMap.put(Pozo.class, (x) -> recibePozo(x));
        urbanoMap.put(Piquete.class, (x) -> recibePiquete(x));
    }

    private void recibePozo(ObjetoUrbano x) {
        int veces_atravezados = this.sumarVecesPasadosEnPozo();
        int incremento = 3;
        if (veces_atravezados > 3) {
            this.incrementarMovimientos(incremento);
        }
    }
    private void recibePiquete(ObjetoUrbano x) {

    }


    public int sumarVecesPasadosEnPozo(){
        pozos_atravesados = pozos_atravesados + 1;
        return pozos_atravesados;
    }
}
