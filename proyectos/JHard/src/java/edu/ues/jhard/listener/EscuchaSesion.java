/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Clase que se encarga de monitorear cuando se crea y se destruyen sessiones en el webserver.
 * @author rodrigo
 */

public class EscuchaSesion implements HttpSessionListener {

    /**
     * Mantiene una lista sencilla de sesiones creadas para clientes en el sistema.
     */
    private static List<String> mapaSesionesActivas = new ArrayList();

    /**
     * Retorna la cantidad de usuarios conectados al sistema, o mejor dicho,
     * la cantidad de sesiones creadas activas.
     * @return
     */
    public static Integer getSesionesCreadas() {
        return mapaSesionesActivas.size();
    }

    /**
     * Este metodo se ejecuta siempre que se crea una sesion en el servidor.
     * @param se
     */
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession sesion = se.getSession();
        mapaSesionesActivas.add(sesion.getId());
    }

    /**
     * Este metodo se ejecuta siempre que una sesion se destruye en el servidor.
     * @param se
     */
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession sesion = se.getSession();
        System.out.println("Se destruyo la sesion con ID: "+sesion.getId());
        mapaSesionesActivas.remove(sesion.getId());
    }
}