package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

import java.util.HashMap;

public class Piquete extends ObjetoUrbano {


    @Override
    protected void initUrbanoMap() {
        /*
        urbanoMap = new HashMap<>();
        urbanoMap.put(Auto.class, (x) -> recibeAuto((Auto) x));
        urbanoMap.put(Moto.class, (x) -> recibeMoto((Moto) x));
        urbanoMap.put(Camioneta.class, (x) -> recibeCamioneta((Camioneta) x));
*/
    }

    public void recibeAuto(Auto auto) {

    }

    public void recibeMoto(Moto moto) {
        int incremento = 2;
        moto.incrementarMovimientos(incremento);
    }

    public void recibeCamioneta(Camioneta camioneta) {
        }
    /*
    public void pasarObstaculo(Auto auto, Jugador jugador){
    }
    public void pasarObstaculo(Moto moto, Jugador jugador){
        jugador.incrementarMovimientos(2);
    }
    public void pasarObstaculo(Camioneta camioneta, Jugador jugador){
    }
    */

}
