package com.heli.product_service.repository;

import com.heli.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> { // String is the type of the id field

}
