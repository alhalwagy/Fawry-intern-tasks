package org.fawry.service;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import org.fawry.excptions.CustomExceptions.NotAuthorizedException;
import org.fawry.excptions.CustomExceptions.ResourceNotFoundException;
import org.fawry.model.Product;
import org.fawry.repoistory.ProductRepository;

import java.util.List;

@Singleton
public class ProductServiceImpl implements ProductService {

  @Inject private ProductRepository productRepository;

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(int id)  {
    if (id <= 0 || id > productRepository.getProductListSize()) {
      throw new ResourceNotFoundException("Product with id " + id + " not found.");
    }
    return productRepository.findProductById(id);
  }

  @Override
  public void addProduct(Product product) {
    productRepository.add(product);
  }

  @Override
  public Product updateProduct(int id, Product product) {
    return productRepository.update(id, product);
  }

  @Override
  public void deleteProduct(int id) {

    productRepository.deleteProduct(id);
  }

  @Override
  public Product getProductByName(String name) {
    return productRepository.findProductByName(name);
  }
}
