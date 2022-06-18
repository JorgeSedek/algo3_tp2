

package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;

public abstract class Movimiento {

    protected Direccion direccion;
    public abstract void mover(Casillero casilleroActual, Direccion direccion);

    protected void asignarDireccion(Direccion direccion){
        this.direccion = direccion;
    }
}
