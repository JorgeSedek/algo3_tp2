package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class SinObstaculo implements Obstaculo{
    public Efecto atravesar(Auto auto){
        return new EfectoGeneral();
    }

    public Efecto atravesar(Camioneta camioneta){
        return new EfectoGeneral();
    }

    public Efecto atravesar(Moto moto){
        return new EfectoGeneral();
    }
}
