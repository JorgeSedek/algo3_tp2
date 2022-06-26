package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Efecto.EfectoGeneral;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class SinSorpresa implements Sorpresa{
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
