package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public interface CollitionHandler {
    Vehiculo collideWith(ObjetoUrbano otro);
}
