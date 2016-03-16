package com.codebhatti.kinbech.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.ProductCopy;
import com.codebhatti.kinbech.repository.ProductRepository;
import com.codebhatti.kinbech.service.ProductCopyService;
import com.codebhatti.kinbech.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCopyService productCopyService;

	@Override
	public Product saveOrUpdate(Product product) {
		List<ProductCopy> newProductCopies = new ArrayList<>();

		if (product != null && product.getQuantityWhenUpload() != null) {
			for (int i = 0; i < product.getQuantityWhenUpload(); i++) {
				ProductCopy newCopy = new ProductCopy();
				newCopy.setProduct(product);
				System.out.println(newCopy.printAsString());
				newProductCopies.add(newCopy);
			}
		}
		
		product.setProductCopyList(newProductCopies);
		Product savedProduct = productRepository.save(product);
		//productCopyService.addProductCopies(savedProduct);
		return savedProduct;
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
		return (List<Product>) productRepository.findAll();
	}
}
