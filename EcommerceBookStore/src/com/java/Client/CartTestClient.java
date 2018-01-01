package com.java.Client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import com.java.Bean.ProductBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class CartTestClient {
 public static void main(String[] args) {
    	//deleteProduct();
    	//sayhello();
    	//addProduct();
    	getProductList();
	
}


public static void getProductList(){
	ClientConfig config = new DefaultClientConfig();
    config.getClasses().add(JacksonJaxbJsonProvider.class);
    config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

    Client c = Client.create(config);
    WebResource resource = c.resource("http://localhost:8080/EcommerceBookStore/rest/cart/100");
    
    ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
 // check response status code
    if (response.getStatus() == 200 || response.getStatus() == 201) {
    	StringBuilder builder = new StringBuilder("=== Cart ===\n");
        
    	/*CartBean cart = response.get
        for (ProductBean product: products) {
            builder.append("Price: ").append(product.getProductPrice()).append(", ")
                    .append("Name: ").append(product.getProductName()).append("\n");          
        }*/
        builder.append("==================");
        System.out.println(builder.toString());
    } else {
    	throw new RuntimeException("Failed : HTTP error code : "
	                    + response.getStatus());
	        }
 }
}
