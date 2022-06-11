package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Ubicacion;

public abstract class Vehiculo {

    private Ubicacion ubicacion;
    private Movimiento movimiento;

    public Vehiculo(Ubicacion ubicacion, Movimiento movimiento) {
        this.ubicacion = ubicacion;
        this.movimiento = movimiento;
    }

    public Ubicacion obtenerUbicacion () {
        return this.ubicacion;
    }

    public void mover(Direccion direccion){
        this.movimiento.asignarDireccion(direccion);
        this.ubicacion = this.movimiento.mover(this.ubicacion);

    }

}
