package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionVacia implements Direccion{
 public void mover(Ubicacion ubicacion){

    }

    public Direccion direccionOpuesta(){
        return this;
    }

    public String asString(){
     return "vacio";
    }
}
