package com.codebhatti.kinbech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.repository.ProductRepository;
import com.codebhatti.kinbech.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveOrUpdate(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public Product findByProductId(Long productId) {
		return productRepository.findOne(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>)productRepository.findAll();
	}
}
