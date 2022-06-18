

package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;

public class MovimientoNormal extends Movimiento{
    public void mover(Casillero casilleroActual, Direccion direccion){
        this.asignarDireccion(direccion);
        direccion.mover(casilleroActual);
    }


}
