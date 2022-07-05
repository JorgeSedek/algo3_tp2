package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoMoverAlReves extends EfectoDecorador {

    public EfectoMoverAlReves(Efecto efecto, Vehiculo vehiculo) {
        super(efecto);
        vehiculo.cambiarDireccionContraria();
    }
    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);
        jugador.moverVehiculoSentidoOpuesto();
    }
}

