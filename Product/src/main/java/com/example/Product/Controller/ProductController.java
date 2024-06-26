package com.example.Product.Controller;

import ch.qos.logback.core.model.Model;
import com.example.Product.Repository.ProductRepository;
import com.example.Product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @RequestMapping
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @Autowired
    ProductRepository productRepository;
    @PostMapping("/products")
    public String products(@ModelAttribute Product product){
        productRepository.save(product);
        return "index";
    }


}
