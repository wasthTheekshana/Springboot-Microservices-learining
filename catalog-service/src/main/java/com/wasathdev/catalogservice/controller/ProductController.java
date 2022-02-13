package com.wasathdev.catalogservice.controller;


import com.wasathdev.catalogservice.entity.Product;
import com.wasathdev.catalogservice.exception.ProductNotFoundException;
import com.wasathdev.catalogservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> allProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code){
        return productService.findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exists"));
    }
}
