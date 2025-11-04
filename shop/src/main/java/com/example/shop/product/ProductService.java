package com.example.shop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    //@Transactional
    public Long createProduct(ProductCreateRequest request){
        Product existingProduct = productRepository.findByProductId(request.getProductId());
        if(existingProduct == null) {
            throw new RuntimeException("이미 존재하는 상품명 입니다"+request.getProductId());
        }
        //
        Product product = new Product(
                request.get

        )
        productRepository.save(product);

        return product.getId();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    public Product getProductById(Long productId){
        Product product = productRepository.findByProductId(productId);
        if(product == null){
            throw new RuntimeException("존재하지 않는 상품입니다"+productId);
        }
        return product;
    }

    public void updateProduct(Long productId,ProductUpdateRequest request){
        Product product = productRepository.findByProductId(productId);
        if(product == null){
            throw new RuntimeException("존재하지 않는 상품입니다"+productId);
        }
        product.updateInfo(request.getPassword(),request.get);

    }

    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId);
        if (product == null){
            throw new RuntimeException("회원을 찾을 수 없습니다");
        }
        productRepository.deleteById(productId);
    }



}
