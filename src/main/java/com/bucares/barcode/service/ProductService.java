/*package com.bucares.barcode.service;

import java.util.List;

import com.bucares.barcode.model.Product;
import com.bucares.barcode.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product storeProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductByBarcode(String barcode) {
    return productRepository.findByBarcode(barcode);
  }

}*/
