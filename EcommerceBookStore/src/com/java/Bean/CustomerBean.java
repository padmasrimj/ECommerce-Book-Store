package com.java.Bean;


import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name = "Customer")
public class CustomerBean implements Serializable {
	
	private static final long serialVersionUID = 5140900014886997914L;

    @Id
    @GeneratedValue
    private int cutomerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String username;
    private String password;
    private boolean enabled;


    /*@OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;
	*/
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private CartBean cart;

    public int getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(int cutomerId) {
        this.cutomerId = cutomerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /*public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    */

    public CartBean getCart() {
        return cart;
    }

    public void setCart(CartBean cart) {
        this.cart = cart;
    }
  
} // The End of Class;

