package de.neuefische.orderserverspring.model;

import java.util.List;
import java.util.Objects;

public class Product {

    // variables

    private int productId;
    private String productName;
//
//    Product product1 = new Product(1, "Roibois");
//    Product product2 = new Product(2, "Vanilla");
//    Product product3 = new Product(1, "Grey");

    // constructors

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }


    // getter/setter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName);
    }

    // toString

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
