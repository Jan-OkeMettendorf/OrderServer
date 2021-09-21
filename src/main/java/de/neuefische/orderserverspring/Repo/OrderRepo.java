package de.neuefische.orderserverspring.Repo;

import de.neuefische.orderserverspring.model.Order;
import de.neuefische.orderserverspring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class OrderRepo {

    // variables

    private List<Order> orderRepo = new ArrayList<>();

    // constructors

    public OrderRepo(List<Order> orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderRepo(){

    }

    // methods

    // Shows the list of all orders

    public List<Order> list(){
        return orderRepo;
    }

    // Outputs an order based on the id

    public Optional<Order> getOrderById(int id){
        for (Order order : orderRepo) {
            if(order.getOrderNumber() == id){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    // Adds a new order with a continuing ID

    public Order addNewOrder(Order newOrder){
        orderRepo.add(newOrder);
        return newOrder;
    }

    public int nextAvailableOrderNumber(){
        return orderRepo.size()+1;
    }

    // getter/setter

    public List<Order> getOrderRepo() {
        return orderRepo;
    }

    public void setOrderRepo(List<Order> orderRepo) {
        this.orderRepo = orderRepo;
    }

    // equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo1 = (OrderRepo) o;
        return Objects.equals(orderRepo, orderRepo1.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderRepo);
    }

    // toString

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orderRepo=" + orderRepo +
                '}';
    }
}
