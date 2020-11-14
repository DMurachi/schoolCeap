/*package com.bucares.barcode.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.bucares.barcode.model.Product;
import com.bucares.barcode.service.ProductService;
import com.bucares.barcode.utilities.Response;


@Controller
public class ProductController {

  @Autowired
  private ProductService productService;

  private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

  @GetMapping(value = "/product")
  public ResponseEntity<Response<List<Product>>> getAllProducts() {
    logger.info("Called resource: getAllProducts");

    List<Product> productList = productService.getAllProducts();
    Response<List<Product>> response = new Response<>("0000", productList, null);

    logger.info("Called resource: getAllProducts");

    logger.info("Consulted: every product in database");

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping(value = "/product/{barcode}")
  public ResponseEntity<Response<Product>> getProduct(@PathVariable("barcode") String barcode) {
    logger.info("Called resource: getProduct");

    Product product = productService.getProductByBarcode(barcode);

    Response<Product> response = new Response<>("0000", product, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/product")
  public ResponseEntity<Response<Product>> createProduct(@Valid @RequestBody Product product) {
    logger.info("Called resource: createProduct");
    logger.info("{}", product.getName());

    Product oldProduct = productService.getProductByBarcode(product.getBarcode());
    if (oldProduct != null) {
      oldProduct.setName(product.getName());
      oldProduct.setIngredients(product.getIngredients());
      oldProduct.setCategories(product.getCategories());
      oldProduct.setQuantity(product.getQuantity());
      productService.storeProduct(oldProduct);
    } else {
      productService.storeProduct(product);
    }

    Response<Product> response = new Response<>("0000", product, null);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}*/
