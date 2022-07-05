package edu.fiuba.algo3.modelo.Efecto;

import edu.fiuba.algo3.modelo.General.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class EfectoSorpresata extends EfectoDecorador {
    private Vehiculo vehiculo;

    public EfectoSorpresata(Efecto efecto, Vehiculo vehiculo) {
        super(efecto);
        this.vehiculo = vehiculo;
    }

    public void aplicar(Jugador jugador) {
        super.aplicar(jugador);

        Efecto efecto = new EfectoGeneral();
        if(jugador.movimientosPar()){
            if(vehiculo instanceof Auto) {
                efecto = this.calcularEfecto(efecto, (Auto) vehiculo);
            } else if (vehiculo instanceof Moto) {
                efecto = this.calcularEfecto(efecto, (Moto) vehiculo);
            } else if (vehiculo instanceof Camioneta) {
                efecto = this.calcularEfecto(efecto, (Camioneta) vehiculo);
            }
        }
        else{
            if (vehiculo instanceof Moto) {
                efecto = new EfectoIncrementarMovimientos(efecto, 2);
            } else {
                efecto = new EfectoMoverAlReves(efecto, this.vehiculo);
            }
        }
        efecto.aplicar(jugador);
    }

    private Efecto calcularEfecto(Efecto efecto, Auto auto) {
        return new EfectoCambioVehiculo(efecto, auto);
    }

    private Efecto calcularEfecto(Efecto efecto, Moto moto) {
        return new EfectoCambioVehiculo(efecto, moto);
    }

    private Efecto calcularEfecto(Efecto efecto, Camioneta camioneta) {
        return new EfectoCambioVehiculo(efecto, camioneta);
    }
}
