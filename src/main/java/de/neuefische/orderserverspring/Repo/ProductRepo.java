package de.neuefische.orderserverspring.Repo;

import de.neuefische.orderserverspring.model.Product;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductRepo {

    // variables

    private List<Product> productRepo = new ArrayList<>();

    // constructors

    public ProductRepo(List<Product> products) {
        this.productRepo = products;
    }

    // methods

    // Shows the list of all products

    public List<Product> list(){
        return productRepo;
    }

    // Outputs a product based on the id

    public Optional<Product> getProductById(int id){
        for (Product product : productRepo) {
            if(product.getProductId() == id){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    // Add new Product

    public Product addNewProduct(Product product){
        productRepo.add(product);
        return product;
    }

    // getter/setter

    public List<Product> getProducts() {
        return productRepo;
    }

    public void setProductRepo(List<Product> productRepo) {
        this.productRepo = productRepo;
    }

    // equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productRepo, that.productRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo);
    }


    // toString

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + productRepo +
                '}';
    }
}
