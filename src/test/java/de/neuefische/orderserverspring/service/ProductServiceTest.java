package de.neuefische.orderserverspring.service;

import de.neuefische.orderserverspring.Repo.ProductRepo;
import de.neuefische.orderserverspring.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    @DisplayName("Test method whether product is available based on the id")
    public void testGetProductById(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1,"Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));
        ProductService productService = new ProductService(productRepo);

        //WHEN
        Product actual = productService.getProductById(3);
        Product expected = new Product(3,"Grey");

        //THEN
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test method whetsher product is available based on the id")
    public void testGetProductByIdFalse(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1,"Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));
        ProductService productService = new ProductService(productRepo);

        //WHEN
        try {
            productService.getProductById(4);
        } catch(IllegalArgumentException e) {
            String actual = e.getMessage();
            String expected = "Product not found by ID: 4";
            //THEN
            assertEquals(expected,actual);
        }


    }
    @Test
    @DisplayName("Tests whether all products from the list are displayed")
    public void testList(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1,"Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));
        ProductService productService = new ProductService(productRepo);
        //WHEN
        List<Product> actual = productService.list();
        List<Product> expected = new ArrayList<>(List.of(
                new Product(1,"Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));

        //THEN
        assertEquals(expected, actual);


    }
}