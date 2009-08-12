/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ues.jhard.servlets;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.toplink.essentials.sessions.DatabaseLogin;

/**
 *
 * @author rodrigo
 */
public class reporte extends HttpServlet {

    public static final int ID_LABSBYCARRERA = 1;
    public static final String RUTA_LABSBYCARRERA = "labsByCarrera.jrxml";

    public static final String IDCARRERA = "idcarrera";

    public static final int ID_EQSIMPLE = 2;
    public static final String RUTA_EQSIMPLE = "bitacoraEqSimple.jrxml";

    public static final String IDEQSIMPLE = "ideqsimple";

    public static final int ID_EXISTENCIA = 3;
    public static final String RUTA_EXISTENCIA = "bitacorasExistencia.jrxml";

    public static final String IDEXISTENCIA = "idexistencia";

    public static final String RUTA_REPORTES = "/reportes/";
    public static final String PARAM_VAR = "rpid";
    
    private static final String PDF_TYPE = "application/pdf";
    private static final String EMPTY_STRING = "";
    private static final int NONE = 0;

    private EntityManagerFactory emf;
    private Connection conexionJdbc = null;

    /**
     * Metodo para obtener el EntityManager
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        if (this.emf == null) {
            this.emf = Persistence.createEntityManagerFactory("JHardPU");
        }
        return emf.createEntityManager();
    }

    @Override
    public void init() {
        //Este truco es para obtener el jndi de la PU...
        //parece repetitivo, pero no es asi... NO CAMBIAR
        EntityManager em = this.getEntityManager();
        oracle.toplink.essentials.ejb.cmp3.EntityManager emm = (oracle.toplink.essentials.ejb.cmp3.EntityManager) em.getDelegate();
        DatabaseLogin login = emm.getServerSession().getLogin();
        conexionJdbc = (Connection) login.connectToDatasource(null);
    }

    /** 
     * Procesa las peticiones, se invoca en cada HTTP <code>GET</code> y <code>POST</code>.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //AQUI EMPIEZA LA MAGIA
        Integer rpid = NONE;
        File archivoReporte = null;
        ServletContext contexto = request.getSession().getServletContext();
        Map parametros = new HashMap(); //mapa con los parametros para el reporte
        String rutareal = EMPTY_STRING;
        String nombreReporte = EMPTY_STRING;

        try {
            System.out.println("Empieza...");
            //Obtenemos el parametro que idenficia al reporte "rpid=1"
            String parametro = request.getParameter(PARAM_VAR); //identificador del archivoReporte
            if (rpid != null) rpid = Integer.parseInt(parametro);
            System.out.println("EL REPORTE CON CODIGO " + rpid);
            //AQUI SE SELECCIONA LA MAGIA
            switch (rpid) {
                case ID_LABSBYCARRERA: //1
                    //Obtenemos los parametros necesarios para este reporte
                    Integer idcarrera = Integer.parseInt(request.getParameter(IDCARRERA));
                    //Asignamos los parametros al mapa
                    parametros.put(IDCARRERA, idcarrera);
                    //Generamos la ruta real del archivo jrxml
                    rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_LABSBYCARRERA);
                    //Asignamos el nombre al PDF
                    nombreReporte = "LaboratoriosPorCarrera";
                    break;
               case ID_EQSIMPLE: //2
                    //Obtenemos los parametros necesarios para este reporte

                    //Integer ideqsimple = Integer.parseInt(request.getParameter(IDEQSIMPLE));

                   //Asignamos los parametros al mapa
                    parametros.put(IDEQSIMPLE, 2);
                    //Generamos la ruta real del archivo jrxml
                    rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_EQSIMPLE);
                    //Asignamos el nombre al PDF
                    nombreReporte = "BitacoraEqSimple";

                    break;
               case ID_EXISTENCIA: //3
                    //Obtenemos los parametros necesarios para este reporte
                    
                   //Integer idexistencia = Integer.parseInt(request.getParameter(IDEXISTENCIA));

                   //Asignamos los parametros al mapa
                    parametros.put(IDEXISTENCIA, 3);
                    //Generamos la ruta real del archivo jrxml
                    rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_EXISTENCIA);
                    //Asignamos el nombre al PDF
                    nombreReporte = "BitacoraExistencia";
                    break;

                //TODO: agregar los otros reportes
                default:
                    throw new Exception("(reporte Servlet): No coincide el parametro con las opciones existentes.");
            }
            //creamos el handler para el archivo
            archivoReporte = new File(rutareal);
            System.out.println(archivoReporte);
            System.out.println("LA RUTA-->"+rutareal);
            System.out.println("A generar reporte");
            //Generamos el reporte :) //AQUI OCURRE LA MAGIA
            generarReporte(request, response, archivoReporte, parametros, nombreReporte);
            System.out.println("Reporte generado!");

        } catch (Exception e) {
            System.out.println("(reporte Servlet): Ocurrio un error inesperado.");
            e.printStackTrace();
            //System.out.println();
        }
    }

    /**
     * Metodo para generar el reporte como un archivo PDF
     * @param request
     * @param response
     * @param reporte
     * @param parametros
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void generarReporte(HttpServletRequest request, HttpServletResponse response, File reporte, Map parametros, String nombreReporte)
            throws ServletException, IOException {
        try {
            ServletOutputStream outputstream = null;
            outputstream = response.getOutputStream();
            System.out.println("iniciando...");
            response.setContentType(PDF_TYPE);
            response.setHeader("Content-disposition", "filename=" + nombreReporte + ".pdf");
            response.setHeader("Cache-Control", "no-cache");

            synchronized (reporte.class) { //just in case...
                System.out.println("cargo el file reporte");
                JasperDesign jasperDesign = JRXmlLoader.load(reporte);
                System.out.println("compilo el reporte");
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                System.out.println("hago el print");
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, this.conexionJdbc);
                System.out.println("hago el exporter");
                JRPdfExporter exporter = new JRPdfExporter();
                System.out.println("coloco parametros");
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                System.out.println("coloco parametros");
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputstream);
                System.out.println("exporto");
                exporter.exportReport();
                System.out.println("it's done!");
            }

        } catch (JRException jre) {
            System.out.println("(reporte Servlet): Ocurrio un error al intentar generar el reporte.");
            System.out.println(jre.getMessage());
            jre.printStackTrace();
        } finally {
            //...
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
        return "Servlet invocador de reportes para jHard.";
    }// </editor-fold>
}
