/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.util;

import edu.ues.jhard.listener.EscuchaSesion;

/**
 * Clase wrapper para acceder a un metodo de "EscuchaSesion".
 * @see EscuchaSesion
 * @author rodrigo
 */
public class UsuariosConectados {

    public UsuariosConectados(){
        
    }

    public Integer getUsuariosConectados(){
        return EscuchaSesion.getSesionesCreadas();
    }
}
