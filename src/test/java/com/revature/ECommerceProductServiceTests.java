package com.revature;

import com.revature.models.Product;
import com.revature.repositories.ProductRepository;

import com.revature.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class ECommerceProductServiceTests {

    @Mock ProductRepository productRepository;
    @Mock Product mockProduct;

    private ProductService productService;

    @BeforeEach void setUp(){
        this.productService = new ProductService(this.productRepository);
    }

    @Test void getAllProducts(){
        productService.findAll();
        verify(productRepository).findAll();
    }
    @Test
    void whenIdExists_findByIdReturnsProduct(){
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(mockProduct));
        Optional<Product> returnedProduct =productService.findById(1);
        assertTrue(returnedProduct.get().equals(mockProduct));
    }

    public static class ECommerceUserServiceTests {
    }
}
