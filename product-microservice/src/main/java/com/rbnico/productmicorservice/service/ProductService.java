package com.rbnico.productmicorservice.service;

import com.rbnico.productmicorservice.entity.ListResponse;
import com.rbnico.productmicorservice.entity.ProductEntity;
import com.rbnico.productmicorservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("unused")
    public ListResponse<ProductEntity> getAllProducts() {
        return new ListResponse<>(productRepository.findAll());
    }

    public ListResponse<ProductEntity> getAllProducts(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return new ListResponse<>(
                productRepository.findAll(paging)
                .get()
                .collect(Collectors.toList()), paging);

    }

    public Optional<ProductEntity> findProductById( Integer id ) {
        return productRepository.findById( id );
    }


    public ProductEntity saveProduct( ProductEntity product ) {
        return productRepository.save( product );
    }
}
