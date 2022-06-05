package edu.fiuba.algo3.modelo;

public class GPS {
    private Escenario escenario;
    private Jugador jugador;

    public GPS (String nombre, Vehiculo vehiculo) {
        escenario = new Escenario();
        jugador = new Jugador(nombre, vehiculo);
    }

    /*
    Comentado de momento hasta darle uso
    public void iniciarJuego(Jugador jugador) {

    }
    */
}
