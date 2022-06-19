

package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Ubicacion;

public interface Movimiento {

    void mover(Ubicacion ubicacionActual, Direccion direccion);

}
