

package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;

public class MovimientoNormal implements Movimiento{
    public void mover(Casillero casilleroActual, Direccion direccion){
        direccion.mover(casilleroActual);
    }


}
