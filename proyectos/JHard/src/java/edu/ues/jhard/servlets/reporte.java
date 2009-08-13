/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ues.jhard.servlets;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.toplink.essentials.sessions.DatabaseLogin;

/**
 *
 * @author rodrigo
 */
public class reporte extends HttpServlet {

    public static final int ID_LABSBYCARRERA = 1;
    public static final String RUTA_LABSBYCARRERA = "labsByCarrera.jasper";

    public static final String IDCARRERA = "idcarrera";

    public static final int ID_EQSIMPLE = 2;
    public static final String RUTA_EQSIMPLE = "bitacoraEqSimple.jasper";

    public static final String IDEQSIMPLE = "ideqsimple";

    public static final int ID_EXISTENCIA = 3;
    public static final String RUTA_EXISTENCIA = "bitacorasExistencia.jasper";

    public static final String IDEXISTENCIA = "idexistencia";

    public static final int ID_RESERVAFECHA = 4;
    public static final String RUTA_RESERVAFECHA = "reservasByFechas.jasper";

    public static final String IDRESERVAFECHAINICIAL = "fechaInicial";
    public static final String IDRESERVAFECHAFINAL = "fechaFinal";

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
                    //rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_LABSBYCARRERA);
                    rutareal = RUTA_REPORTES + RUTA_LABSBYCARRERA;
                    //Asignamos el nombre al PDF
                    nombreReporte = "LaboratoriosPorCarrera";
                    break;
               case ID_EQSIMPLE: //2
                    //Obtenemos los parametros necesarios para este reporte

                    Integer ideqsimple = Integer.parseInt(request.getParameter(IDEQSIMPLE));

                   //Asignamos los parametros al mapa
                    parametros.put(IDEQSIMPLE, ideqsimple);
                    //Generamos la ruta real del archivo jrxml
                    //rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_EQSIMPLE);
                    rutareal = RUTA_REPORTES + RUTA_EQSIMPLE;
                    //Asignamos el nombre al PDF
                    nombreReporte = "bitacoraEqSimple.jasper";

                    break;
               case ID_EXISTENCIA: //3
                    //Obtenemos los parametros necesarios para este reporte
                    
                   Integer idexistencia = Integer.parseInt(request.getParameter(IDEXISTENCIA));

                   //Asignamos los parametros al mapa
                    parametros.put(IDEXISTENCIA, idexistencia);
                    //Generamos la ruta real del archivo jrxml
                    //rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_EXISTENCIA);
                    rutareal = RUTA_REPORTES + RUTA_EXISTENCIA;
                    //Asignamos el nombre al PDF
                    nombreReporte = "bitacorasExistencia.jasper";
                    break;
               case ID_RESERVAFECHA: //4
                    //Obtenemos los parametros necesarios para este reporte

                    Integer diaI = Integer.parseInt(request.getParameter("diaI"));
                    Integer mesI = Integer.parseInt(request.getParameter("mesI"));
                    Integer anioI = Integer.parseInt(request.getParameter("anioI"));
                    Integer diaF = Integer.parseInt(request.getParameter("diaF"));
                    Integer mesF = Integer.parseInt(request.getParameter("mesF"));
                    Integer anioF = Integer.parseInt(request.getParameter("anioF"));

                    Date INICIAL = new Date(diaI, mesI, anioI);
                    Date FINAL = new Date(diaF, mesF, anioF);

                    //Asignamos los parametros al mapa
                    parametros.put(IDRESERVAFECHAINICIAL, INICIAL);
                    parametros.put(IDRESERVAFECHAFINAL, FINAL);
                    //Generamos la ruta real del archivo jrxml
                    //rutareal = contexto.getRealPath(RUTA_REPORTES + RUTA_RESERVAFECHA);
                    rutareal = RUTA_REPORTES + RUTA_RESERVAFECHA;
                    //Asignamos el nombre al PDF
                    nombreReporte = "BitacoraExistencia";
                    break;

                //TODO: agregar los otros reportes
                default:
                    throw new Exception("(reporte Servlet): No coincide el parametro con las opciones existentes.");
            }
            //creamos el handler para el archivo
           // File archivoReporte = new File(rutareal);


            System.out.println("LA RUTA-->"+rutareal);

            System.out.println("A generar reporte");
            //Generamos el reporte :) //AQUI OCURRE LA MAGIA
            generarReporte(request, response, rutareal, parametros, nombreReporte);
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
    protected void generarReporte(HttpServletRequest request, HttpServletResponse response, String reporte, Map parametros, String nombreReporte)
            throws ServletException, IOException {
        try {
//            ServletOutputStream outputstream = null;
//            outputstream = response.getOutputStream();

            response.setContentType("text/html; charset=iso-8859-1");
            response.setHeader("Content-disposition", "filename=" + nombreReporte + ".pdf");
            response.setHeader("Cache-Control", "no-cache");

                //JasperDesign jasperDesign = JRXmlLoader.load(reporte);
                //JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

                System.out.println("AQUI CREO EL REPORTE");
                JasperReport report = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath(reporte));
                System.out.println("HAGO LA IMPRESION");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, this.conexionJdbc);

                System.out.println("HAGO EL EXPORTADOR");

                net.sf.jasperreports.view.JasperViewer jv = new net.sf.jasperreports.view.JasperViewer(jasperPrint, false);
                jv.setVisible(true);

//                JRExporter exporter = null;
//
//                exporter = new JRPdfExporter();
//                System.out.println("PARAMETRO");
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//                System.out.println("PARAMETRO");
//                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getWriter());
//                System.out.println("EXPORTO...");
//                exporter.exportReport();

//                JRHtmlExporter exporter = new JRHtmlExporter();
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//
//                exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//
//        		exporter.exportReport();

		/*
                JRPdfExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputstream);
                exporter.exportReport();*/


        } catch (JRException jre) {
            System.out.println("(reporte Servlet): Ocurrio un error al intentar generar el reporte.");
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
