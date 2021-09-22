package de.neuefische.orderserverspring.controller;

import de.neuefische.orderserverspring.Repo.ProductRepo;
import de.neuefische.orderserverspring.model.Product;
import de.neuefische.orderserverspring.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Test
    @DisplayName("tests the addition of a new product")
    public void testAddNewProduct(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        ProductService productService = new ProductService(productRepo);
        ProductController productController = new ProductController(productService);
        productController.addNewProduct(new Product(1,"Roibos"));
        productController.addNewProduct(new Product(2,"Vanilla"));
        productController.addNewProduct(new Product(3,"Grey"));

        //WHEN
        productController.addNewProduct(new Product(4,"Elderberry"));
        List<Product> actual = productController.getProductByName(Optional.empty());
        List<Product> expected = new ArrayList<>(List.of(
                new Product(1,"Roibos"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey"),
                new Product(4,"Elderberry")
        ));

        //THEN

        assertEquals(expected,actual);


    }

}