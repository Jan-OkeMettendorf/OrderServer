package de.neuefische.orderserverspring.controller;

import de.neuefische.orderserverspring.model.Product;
import de.neuefische.orderserverspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

//    @GetMapping
//    public List<Product> list(){
//        return productService.list();
//    }

    @PutMapping
    public Product addNewProduct(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

    @GetMapping
    public List<Product> getProductByName(@RequestParam Optional<String> productName){
        if(productName.isPresent()){
            return productService.getProductByName(productName.get());
        }
        return productService.list();
    }

}
