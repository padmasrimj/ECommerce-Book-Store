package com.java.Bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;



@javax.persistence.Entity(name = "product")
@Table(name = "product", uniqueConstraints  = {@UniqueConstraint(columnNames = "Product_ID")})
public class ProductBean implements Serializable{
	
	private static final long serialVersionUID = -2576670215015463100L;
	
    private int productId;
    
    @NotEmpty(message = "The product name must not be empty")  
    private String productName;
    private String productCategory;
    
    @Min(value = 0, message = "The product price must not be less then zero")
    private float productPrice;
    private String productDescription;
    
    /*@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonIgnore
    private List<CartItemBean> cartItemList;*/
    
    
    public ProductBean(){
    	
    }
    public  ProductBean(float productPrice,String productName) {
    	this.productPrice = productPrice;
    	this.productName = productName;
	}
    
    @Id
    @Column(name = "Product_ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
    public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Column(name = "Product_Name",nullable = false)
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "Product_category",nullable = true)
	public String getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	@Column(name = "Product_price", nullable = true)
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	@Column(name = "Product_description", nullable = true)
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	/* public List<CartItemBean> getCartItemList() {
	        return cartItemList;
	 }

    public void setCartItemList(List<CartItemBean> cartItemList) {
        this.cartItemList = cartItemList;
    }*/
    
} // The End of Class;
