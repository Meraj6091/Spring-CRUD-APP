package com.example.crud.demo.repository;

import com.example.crud.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    Product findByName(String name);

}
