package de.neuefische.orderserverspring.Repo;

import de.neuefische.orderserverspring.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    @DisplayName("Tests whether all products from the list are displayed")
    public void testList(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
           new Product(1,"Roibois"),
           new Product(2,"Vanilla"),
           new Product(3,"Grey")
        ));

        //WHEN
        List<Product> actual = productRepo.list();
        List<Product> expected = new ArrayList<>(List.of(
                new Product(1,"Roibois"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));

        //THEN
        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Tests whether a product is displayed using an ID")
    public void testGetProductById(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1,"Roibos"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));

        //WHEN
        Optional<Product> actual = productRepo.getProductById(1);
        Product expected = new Product(1, "Roibos");

        //THEN
        assertEquals(Optional.of(expected), actual);

    }

    @Test
    @DisplayName("Test list if unknown id is entered")
    public void testGetProductByIdOptionalEmpty(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo(List.of(
                new Product(1,"Roibos"),
                new Product(2,"Vanilla"),
                new Product(3,"Grey")
        ));

        //WHEN
        Optional<Product> actual = productRepo.getProductById(5);

        //THEN
        assertEquals(Optional.empty(), actual);

    }

    @Test
    @DisplayName("tests the addition of a new product")
    public void testAddNewProduct(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        productRepo.addNewProduct(new Product(1,"Roibos"));
        productRepo.addNewProduct(new Product(2,"Vanilla"));
        productRepo.addNewProduct(new Product(3,"Grey"));

        //WHEN
        productRepo.addNewProduct(new Product(4,"Elderberry"));
        List<Product> actual = productRepo.list();
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