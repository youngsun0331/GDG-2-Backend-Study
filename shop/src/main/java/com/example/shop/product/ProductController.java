package com.example.shop.product;


import jdk.javadoc.doclet.Reporter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request){
        Long productId = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/product"+productId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(
                @PathVariable Long productId){

        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }


    @PatchMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(
                @RequestBody ProductUpdateRequest request,
                @PathVariable Long productId){
        productService.updateProduct(productId,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){

        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }



}
