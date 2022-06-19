

package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Ubicacion;

public class MovimientoNormal implements Movimiento{
    public void mover(Ubicacion ubicacionActual, Direccion direccion){
        direccion.mover(ubicacionActual);
    }


}
