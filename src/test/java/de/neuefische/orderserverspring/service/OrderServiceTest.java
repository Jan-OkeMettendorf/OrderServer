package de.neuefische.orderserverspring.service;

import de.neuefische.orderserverspring.Repo.OrderRepo;
import de.neuefische.orderserverspring.Repo.ProductRepo;
import de.neuefische.orderserverspring.model.Order;
import de.neuefische.orderserverspring.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    @DisplayName("Test method for listing all orders")
    public void testList(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1, "Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));
        OrderRepo orderRepo = new OrderRepo();
        OrderService orderService = new OrderService(orderRepo, productRepo);
        orderService.addOrder(List.of(
                1,
                2,
                3
        ));
        //WHEN
        List<Order> actual = orderService.list();
        List<Order> expected = new ArrayList<>(List.of(
                new Order(1,List.of(
                        new Product(1,"Roibois"),
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                ))
        ));
        //THEN
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test method for adding new orders")
    public void testAddNewOrder(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1, "Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));
        OrderRepo orderRepo = new OrderRepo();
        OrderService orderService = new OrderService(orderRepo, productRepo);
        orderService.addOrder(List.of(
                1,
                2,
                3
        ));
        orderService.addOrder(List.of(
                1,
                3
        ));
        //WHEN
        List<Order> actual = orderService.list();
        List<Order> expected = new ArrayList<>(List.of(
                new Order(1,List.of(
                        new Product(1,"Roibois"),
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                )),
                new Order(2,List.of(
                        new Product(1,"Roibois"),
                        new Product(3,"Grey")
                ))
        ));
        //THEN
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test method for adding unknown product")
    public void testAddNewOrderUnknownProduct(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1, "Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));
        OrderRepo orderRepo = new OrderRepo();
        OrderService orderService = new OrderService(orderRepo, productRepo);

        try {
            //WHEN
            orderService.addOrder(List.of(
                    1,
                    2,
                    4
            ));
        } catch (IllegalArgumentException e){
            String actual = e.getMessage();
            String expected = "Product not found by ID: 4";
            //THEN
            assertEquals(expected,actual);
        }
    }

}