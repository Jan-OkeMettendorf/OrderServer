package de.neuefische.orderserverspring.service;

import de.neuefische.orderserverspring.Repo.ProductRepo;
import de.neuefische.orderserverspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    // variables
    private final ProductRepo productService;

    //constructors
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productService = productRepo;
    }

    //methods

    public Product getProduct(int id){
        if(productService.getProductById(id).isPresent()) {
            return productService.getProductById(id).get();
        } else {
            throw new IllegalArgumentException("Product not found by ID: " + id);
        }
    }

    public List<Product> list(){
        return productService.list();
    }

    //getter/setter

    public ProductRepo getProductService() {
        return productService;
    }

    //equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductService that = (ProductService) o;
        return Objects.equals(productService, that.productService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productService);
    }

    // toString

    @Override
    public String toString() {
        return "ProductService{" +
                "productRepo=" + productService +
                '}';
    }
}
