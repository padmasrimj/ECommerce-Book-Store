package com.java.Client;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.java.Bean.*;

public class TestClientProduct {
		 
    public static void main(String[] args) {
    	deleteProduct();
    	//sayhello();
    	//addProduct();
    	getProductList();
    	
    }

    
    public static void getProductList(){
    	ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        Client c = Client.create(config);
        WebResource resource = c.resource("http://localhost:8080/EcommerceBookStore/rest/product/display");
        
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
     // check response status code
        if (response.getStatus() == 200 || response.getStatus() == 201) {
        	List<ProductBean> products = response.getEntity(new GenericType<List<ProductBean>>(){});
            StringBuilder builder = new StringBuilder("=== Accounts ===\n");
            for (ProductBean product: products) {
                builder.append("Price: ").append(product.getProductPrice()).append(", ")
                        .append("Name: ").append(product.getProductName()).append("\n");          
            }
            builder.append("==================");
            System.out.println(builder.toString());
        } else {
        	throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

    }
    
    public static void sayhello() {
    	Client c = Client.create();
		WebResource r = c.resource("http://localhost:8080/EcommerceBookStore/rest/product/hello");
		ClientResponse response = r.type(MediaType.TEXT_PLAIN).get(ClientResponse.class);
 
        // check response status code
        if (response.getStatus() == 200) {
            System.out.println(response.getEntity(new GenericType<String>(){}));
        } else {
        	throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
 
	}

	public static void addProduct(){
        String input = "{\"productCategory\":\"212\",\"productName\":\"Atish M\",\"productPrice\":\"23.00\"}";
        Client c  = Client.create();
        WebResource resource = c.resource("http://localhost:8080/EcommerceBookStore/rest/product/create");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
 
        // check response status code
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }      
        System.out.println(response);
    }
	
    
    public static void deleteProduct(){
        Client c  = Client.create();
        WebResource resource = c.resource("http://localhost:8080/EcommerceBookStore/rest/product/delete/3");
        ClientResponse response = resource
                .type("text/html").delete(ClientResponse.class);
        System.out.println(response);
    }
	 
}
