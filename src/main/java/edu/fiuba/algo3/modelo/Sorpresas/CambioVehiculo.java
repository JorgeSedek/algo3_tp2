package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoCambioVehiculo;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class CambioVehiculo implements Sorpresa {
    public Efecto atravesar(Auto auto) {
        Efecto efecto = new EfectoGeneral();
        return new EfectoCambioVehiculo(efecto, auto);
    }

    public Efecto atravesar(Camioneta camioneta) {
        Efecto efecto = new EfectoGeneral();
        return new EfectoCambioVehiculo(efecto, camioneta);
    }

    public Efecto atravesar(Moto moto) {
        Efecto efecto = new EfectoGeneral();
        return new EfectoCambioVehiculo(efecto, moto);
    }
}