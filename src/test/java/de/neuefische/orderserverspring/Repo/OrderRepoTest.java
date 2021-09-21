package de.neuefische.orderserverspring.Repo;

import de.neuefische.orderserverspring.model.Order;
import de.neuefische.orderserverspring.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    @DisplayName("Tests whether all products from the list are displayed")
    public void list(){
        //GIVEN
        OrderRepo orderRepo = new OrderRepo(List.of(
                new Order(1,List.of(
                        new Product(1,"Roibois"),
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                ))
        ));
        //WHEN
        List<Order> actual = orderRepo.list();
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
    @DisplayName("Tests order list using an ID")
    public void testList(){
        //GIVEN
        OrderRepo orderRepo = new OrderRepo(List.of(
                new Order(1,List.of(
                        new Product(1,"Roibois"),
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                )),
                new Order(2,List.of(
                        new Product(1,"Roibois"),
                        new Product(3,"Grey")
                )),
                new Order(3,List.of(
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                ))
        ));

        //WHEN
        Optional<Order> actual = orderRepo.getOrderById(2);
        Order expected = new Order(2,List.of(
                        new Product(1,"Roibois"),
                        new Product(3,"Grey")
                ));
        assertEquals(Optional.of(expected), actual);

    }

    @Test
    @DisplayName("Tests order list using an ID")
    public void testListOptionalEmpty(){
        //GIVEN
        OrderRepo orderRepo = new OrderRepo(List.of(
                new Order(1,List.of(
                        new Product(1,"Roibois"),
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                )),
                new Order(2,List.of(
                        new Product(1,"Roibois"),
                        new Product(3,"Grey")
                )),
                new Order(3,List.of(
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                ))
        ));

        //WHEN
        Optional<Order> actual = orderRepo.getOrderById(4);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    @DisplayName("Tests adding a new order")
    public void testAddNewOrder(){
        //GIVEN
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.addNewOrder(new Order(1, List.of(
                new Product(1,"Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        )));
        orderRepo.addNewOrder(new Order(2, List.of(
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        )));
        //WHEN
        orderRepo.addNewOrder(new Order(3, List.of(
                new Product(1,"Roibois"),
                new Product(3,"Grey")
        )));

        List<Order> actual = orderRepo.list();
        List<Order> expected = new ArrayList<>(List.of(
                new Order(1,List.of(
                        new Product(1,"Roibois"),
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                )),
                new Order(2,List.of(
                        new Product(2,"Vanilla"),
                        new Product(3,"Grey")
                )),
                new Order(3,List.of(
                        new Product(1,"Roibois"),
                        new Product(3,"Grey")
                ))
        ));

        //THEN
        assertEquals(expected, actual);

    }


}