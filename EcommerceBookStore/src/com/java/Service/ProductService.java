package com.java.Service;

import com.java.Bean.ProductBean;
import java.util.List;

import javax.ws.rs.core.Response;

public interface ProductService {

    //List<ProductBean> getProductList();
    Response getProductList();
    ProductBean getProductById (int id);

    Response addProduct(ProductBean product);

    //void editProduct(ProductBean product);

    Response deleteProduct(int productid);

}
