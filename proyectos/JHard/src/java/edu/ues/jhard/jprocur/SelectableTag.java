package edu.ues.jhard.jprocur;

import java.io.Serializable;

/**
 * @author Rodrigo ramayac
 */

public class SelectableTag implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idtag;
    private String descripcion;
    private Boolean seleccionada = new Boolean(false);

    public SelectableTag() {
    }

    public SelectableTag(Integer idtag) {
        this.idtag = idtag;
    }

    public SelectableTag(Integer idtag, String descripcion) {
        this.idtag = idtag;
        this.descripcion = descripcion;
    }

    public SelectableTag(Integer idtag, String descripcion, Boolean seleccionada) {
        this.idtag = idtag;
        this.descripcion = descripcion;
        this.seleccionada = seleccionada;
    }

    public Integer getIdtag() {
        return idtag;
    }

    public void setIdtag(Integer idtag) {
        this.idtag = idtag;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Boolean seleccionado) {
        this.seleccionada = seleccionado;
    }
}
