package edu.ues.jhard.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Utilidades varias para manejo de tiempo y otras ocurrencias.
 * @author rodrigo
 */
public class Utilidades {

    public static String FormateaHora(Date hora){
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); // 	12:08 PM
        return sdf.format(hora);
    }

    public static int DiaHoyEntero() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int dia = cal.get(Calendar.DAY_OF_WEEK);
        return dia-1;
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

    /**
     * Es la hora 1 antes de la hora2 ?
     * @param hora1
     * @param hora2
     * @return
     */
    public static Boolean EsAntesDeHora(Date hora1, Date hora2){
        int h1 = hora1.getHours();
        int m1 = hora1.getMinutes();
        int h2 = hora2.getHours();
        int m2 = hora2.getMinutes();
        if(h1 < h2){ //3:00 pm vs 5:00 pm
            return true;
        } else if (h1 == h2){ //3:10 pm = 3:20 pm
            if(m1 < m2) return true;
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

    public static boolean EsDeHoy(Date fecha) {
        int año1 = new Date().getYear();
        int mes1 = new Date().getMonth();
        int dia1 = new Date().getDay();

        int año2 = fecha.getYear();
        int mes2 = fecha.getMonth();
        int dia2 = fecha.getDay();

        if(año1 == año2){
            if(mes1==mes2){
                if(dia1==dia2) return true;
            }
        }

        return false; //para todo lo demas
    }
}
