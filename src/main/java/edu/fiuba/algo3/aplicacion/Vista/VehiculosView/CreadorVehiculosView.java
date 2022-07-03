package edu.fiuba.algo3.aplicacion.Vista.VehiculosView;

import edu.fiuba.algo3.aplicacion.Vista.ObstaculosView.*;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Policia;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Vehiculo.Auto;
import edu.fiuba.algo3.modelo.Vehiculo.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CreadorVehiculosView {

    public void crear(Auto auto, Pane root) {
        AutoView autoView = new AutoView(auto);
        root.getChildren().add(autoView.dibujar());
    }

    public void crear(Camioneta camioneta, Pane root) {
        CamionetaView camionetaView = new CamionetaView(camioneta);
        root.getChildren().add(camionetaView.dibujar());
    }

    public void crear(Moto moto, Pane root) {
        MotoView motoView = new MotoView(moto);
        root.getChildren().add(motoView.dibujar());
    }
/*
        if (vehiculo instanceof Auto) {
           AutoView autoView = new AutoView((Auto) vehiculo);
            root.getChildren().add(autoView.dibujar());
        }

        if (vehiculo instanceof Moto) {
            MotoView motoView = new MotoView((Moto) vehiculo);
            root.getChildren().add(motoView.dibujar());
        }
*/
     /*   else  (vehiculo instanceof Camioneta) {
            CamionetaView camionetaView = new CamionetaView((Camioneta) vehiculo);
            root.getChildren().add(camionetaView.dibujar());
        }
    }
    */
}
