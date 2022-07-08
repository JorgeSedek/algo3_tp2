package edu.fiuba.algo3.modelo.General;

public class Logger {
    private boolean activo;
    private static Logger INSTANCE = null;

    private String acumulacion;

    private Logger() {
        this.activo = false;
        this.acumulacion = "";
    }

    private synchronized static void createInstance() {
        INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        if(INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void activar() {
        this.activo = true;
    }

    public void desactivar() {
        this.activo = false;
    }

    public void imprimir(String string) {
        if(activo) {
            System.out.println(string);
            this.acumulacion += "\n" + string;
        }
    }

    public String escribir() {
        return acumulacion;
    }

    public void resetear() {
        this.acumulacion = "";
    }
}
