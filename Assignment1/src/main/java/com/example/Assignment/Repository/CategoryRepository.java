package com.example.Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Assignment.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
