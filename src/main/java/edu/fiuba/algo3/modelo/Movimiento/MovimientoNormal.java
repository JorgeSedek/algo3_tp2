package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Ubicacion;

public class MovimientoNormal implements Movimiento{
    private Direccion direccion;

    @Override
   public Ubicacion mover(Ubicacion ubicacion){
       this.direccion.mover(ubicacion);
       return ubicacion;
   }

    @Override
    public void asignarDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
