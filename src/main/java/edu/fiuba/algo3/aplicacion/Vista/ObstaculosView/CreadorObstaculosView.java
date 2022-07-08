package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.*;

public class CreadorObstaculosView {
    public ObstaculoView crear(Obstaculo obstaculo, Casillero casillero, double alto, double ancho) {
        if (obstaculo instanceof Piquete) {
            PiqueteView piqueteView = new PiqueteView(casillero,alto, ancho);
            return piqueteView;
        }

        if (obstaculo instanceof Pozo) {
            PozoView pozoView = new PozoView(casillero, alto, ancho);
            return pozoView;
        }

        if (obstaculo instanceof Policia) {
            PoliciaView policiaView = new PoliciaView(casillero, alto, ancho);
            return policiaView;
        }

        else {
            SinObstaculoView sinObstaculoView = new SinObstaculoView(casillero, alto, ancho);
            return sinObstaculoView;
        }
    }

}