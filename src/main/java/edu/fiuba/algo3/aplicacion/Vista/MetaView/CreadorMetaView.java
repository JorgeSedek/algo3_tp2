package edu.fiuba.algo3.aplicacion.Vista.MetaView;

import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Meta.Meta;

public class CreadorMetaView {
    public MetaView crear(Casillero casillero, double alto, double ancho){
        return new MetaView(casillero, alto, ancho);
    }
}
