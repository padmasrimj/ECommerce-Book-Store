package com.java.ServiceImpl;

import com.java.Bean.ProductBean;
import com.java.Dao.ProductDAO;

import com.java.Service.ProductService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
@Path("/product")
public class ProductServiceImpl implements ProductService{

    private ProductDAO productDao;
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductBean product){
    	System.out.println("Inside service impl for create");
    	productDao = new ProductDAO();
        productDao.addProduct(product);
        return Response.ok().build();
    }
    
    @Path("/hello")
    
        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String sayHello() {
            return "Hello Jersey";
    }
        
    
    @GET
    @Path("/display")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductList() {
    	System.out.println("Inside getProductList");
    	productDao = new ProductDAO();
    	List<ProductBean> products = productDao.getProducts();  	
    	
    	/*List<ProductBean> products = new ArrayList<ProductBean>();
    	  products.add(new ProductBean(20.11, "Savings"));
    	  products.add(new ProductBean(10.00, "Checkings"));*/
    	
        GenericEntity generic = new GenericEntity<List<ProductBean>>(products){};
        return Response.status(201).entity(generic).build();
        
    }
    
    @DELETE
    @Path("/remove/{id}")
    @Consumes("text/html")
    public Response deleteProduct(@PathParam("id") int productID){
    	productDao = new ProductDAO();
        int count = productDao.deleteProduct(productID);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
       return Response.ok().build();
    }
    
    public ProductBean getProductById(int productId){
    	productDao = new ProductDAO();
        return productDao.getProductByID(productId);
    }


   
/*
    public void editProduct(ProductBean product){
    	productDao = new ProductDAO();
        productDao.editProduct(product);
    }*/

  


} // The End of Class;
