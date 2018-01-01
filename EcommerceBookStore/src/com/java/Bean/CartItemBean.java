package com.java.Bean;

import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.io.Serializable;
import com.java.Bean.*;

@Entity
@Table(name = "CartItem")
public class CartItemBean implements Serializable {

    //private static final long serialVersionUID = -904360230041854157L;

    @Id
    @Column(name = "CartItem_ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;
        
    @Column(name = "CartItem_quantity",nullable = true)
    private int quantity;
    
    @Column(name = "CartItem_totalPrice",nullable = true)
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "Cart_ID")
    @JsonIgnore
    private CartBean cart;

    
    @OneToOne
    @JoinColumn(name = "BIDID")
    private BidingDetailsBean biddingDetails;

    
    
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public CartBean getCart() {
        return cart;
    }

    public void setCart(CartBean cart) {
        this.cart = cart;
    }

    public BidingDetailsBean getbiddingDetails() {
        return biddingDetails;
    }

    public void setbiddingDetails(BidingDetailsBean biddingDetails) {
        this.biddingDetails = biddingDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
    	totalPrice = quantity * biddingDetails.getPrice();
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
//    	totalPrice = quantity * product.getProductPrice();
        this.totalPrice = totalPrice;
    }
    
} // The End of Class;


