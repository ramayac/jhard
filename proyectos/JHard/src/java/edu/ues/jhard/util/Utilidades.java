package edu.ues.jhard.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilidades varias para manejo de tiempo y otras ocurrencias.
 * @author rodrigo
 */
public class Utilidades {

    public static int DiaHoyEntero() {
        Format day_formatter = new SimpleDateFormat("F"); //"F" day of week in month
        Date date = new Date();
        //formatear fecha y convertirla a entero
        int i_cday = Integer.parseInt(day_formatter.format(date));
        return i_cday;
    }

    /**
     * Es el momento actual (ray naooo!) antes del parametro hora?
     * @param hora
     * @return
     */
    public static Boolean EsAntesDeHora(Date horaComparar){
        int hora1 = new Date().getHours();
        int minuto1 = new Date().getMinutes();
        int hora2 = horaComparar.getHours();
        int minuto2 = horaComparar.getMinutes();
        if(hora1 < hora2){ //3:00 pm vs 5:00 pm
            return true;
        } else if (hora1 == hora2){ //3:10 pm = 3:20 pm
            if(minuto1 < minuto2) return true;
        }

        return false; //para todo lo demas

    }

    public static String DiaNombre(int dia) {
        switch (dia) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sabado";
            case 7:
                return "Domingo";
            default:
                return "Indeterminado";
        }
    }
}