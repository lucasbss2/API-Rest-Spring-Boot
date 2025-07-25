package com.example.API_Rest.service;

import com.example.API_Rest.exceptions.ResourceNotFoundException;
import com.example.API_Rest.model.Product;
import com.example.API_Rest.repository.ProductRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> listProduct() {
        return productRepo.findAll();
    }

    public Product searchById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID "+id+" não encontrado."));
    }

    public Product saveProduct(Product produto) {
        return productRepo.save(produto);
    }

    public void delProduct(Long id) {

        if (!productRepo.existsById(id)) {
            throw new ResourceNotFoundException("Produto com ID "+id +" não encontrado.");
        }
        productRepo.deleteById(id);
    }
}
