package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public interface Obstaculo {
    void atravesar(Auto auto);

    void atravesar(Camioneta camioneta);

    void atravesar(Moto moto);
}
