package de.neuefische.orderserverspring.service;

import de.neuefische.orderserverspring.Repo.OrderRepo;
import de.neuefische.orderserverspring.Repo.ProductRepo;
import de.neuefische.orderserverspring.model.Order;
import de.neuefische.orderserverspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {

    //methods
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    //constructors

    @Autowired
    public OrderService(OrderRepo orderService, ProductRepo productService){
        this.orderRepo = orderService;
        this.productRepo = productService;
    }

    //methods

    public List<Order> list(){
        return orderRepo.list();
    }

    public Product getProductById(int id){
        Optional<Product> product = productRepo.getProductById(id);
        if(product.isPresent()){
            return product.get();
        }
        throw new IllegalArgumentException("Product not found by ID: " + id);
    }

    public Order addOrder(List<Integer> productIds){
        List<Product> newProductList = new ArrayList<>();
        for (int productId : productIds) {
            Product productToAdd = getProductById(productId);
            newProductList.add(productToAdd);
        }
        return orderRepo.addNewOrder(new Order(orderRepo.nextAvailableOrderNumber(),newProductList));
    }


    //getter/setter

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    //equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderService that = (OrderService) o;
        return Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderRepo);
    }

    //toString

    @Override
    public String toString() {
        return "OrderService{" +
                "orderService=" + orderRepo +
                '}';
    }
}
