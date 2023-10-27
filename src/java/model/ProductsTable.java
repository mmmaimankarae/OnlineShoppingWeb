package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductsTable {
    
    public static List<Products> findAllProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        List<Products>proList = null;
        try {
            proList = (List<Products>) em.createNamedQuery("Products.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return proList;
    }
    
    public static Products findProductByMovieId(int movieId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        Products products = null;
        try {
            Query query = em.createNamedQuery("Products.findById");
            query.setParameter("id", movieId);
            products = (Products) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return products;
    }
    
        public static Products findProductByMovieName(String movie) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        Products products = null;
        try {
            Query query = em.createNamedQuery("Products.findByMovie");
            query.setParameter("movie", movie);
            products = (Products) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return products;
    } 
}
