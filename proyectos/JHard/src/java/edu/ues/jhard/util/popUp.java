package edu.ues.jhard.util;

/**
 *
 * @author rodrigo
 */
public class popUp {
    private static final String EMPTY_STRING = "";
    private String titulo = EMPTY_STRING;
    private String mensaje = EMPTY_STRING;
    private Boolean visible = new Boolean(false);

    public popUp(String titulo, String mensaje, Boolean visible) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.visible = visible;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}