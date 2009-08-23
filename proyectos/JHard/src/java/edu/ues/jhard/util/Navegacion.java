/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ues.jhard.util;

/**
 * Clase que se utiliza para reconocer el módulo actual en el que se encuentra navegando en JHard un determinado usuario, y así
 * mostrarlo reflejado en el menú principal
 *
 * Una tan sola propiedad, para colocar el nombre del módulo actual en el que se encuentra navegando un usuario en JHard
 * 
 * @author Hugol
 */
public class Navegacion {

    private static String MODULO_ACTUAL = "Index";
    private String ModuloActual;

    public Navegacion() {
        this.ModuloActual = MODULO_ACTUAL;
    }

    /**
     * @return the ModuloActual
     */
    public String getModuloActual() {
        return this.ModuloActual;
    }

    /**
     * @param ModuloActual the ModuloActual to set
     */
    public void setModuloActual(String ModuloActual) {
        this.ModuloActual = ModuloActual;
    }
}
