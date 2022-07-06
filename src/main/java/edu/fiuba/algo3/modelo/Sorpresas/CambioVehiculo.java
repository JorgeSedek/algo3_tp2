package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoCambioVehiculo;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class CambioVehiculo implements Sorpresa {
    public Efecto atravesar(Auto auto) {
        Logger.getInstance().imprimir("Recibiste una sorpresa Cambio de Vehiculo, tu vehículo pasa a ser una camioneta");
        Efecto efecto = new EfectoGeneral();
        return new EfectoCambioVehiculo(efecto, auto);
    }

    public Efecto atravesar(Camioneta camioneta) {
        Logger.getInstance().imprimir("Recibiste una sorpresa Cambio de Vehiculo, tu vehículo pasa a ser una moto");
        Efecto efecto = new EfectoGeneral();
        return new EfectoCambioVehiculo(efecto, camioneta);
    }

    public Efecto atravesar(Moto moto) {
        Logger.getInstance().imprimir("Recibiste una sorpresa Cambio de Vehiculo, tu vehículo pasa a ser un auto");
        Efecto efecto = new EfectoGeneral();
        return new EfectoCambioVehiculo(efecto, moto);
    }
}