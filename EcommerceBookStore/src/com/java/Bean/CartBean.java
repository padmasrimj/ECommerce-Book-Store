package com.java.Bean;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Cart")
public class CartBean implements Serializable{

   // private static final long serialVersionUID = 3940548625296145582L;

	@Id
    @Column(name = "Cart_ID",nullable = false)
	private int cartId;
	
   /* @OneToOne
    @JoinColumn(name = "Cart_ID")
    @JsonIgnore
    private RegistrationBean register;*/
    
    
    @Column(name = "Cart_TotalPrice",nullable = true)
    private double grandTotal;
     
    @Column(name = "Cart_TotalItems",nullable = true)
    private int totalItems;
 

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItemBean> cartItems;

    /*@OneToOne
    @JoinColumn(name = "Customer_ID")
    @JsonIgnore
    private CustomerBean customer;*/

    
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
	
	/*  public RegistrationBean getCart() {
	        return register;
	    }

	    public void setCart(RegistrationBean register) {
	        this.register = register;
	    }*/

    public List<CartItemBean> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemBean> cartItems) {
        this.cartItems = cartItems;
    }

   /*public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }*/

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

} // The End of Class;

