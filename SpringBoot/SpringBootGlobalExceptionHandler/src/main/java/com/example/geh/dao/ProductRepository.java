package com.example.geh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.geh.model.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

}
