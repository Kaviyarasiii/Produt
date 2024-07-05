package com.example.Product.Service;

import com.example.Product.Repository.ProductRepository;
import com.example.Product.model.Product;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class ProductService { // Once the best practices are implemented through the interface.

    private final ProductRepository productRepository;

    public Stream<Product> listAll() {
        return productRepository.findAll().parallelStream().distinct();
    }

   // return the saved entity object and give saved response
    public void save(Product product) {
        productRepository.save(product);
    }

    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No entity found with id: " + id));
    }

    public void delete(Long id) {

       productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No entity found with id: " + id));

        productRepository.deleteById(id);
    }
}

