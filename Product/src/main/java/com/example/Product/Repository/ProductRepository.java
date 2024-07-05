package com.example.Product.Repository;

import com.example.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
