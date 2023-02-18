package com.rbnico.productmicorservice.controller;

import com.rbnico.productmicorservice.entity.ListResponse;
import com.rbnico.productmicorservice.entity.ProductEntity;
import com.rbnico.productmicorservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity productEntity) {
        productService.saveProduct( productEntity );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findProductById( @PathVariable("id") Integer id ) {
        Optional<ProductEntity> product = productService.findProductById( id );
        return  product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
