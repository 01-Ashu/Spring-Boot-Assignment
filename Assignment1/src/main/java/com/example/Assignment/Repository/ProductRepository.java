package com.example.Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Assignment.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
