package com.codebhatti.kinbech.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.ProductCopy;
import com.codebhatti.kinbech.exception.BusinessException;
import com.codebhatti.kinbech.repository.ProductCopyRepository;
import com.codebhatti.kinbech.service.ProductCopyService;

@Service
@Transactional
public class ProductCopyServiceImpl implements ProductCopyService {
	@Autowired
	private ProductCopyRepository productCopyRepository;

	@Override
	public List<ProductCopy> addProductCopies(Product product) {
		List<ProductCopy> savedProductCopies = new ArrayList<>();
		
		if(product!=null && product.getQuantityWhenUpload()!=null) {
			for(int i=0;i<product.getQuantityWhenUpload();i++) {
				ProductCopy newCopy = new ProductCopy();
				newCopy.setProduct(product);
				
				ProductCopy savedCopy = productCopyRepository.save(newCopy);
				savedProductCopies.add(savedCopy);
			}
		}
		
		return savedProductCopies;
	}

	@Override
	public Integer getTotalAvailableQuantity(Product product) {
		return productCopyRepository.getAllProductCopies(product.getProductId()).size();
	}

	@Override
	public List<ProductCopy> getProductCopiesFromProductId(Long productId, Integer quantity) throws BusinessException {
		Pageable pageable = new PageRequest(0, quantity);
		List<ProductCopy> productCopies=productCopyRepository.getAllProductCopiesWithLimit(productId, pageable);
		if(productCopies.size()==quantity)
			return productCopies;
		else
			throw new BusinessException("Insufficient stock in store.");
	}

	@Override
	public ProductCopy updateProductAsSold(ProductCopy productCopy) {
		return productCopyRepository.save(productCopy);
	}
}
