package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/* JAVA CLASS FOR UPDATE DATA BASE */
public class ShoppingTable {
    
    public static List<Shoppingcart> findAllCART() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> cartList = null;
        try {
            cartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return cartList;
    }
    
    public static ShoppingcartPK findCARTid(int id) {     
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        ShoppingcartPK cartPK = null;
        try {
            Query query = em.createNamedQuery("Shoppingcart.findByCartId");
            query.setParameter("cartId", id);
            List<Shoppingcart> cart = query.getResultList();
            if (!cart.isEmpty()) {
                cartPK = cart.get(0).getShoppingcartPK();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return cartPK;
    }
    
        public static int findLastCART() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> cartList = null;
        int cartId = 0;
        try {
            cartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
            Shoppingcart lastCart = cartList.get(cartList.size() - 1);
            cartId = lastCart.getShoppingcartPK().getCartId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return cartId;
    }
    
    public static List<Shoppingcart> detailOrder(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> cart = null;
        try {
            Query query = em.createNamedQuery("Shoppingcart.findByCartId");
            query.setParameter("cartId", id);
            cart = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return cart;
    }
    
    public static int insertOrder(Shoppingcart cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineWebServicePU");
        EntityManager em = emf.createEntityManager();
        try {
            Shoppingcart target = em.find(Shoppingcart.class, cart.getShoppingcartPK());
            if (target != null) {
                return 0;
            }
            em.persist(cart);
            em.getTransaction().begin();
            em.persist(cart);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
}
