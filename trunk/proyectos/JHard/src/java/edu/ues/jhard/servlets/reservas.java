/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.servlets;

import edu.ues.jhard.beans.BeanBaseJCanon;
import edu.ues.jhard.jpa.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para obtener todas las reservas pendientes y en uso de equipo multimedia y transformarlas a
 * un XML que pueda leer y consumir el DHTMLXScheduler para mostrar eventos
 * @author Hugol
 */
public class reservas extends HttpServlet {
   
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

        BeanBaseJCanon instance = new BeanBaseJCanon();
        Reserva [] reservas = instance.getReservaByEstado(1);

        try {
            out.print("<?xml version='1.0' encoding='ISO-8859-1'?><data>");
            for (int i = 0; i < reservas.length; i++) {
                out.print("<event id='"+reservas[i].getIdreserva()+"'>");
                out.print("<start_date><![CDATA["+(reservas[i].getFechahorainicioprestamo().getYear()+1900)+"-"+(reservas[i].getFechahorainicioprestamo().getMonth()+1)+"-"+reservas[i].getFechahorainicioprestamo().getDate()+" "+reservas[i].getFechahorainicioprestamo().getHours()+":"+reservas[i].getFechahorainicioprestamo().getMinutes()+":"+reservas[i].getFechahorainicioprestamo().getSeconds()+"]]></start_date>");
                out.print("<end_date><![CDATA["+(reservas[i].getFechahorafinprestamo().getYear()+1900)+"-"+(reservas[i].getFechahorafinprestamo().getMonth()+1)+"-"+reservas[i].getFechahorafinprestamo().getDate()+" "+reservas[i].getFechahorafinprestamo().getHours()+":"+reservas[i].getFechahorafinprestamo().getMinutes()+":"+reservas[i].getFechahorafinprestamo().getSeconds()+"]]></end_date>");
                out.print("<text><![CDATA["+reservas[i].getDescripcion()+"]]></text>");
                out.print("<details><![CDATA[Docente encargado: "+reservas[i].getIddocente().getNombres()+" "+reservas[i].getIddocente().getApellidos()+"]]></details>");
                out.print("</event>");
            }
            out.print("</data>");
        } finally {
            out.flush();
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
