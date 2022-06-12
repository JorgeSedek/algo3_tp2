package edu.fiuba.algo3.modelo.General;

import java.util.ArrayList;

public class Casillero {
    private Ubicacion ubicacion;
    /* HAY QUE PENSAR COMO HACER PARA CUANDO SE TIENE UNA SORPRESA. TODAVIA NO LE DIJE CUANDO REINICIAR
    EL INDICE "indiceObjetoActual". LA IDEA ES QUE DESPUES DE DAR EL ULTIMO ELEMENTO CONTENIDO SE REINICIE
 */

    public Casillero(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }

    /*

    DE MOMENTO NO SE UTILIZA

    public void reiniciarIndiceObjetoActual(){
        indiceObjetoActual = 0;
    }

     */

    public boolean equals(Ubicacion ubicacion){
        return this.ubicacion.equals(ubicacion);
    }
}
