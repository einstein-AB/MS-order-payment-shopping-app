package com.learning.ms.shopping.repository;

import com.learning.ms.shopping.entity.Shopping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends MongoRepository<Shopping, Integer> {
}
