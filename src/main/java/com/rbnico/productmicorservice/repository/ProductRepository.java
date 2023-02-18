package com.rbnico.productmicorservice.repository;

import com.rbnico.productmicorservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Integer> {
}
