package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProduct(int id){
        return repo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product p){
        return repo.save(p);
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }

    public void updateProduct(int id, Product p){
        Product product = repo.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        repo.save(product);
        System.out.println(product);
    }
}
