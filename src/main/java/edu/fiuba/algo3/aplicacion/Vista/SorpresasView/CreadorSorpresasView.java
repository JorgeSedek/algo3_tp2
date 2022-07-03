package edu.fiuba.algo3.aplicacion.Vista.SorpresasView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;

public class CreadorSorpresasView {
    public SorpresaView crear(Sorpresa sorpresa, Casillero casillero, double alto, double ancho) {
        return new SorpresaView(casillero, alto, ancho);
    }
}
