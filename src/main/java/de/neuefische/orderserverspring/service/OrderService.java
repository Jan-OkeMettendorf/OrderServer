package de.neuefische.orderserverspring.service;

import de.neuefische.orderserverspring.Repo.OrderRepo;
import de.neuefische.orderserverspring.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderService {

    //methods
    private final OrderRepo orderService;
    private final ProductRepo productService;

    //constructors

//    @Autowired
//    public OrderService(OrderRepo orderService) {
//        this.orderService = orderService;
//    }

    @Autowired
    public OrderService(OrderRepo orderService, ProductRepo productService){
        this.orderService = orderService;
        this.productService = productService;
    }

    //methods



    //getter/setter

    public OrderRepo getOrderService() {
        return orderService;
    }

    //equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderService that = (OrderService) o;
        return Objects.equals(orderService, that.orderService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderService);
    }

    //toString

    @Override
    public String toString() {
        return "OrderService{" +
                "orderService=" + orderService +
                '}';
    }
}
