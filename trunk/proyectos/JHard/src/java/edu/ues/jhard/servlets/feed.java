package edu.ues.jhard.servlets;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;
import edu.ues.jhard.beans.BeanBaseConfig;
import edu.ues.jhard.beans.BeanBaseJProcur;
import edu.ues.jhard.beans.BeanBaseJWiki;
import edu.ues.jhard.jpa.Articulos;
import edu.ues.jhard.jpa.Entrada;
import edu.ues.jhard.util.Redireccion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet con funcionalidad para generar suscripciones ATOM al wiki y al cms de jhard.
 * @author rodrigo
 */
public class feed extends HttpServlet {
    private static final int JWIKI = 1;
    private static final int JPROCUR = 2;
    private static final String DEFAULT_FEED_TYPE = "default.feed.type";
    private static final String ATOM = "atom_0.3";
    private static final String FEED_TYPE = "type";
    private static final String OPCION = "opt";
    private static final String MIME_TYPE = "application/xml;charset=UTF-8"; //mime o content type
    private static final String COULD_NOT_GENERATE_FEED_ERROR = "No pude generar los datos para la suscripción";
    private static final int MAX_FEED_ITEMS = 10;

    private String FEED_SITE_LINK = "";

    private String defaultFeedType;

    private BeanBaseJWiki jwikiInstance = new BeanBaseJWiki();
    private BeanBaseJProcur jprocurInstance = new BeanBaseJProcur();

    private List<Articulos> listaArticulos = new ArrayList<Articulos>();
    private List<Entrada> listaEntradas = new ArrayList<Entrada>();

    private static Date ultimaActualizacion;
    private int MINUTOS_ACTUALIZAR;

    public  BeanBaseJWiki getJWikiInstance() {
        return this.jwikiInstance;
    }

    public  BeanBaseJProcur getJProcurInstance() {
        return this.jprocurInstance;
    }

    @Override
    public void init() {
        defaultFeedType = getServletConfig().getInitParameter(DEFAULT_FEED_TYPE);
        defaultFeedType = (defaultFeedType!=null) ? defaultFeedType : ATOM;
        iniciar();
    }

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
        doPost(request, response);
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
        Integer opt = new Integer(-1);
        try {
            String opcion = request.getParameter(OPCION);

            SyndFeed feed;

            if(opcion!=null) opt = Integer.parseInt(opcion);
            switch (opt){
                case JWIKI:
                    feed = getFeedEntradas(request);
                    break;
                case JPROCUR:
                    feed = getFeedArticulos(request);
                    break;
                default:
                    throw new FeedException(COULD_NOT_GENERATE_FEED_ERROR);
            }

            String feedType = request.getParameter(FEED_TYPE);
            feedType = (feedType!=null) ? feedType : defaultFeedType;
            feed.setFeedType(feedType);

            response.setContentType(MIME_TYPE);
            SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed,response.getWriter());
        } catch (FeedException ex) {
            String msg = COULD_NOT_GENERATE_FEED_ERROR;
            log(msg,ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,msg);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet generador de sindicación (ATOM/RSS Feeds) para jHard.";
    }

    protected SyndFeed getFeedArticulos(HttpServletRequest req) throws IOException,FeedException {
        SyndFeed feed = new SyndFeedImpl();

        feed.setTitle("Artículos Laboratorio Hardware");
        feed.setLink(FEED_SITE_LINK); //TODO: cambiar.
        feed.setDescription("Suscribete al wiki del Laboratorio de Hardware, se muestran los últimos 10 artículos.");

        List entrys = new ArrayList();
        SyndEntry entry;
        SyndContent description;

        entry = new SyndEntryImpl();

        if(this.puedoActualizar()) actualizar();

        for (Articulos a : this.listaArticulos) {
            entry.setTitle(a.getTitulo());
            entry.setLink(Redireccion.PAG_WIKI+"?wkid="+a.getIdarticulo());
            entry.setPublishedDate(a.getFechahora());
            description = new SyndContentImpl();
            description.setType("text/plain");
            description.setValue(a.getDescripcion());
            entry.setAuthor(a.getIdusuario().getNombre());
            entry.setDescription(description);
            entrys.add(entry);
        }
        feed.setEntries(entrys);

        return feed;
    }

    protected SyndFeed getFeedEntradas(HttpServletRequest req) throws IOException,FeedException {
        SyndFeed feed = new SyndFeedImpl();

        feed.setTitle("Entradas Laboratorio Hardware");
        feed.setLink(FEED_SITE_LINK);
        feed.setDescription("Suscribete a la promoción de cursos del Laboratorio de Hardware, se muestran las 10 entradas.");

        List entrys = new ArrayList();
        SyndEntry entry;
        SyndContent description;

        entry = new SyndEntryImpl();

        if(this.puedoActualizar()) actualizar();

        for (Entrada e : this.listaEntradas) {
            entry.setTitle(e.getTitulo());
            entry.setLink(Redireccion.PAG_PROC+"?artid="+e.getIdentrada());
            entry.setPublishedDate(e.getFechahora());
            description = new SyndContentImpl();
            description.setType("text/plain");
            description.setValue(e.getDescripcion());
            entry.setAuthor(e.getIdusuario().getNombre());
            entry.setDescription(description);
            entrys.add(entry);
        }
        feed.setEntries(entrys);

        return feed;
    }

    private void iniciar(){
        try {
            actualizar();

            BeanBaseConfig.recargaConfiguracion();
            FEED_SITE_LINK = BeanBaseConfig.getValor("url");
            MINUTOS_ACTUALIZAR = Integer.parseInt(BeanBaseConfig.getValor("actualizaFeed"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void actualizar() {
        this.listaArticulos = this.getJWikiInstance().getUltimosNArticulos(MAX_FEED_ITEMS);
        this.listaEntradas = this.getJProcurInstance().getUltimasNEntradas(MAX_FEED_ITEMS);
        feed.ultimaActualizacion = new Date();            
        System.out.println("(FEED Servlet) Se recargo la lista de articulos y entradas.");
    }

    private boolean puedoActualizar(){
      Long miliultima = feed.ultimaActualizacion.getTime() + (MINUTOS_ACTUALIZAR * 60 * 1000);
      Date haceTantosMinutos = new Date(miliultima);
      Date instante = new Date();
      if (instante.compareTo(haceTantosMinutos)>0){ //pasaron n minutos...
        actualizar();
        return true;
      }
      return false;
    }

}
