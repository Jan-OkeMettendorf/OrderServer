package de.neuefische.orderserverspring.service;

import de.neuefische.orderserverspring.Repo.ProductRepo;
import de.neuefische.orderserverspring.model.Product;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static java.util.function.Predicate.isEqual;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Test
    @DisplayName("Test method whether product is available based on the id")
    public void testGetProductById() {
        //GIVEN
        ProductRepo productRepo = mock(ProductRepo.class);
        when(productRepo.getProductById(3)).thenReturn(
                Optional.of(new Product(3, "Grey"))
        );
        ProductService productService = new ProductService(productRepo);

        //WHEN
        Product actual = productService.getProductById(3);
        Product expected = new Product(3, "Grey");

        //THEN
        assertEquals(expected, actual);
        verify(productRepo, times(2)).getProductById(3);
    }


    @Test
    @DisplayName("Test method whetsher product is available based on the id")
    public void testGetProductByIdFalse() {
        //GIVEN
        ProductRepo productRepo = mock(ProductRepo.class);
        when(productRepo.getProductById(3)).thenReturn(
                Optional.of(new Product(3, "Grey"))
        );
        ProductService productService = new ProductService(productRepo);

        //WHEN
        try {
            productService.getProductById(4);
        } catch (IllegalArgumentException e) {
            String actual = e.getMessage();
            String expected = "Product not found by ID: 4";
            //THEN
            assertEquals(expected, actual);
            verify(productRepo).getProductById(4);
        }


    }

    @Test
    @DisplayName("Tests whether all products from the list are displayed")
    public void testList() {
        //GIVEN
        ProductRepo productRepo = mock(ProductRepo.class);
        when(productRepo.list()).thenReturn(List.of(
                new Product(1, "Roibois"),
                new Product(2, "Vanilla"),
                new Product(3, "Grey")
        ));
        ProductService productService = new ProductService(productRepo);

        //WHEN
        List<Product> actual = productService.list();

        //THEN
        assertThat(actual, containsInAnyOrder(
                new Product(1, "Roibois"),
                new Product(2, "Vanilla"),
                new Product(3, "Grey")
        ));
        verify(productRepo).list();
    }

    @Test
    @DisplayName("tests the addition of a new product")
    public void testAddNewProduct() {
        //GIVEN
        ProductRepo productRepo = mock(ProductRepo.class);
        when(productRepo.addNewProduct(new Product(1, "Roibos"))).thenReturn(
                new Product(1, "Roibos")
        );

        ProductService productService = new ProductService(productRepo);

        //WHEN
        productService.addNewProduct(new Product(2, "Vanilla"));
        System.out.println(productService.list());
        List<Product> actual = productService.list();

        //THEN

        assertThat(actual, containsInAnyOrder(List.of(
                new Product(1,"Roibos"),
                new Product(2,"Vanilla")
        )));


    }
}
