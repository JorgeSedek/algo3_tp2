package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Casillero {
    protected ArrayList<ObjetoUrbano> contenidos;
    protected int indiceObjetoActual;
    protected Ubicacion ubicacion;
    /* HAY QUE PENSAR COMO HACER PARA CUANDO SE TIENE UNA SORPRESA. TODAVIA NO LE DIJE CUANDO REINICIAR
    EL INDICE "indiceObjetoActual". LA IDEA ES QUE DESPUES DE DAR EL ULTIMO ELEMENTO CONTENIDO SE REINICIE
 */

    public Casillero(Ubicacion ubicacion){
        this.contenidos = new ArrayList<>();
        this.indiceObjetoActual = 0;
        this.ubicacion = ubicacion;
    }
    public void contiene(ObjetoUrbano contenido){
       this.contenidos.add(contenido);
    }

    public ObjetoUrbano devolverContenido(){
        ObjetoUrbano contenido = this.contenidos.get(indiceObjetoActual);
        indiceObjetoActual++;
        return contenido;
    }

    public void reiniciarIndiceObjetoActual(){
        indiceObjetoActual = 0;
    }

    public boolean equals(Ubicacion ubicacion){
        return this.ubicacion.equals(ubicacion);
    }
}
