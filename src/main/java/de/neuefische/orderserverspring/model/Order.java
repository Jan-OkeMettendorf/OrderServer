package de.neuefische.orderserverspring.model;

import java.util.List;
import java.util.Objects;

public class Order {

    // variables

    private  int orderNumber;
    private  List<Product> products;

    // constructors

    public Order(int orderNumber, List<Product> products) {
        this.orderNumber = orderNumber;
        this.products = products;
    }
    public Order(List<Product> products){

    }


    // getter/setter


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, products);
    }

    // toString


    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", products=" + products +
                '}';
    }
}
