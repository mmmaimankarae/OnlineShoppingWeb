package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SHOPPINGCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findByCartId", query = "SELECT s FROM Shoppingcart s WHERE s.shoppingcartPK.cartId = :cartId"),
    @NamedQuery(name = "Shoppingcart.findByMovieId", query = "SELECT s FROM Shoppingcart s WHERE s.shoppingcartPK.movieId = :movieId"),
    @NamedQuery(name = "Shoppingcart.findByQuantity", query = "SELECT s FROM Shoppingcart s WHERE s.quantity = :quantity")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShoppingcartPK shoppingcartPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public Shoppingcart() {
    }

    public Shoppingcart(ShoppingcartPK shoppingcartPK) {
        this.shoppingcartPK = shoppingcartPK;
    }

    public Shoppingcart(int cartId, int movieId) {
        this.shoppingcartPK = new ShoppingcartPK(cartId, movieId);
    }

    public ShoppingcartPK getShoppingcartPK() {
        return shoppingcartPK;
    }

    public void setShoppingcartPK(ShoppingcartPK shoppingcartPK) {
        this.shoppingcartPK = shoppingcartPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingcartPK != null ? shoppingcartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.shoppingcartPK == null && other.shoppingcartPK != null) || (this.shoppingcartPK != null && !this.shoppingcartPK.equals(other.shoppingcartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoppingcart[ shoppingcartPK=" + shoppingcartPK + " ]";
    }
}
