package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class SinObstaculo implements Obstaculo{
    public Efecto atravesar(Auto auto, Efecto efecto){
        return efecto;
    }

    public Efecto atravesar(Camioneta camioneta, Efecto efecto){
        return efecto;
    }

    public Efecto atravesar(Moto moto, Efecto efecto){
        return efecto;
    }
}
