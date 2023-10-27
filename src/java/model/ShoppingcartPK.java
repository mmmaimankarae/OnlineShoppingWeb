package model;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShoppingcartPK implements Serializable {
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CART_ID")
    private int cartId;
    @Basic(optional = false)
    @Column(name = "MOVIE_ID")
    private int movieId;

    public ShoppingcartPK() {
    }

    public ShoppingcartPK(int cartId, int movieId) {
        this.cartId = cartId;
        this.movieId = movieId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cartId;
        hash += (int) movieId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ShoppingcartPK)) {
            return false;
        }
        ShoppingcartPK other = (ShoppingcartPK) object;
        if (this.cartId != other.cartId) {
            return false;
        }
        if (this.movieId != other.movieId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ShoppingcartPK[ cartId=" + cartId + ", movieId=" + movieId + " ]";
    }
    
}
