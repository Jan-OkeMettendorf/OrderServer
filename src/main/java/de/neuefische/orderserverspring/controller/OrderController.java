package de.neuefische.orderserverspring.controller;

import de.neuefische.orderserverspring.model.Order;
import de.neuefische.orderserverspring.model.Product;
import de.neuefische.orderserverspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("order")
public class OrderController {

    //variables
    private final OrderService orderService;

    //constructors
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //methods
    @PostMapping
    public Order newOrder(@RequestBody List<Integer> product){
        return orderService.addOrder(product);
    }

    @GetMapping
    public List<Order> list(){
        return orderService.list();
    }

    //getter/setter
    public OrderService getOrderService() {
        return orderService;
    }

    //equals/hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderController that = (OrderController) o;
        return Objects.equals(orderService, that.orderService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderService);
    }

    //toString
    @Override
    public String toString() {
        return "OrderController{" +
                "orderService=" + orderService +
                '}';
    }
}
