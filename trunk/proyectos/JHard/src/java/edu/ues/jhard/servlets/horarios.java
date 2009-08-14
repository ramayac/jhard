/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.servlets;

import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.jpa.Horario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para obtener todos los horarios y transformarlos a
 * un XML que pueda leer y consumir el DHTMLXScheduler para mostrar eventos
 * @author Hugol
 */
public class horarios extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();


        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Horario> horarios = instance.getAllHorarios();
        Calendar c = Calendar.getInstance();

        int dia =0;

        try {
            out.print("<?xml version='1.0' encoding='ISO-8859-1'?><data>");

            for(Horario hr: horarios){
                Date fecha = c.getTime();
                
                System.out.println("Q DIA DE LA SEMANA ES " + c.get(Calendar.DAY_OF_WEEK));
                int posicion = c.get(Calendar.DAY_OF_WEEK)-hr.getDiasemana();

                System.out.println(posicion);
                System.out.println("QUE DIA DEL MES ES "+ c.get(Calendar.DATE));
                if (posicion>0){
                    dia = c.get(Calendar.DATE) -  posicion + 1;

                }else{
                    if(posicion<0){
                        dia = c.get(Calendar.DATE) + Math.abs(posicion) + 1;
                    }else{
                        dia = c.get(Calendar.DATE) +1 ;
                    }

                }
                out.print("<event id='"+hr.getIdhorario()+"'>");
                out.print("<start_date><![CDATA["+((fecha.getYear()+1900)+"-"+(fecha.getMonth()+1)+"-"+dia+" "+hr.getHorainicio().getHours()+":"+hr.getHorainicio().getMinutes()+":"+hr.getHorainicio().getSeconds()+"]]></start_date>"));
                out.print("<end_date><![CDATA["+((fecha.getYear()+1900)+"-"+(fecha.getMonth()+1)+"-"+dia+" "+hr.getHorafin().getHours()+":"+hr.getHorafin().getMinutes()+":"+hr.getHorafin().getSeconds()+"]]></end_date>"));
                out.print("<text><![CDATA["+hr.getIdcurso().getIdmateria().getNombre()+" "+hr.getIdcurso().getNombre()+"]]></text>");
                out.print("<details><![CDATA["+hr.getIdaula().getNombre()+"]]></details>");
                out.print("</event>");
            }
            out.print("</data>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
