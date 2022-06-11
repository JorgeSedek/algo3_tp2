package edu.fiuba.algo3.modelo;

public abstract class Movimiento {
    protected Direccion direccion;
    /*
    Ya no se va a mover mas de una entrecalle a otra, si no de entrecalle a calle. Algunos casilleros
    van a ser edificios y ahi no se va a poder mover.
    Casillero deberia tener hijas: CasilleroPermitido y CasilleroProhibido
    Dentro de movimiento hay que verificar si el casillero al que se va llegar producto del movimiento
    es permitido o prohibido, si es prohibido la ubicacion que devuelve movimiento deberia se la misma
    que se paso como parametro de entrada. Si no se la modifica como aparece en MovimientoNormal
     */
    abstract public Ubicacion mover(Ubicacion ubicacion);

    public void asignarDireccion(Direccion direccion){
        this.direccion = direccion;
    }
}
