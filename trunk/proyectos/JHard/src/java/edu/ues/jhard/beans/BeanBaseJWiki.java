package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Articulos;
import java.util.List;
import javax.persistence.*;

/**
 * @author ramayac
 * Notas personales:
 * - Only use EntityManager method persist on a new entity.
 * - Only Refresh para obtener los ultimos datos de la BD
 * - remove to delete an entity from the database.
 * - method flush to send updates to the database within a transaction before the transaction is committed. (unicamente en el mismo contexto)
 */
public class BeanBaseJWiki extends BeanBase {

    /**
     * Metodo para obtener uno o varios objetos Articulos que coincidan con el criterio de busqueda.
     * Este metodo busca sobre el campo titulo de las Articulos.
     */
    public List<Articulos> searchArticuloPorTitulo(String criterio){
        EntityManager em = this.getEntityManager();
        String sql = "SELECT * FROM articulos a WHERE a.titulo LIKE ?0 ORDER BY a.fechahora DESC";
        criterio = "%"+criterio+"%";
        Query q = em.createNativeQuery(sql, Articulos.class);
        q.setParameter(0, criterio);
        List<Articulos> la = q.getResultList();
        return la;
    }


    /**
     * Metodo para obtener uno o varios objetos Articulos que coincidan con el criterio de busqueda.
     * Este metodo busca sobre el campo titulo de las Articulos.
     */
    public List<Articulos> getAllArticulos(){
        EntityManager em = this.getEntityManager();
        String sql = "SELECT * FROM articulos a ORDER BY a.fechahora DESC";
        Query q = em.createNativeQuery(sql, Articulos.class);
        List<Articulos> la = q.getResultList();
        return la;
    }

    /**
     * Metodo para obtener las ultimas N Articulos en jhard.Articulos.
     * @return numero Numero de Articulos que se desean
     */
    public List<Articulos> getUltimosNArticulos(int numero) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT * FROM articulos a ORDER BY a.fechahora DESC";
        Query q = em.createNativeQuery(sql, Articulos.class);
        q.setFirstResult(0);
        q.setMaxResults(numero);
        List<Articulos> la = q.getResultList();
        return la;
    }

    /**
     * Metodo para obtener una Articulos por su ID
     * @param idArticulos id de la entada que se desea
     * @return
     */
    public Articulos getArticulo(int idArticulo) {
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, idArticulo);
        return a;
    }

    /**
     * Metodo para añadir un objeto Articulos
     * @param Articulos
     */
    public boolean createArticulo(Articulos articulo){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(articulo);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Articulos por su ID
     * @param idArticulos
     */
    public void deleteArticulo(int idArticulo) {
        EntityManager em = this.getEntityManager();
        Articulos a = (Articulos)em.find(Articulos.class, idArticulo);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Articulos
     * @param Articulos
     */
    public void deleteArticulo(Articulos articulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, articulo.getIdarticulo());
        if(a==null) return;
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Articulos
     * @param Articulos
     */
    public void updateArticulos(Articulos articulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, articulo.getIdarticulo());
        a = articulo;
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Articulos por demanda, por su ID
     * @param Articulos
     */
    public Articulos recargarArticulos(Integer idArticulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, idArticulo);
        em.getTransaction().begin();
        em.refresh(a);
        em.getTransaction().commit();
        return a;
    }

    /**
     * Metodo para recargar una Articulos por demanda
     * @param Articulos
     */
    public Articulos recargarArticulos(Articulos articulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, articulo.getIdarticulo());
        a = articulo;
        em.getTransaction().begin();
        em.refresh(a);
        em.getTransaction().commit();
        return a;
    }
}
