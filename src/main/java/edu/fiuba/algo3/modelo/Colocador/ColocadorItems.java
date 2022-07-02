package edu.fiuba.algo3.modelo.Colocador;

import edu.fiuba.algo3.modelo.General.Casillero;

import java.util.ArrayList;

public interface ColocadorItems {
    public void agregarObstaculosYSorpresas(ArrayList<Casillero> casilleros);

    void agregarMeta(ArrayList<Casillero> casilleros);
}
