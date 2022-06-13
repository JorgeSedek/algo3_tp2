package edu.fiuba.algo3.modelo.General;

import java.util.ArrayList;

public class Calle {
    private ArrayList<ObjetoUrbano> contenidos;
    // private int indiceObjetoActual;

    public Calle() {
        this.contenidos = new ArrayList<>();
    }

    // Para tests, con este constructor se le puede pasar un array de objetos urbanos y la calle
    // es creada con ellos (se pueden forzar obstaculos/sorpresas en la creacion)
    public Calle(ArrayList<ObjetoUrbano> contenidos ) {
        this.contenidos = contenidos;
    }

    // Agrega la sorpresa u obstaculo pasado por parametro a la calle
    public void agregarObjetoUrbano(ObjetoUrbano objetoUrbano){
        this.contenidos.add(objetoUrbano);
    }

    public ArrayList<ObjetoUrbano> obtenerObjetosUrbanos(){
        return this.contenidos;
    }

    // Se Usa para Test
    public boolean verificarCantidadObjetosUrbanos(int cantidadObjetosUrbanos) {
        return this.contenidos.size() == cantidadObjetosUrbanos;
    }

    /*
    DE MOMENTO NO SE UTILIZA

    // Aplica las sorpresas u obstaculos correspondientes
    public void aplicarObjetosUrbanos(Jugador jugador) {
        for (int i = 0; i <= contenidos.size(); i++) {
            contenidos.get(i).aplicar(jugador);
        }
    }
    */

    /*
    DE MOMENTO NO SE UTILIZA

    public ObjetoUrbano obtenerObjetoUrbano(){
        ObjetoUrbano contenido = this.contenidos.get(indiceObjetoActual);
        indiceObjetoActual++;
        return contenido;
    }
    */
}
