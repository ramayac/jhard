package edu.ues.jhard.jwiki;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Clase para obtener un ID de artículo de Wiki y poder consultar dicho artículo desde el módulo de JRequest
 * @author rodrigo ramayac
 */
public class JreqArticulo {

    private Integer idarticulo = new Integer(0);
    private String titulo = new String();
    private Double ocurrencias = new Double(0.0);

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Double getOcurrencias() {
        return ocurrencias;
    }

    public void setOcurrencias(Double ocurrencias) {
        this.ocurrencias = ocurrencias;
    }

    public boolean TieneOcurrencias() {
        return (this.ocurrencias.intValue() > 0);
    }

    public void setVector(Vector v) {
        if (v == null) return;
        switch (v.size()) {
            case 2:
                this.idarticulo = Math.round((Long) v.get(0));
                //this.ocurrencias = ((BigDecimal) v.get(1)).doubleValue();
                this.titulo = (String) v.get(1);
                //this.ocurrencias = 0.0;
                break;
            case 3:
                this.idarticulo = Math.round((Long) v.get(0));
                this.ocurrencias = ((BigDecimal) v.get(1)).doubleValue();
                this.titulo = (String) v.get(2);
                break;
        }
    }
}
