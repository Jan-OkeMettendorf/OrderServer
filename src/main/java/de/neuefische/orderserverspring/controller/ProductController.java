package de.neuefische.orderserverspring.controller;

import de.neuefische.orderserverspring.model.Product;
import de.neuefische.orderserverspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    //variables
    private final ProductService productService;

    //constructors
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //methods

    @GetMapping
    public List<Product> list(){
        return productService.list();
    }

    @PutMapping
    public Product addNewProduct(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

}
