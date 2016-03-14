package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Product;

public interface ProductService {
	public Product saveOrUpdate(Product product);
	public void delete(Product product);
	public Product findByProductId(Long productId);
	public List<Product> getAllProducts();
}
