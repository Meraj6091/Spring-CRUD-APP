package com.example.crud.demo.service;

import com.example.crud.demo.entity.Product;
import com.example.crud.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //save
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    //get
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductsById(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductsByName(String name){
        return repository.findByName(name);
    }

    //delete
    public String deleteProduct(int id){
         repository.deleteById(id);
         return "Product Deleted"+id;
    }

    //update
    public Product updateProducts(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);

    }

}
