package com.gap.afp.repository;

import com.gap.afp.model.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
