package com.dolsoft.productservice.controller;

import com.dolsoft.productservice.model.Product;
import com.dolsoft.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET /v1/products/{productId}
    @GetMapping(value = "/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {
        Product product = productService.getProduct(productId);

        product.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ProductController.class)
                                .getProduct(productId))
                .withSelfRel());

        product.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ProductController.class)
                                .createProduct(product))
                .withRel("createProduct"));

        product.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ProductController.class)
                                .updateProduct(product))
                .withRel("updateProduct"));

        product.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(ProductController.class)
                                .deleteProduct(String.valueOf(product.getId())))
                .withRel("deleteProduct"));

        return ResponseEntity.ok(product);
    }

    // PUT /v1/products
    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody Product request) {
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    // POST /v1/products
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    // DELETE /v1/products/{productId}
    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}