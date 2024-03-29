package com.neobis.project.kotlinfinal.controllers;

import com.neobis.project.kotlinfinal.models.Product;
import com.neobis.project.kotlinfinal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


//Done
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String defaultProduct() {
        return "Default product endpoint";
    }


    // get product by product_id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") int id) throws Exception {
        return productService.getProductById(id);
    }


    // get products by seller_id
    @RequestMapping(value = "/seller{id}", method = RequestMethod.GET)
    public Product getProductBySellerId(@PathVariable("id") int id) throws Exception {
        return productService.getProductBySellerId(id);
    }

    // update product information
    @RequestMapping(method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }


    // create new product
    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


    // delete product
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteProductById(@PathParam("id") int id) {
        productService.deleteProductById(id);
    }
}