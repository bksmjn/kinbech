package com.codebhatti.kinbech.service;

import java.io.IOException;
import java.util.List;

import com.codebhatti.kinbech.domain.Product;

public interface ProductService {
	public Product saveOrUpdate(Product product) throws IllegalStateException, IOException;
	public void delete(Product product);
	public Product findByProductId(Long productId);
	public List<Product> getAllProducts();
}
