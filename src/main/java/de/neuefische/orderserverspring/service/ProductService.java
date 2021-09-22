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
    private final ProductRepo productRepo;

    //constructors
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //methods

    public Product getProductById(int id){
        if(productRepo.getProductById(id).isPresent()) {
            return productRepo.getProductById(id).get();
        } else {
            throw new IllegalArgumentException("Product not found by ID: " + id);
        }
    }

    public List<Product> list(){
        return productRepo.list();
    }

    public Product getProductByName(String productName){
        if(productRepo.getProductByName(productName).isPresent()){
            return productRepo.getProductByName(productName).get();
        } else {
            throw new IllegalArgumentException("Product not found by name: " + productName);
        }
    }

    //getter/setter

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public Product addProduct(Product product){
        productRepo.addNewProduct(product);
        return product;
    }

    //equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductService that = (ProductService) o;
        return Objects.equals(productRepo, that.productRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo);
    }

    // toString

    @Override
    public String toString() {
        return "ProductService{" +
                "productRepo=" + productRepo +
                '}';
    }
}
