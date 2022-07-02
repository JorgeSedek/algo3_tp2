package edu.fiuba.algo3.aplicacion.Vista.ObstaculosView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.*;

public class CreadorObstaculosView  {


   public ObstaculoView crear(Piquete piquete, Casillero casillero){
        PiqueteView piqueteView = new PiqueteView(casillero);

    }


    public ObstaculoView crear(Pozo pozo, Casillero casillero){
        PiqueteView piqueteView = new PiqueteView(casillero);

    }


    public ObstaculoView crear(Policia policia, Casillero casillero){
        PiqueteView piqueteView = new PiqueteView(casillero);

    }


    public ObstaculoView crear(SinObstaculo sinObstaculo, Casillero casillero){
        PiqueteView piqueteView = new PiqueteView(casillero);

    }


}
