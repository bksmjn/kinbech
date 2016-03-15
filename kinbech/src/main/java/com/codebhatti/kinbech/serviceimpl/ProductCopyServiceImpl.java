package com.codebhatti.kinbech.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.ProductCopy;
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
	
	
}
