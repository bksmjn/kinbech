package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.ProductCopy;
import com.codebhatti.kinbech.exception.BusinessException;

public interface ProductCopyService {
	public List<ProductCopy> addProductCopies(Product product);
	public Integer getTotalAvailableQuantity(Product product);
	public List<ProductCopy> getProductCopiesFromProductId(Long productId, Integer quantity)
					throws BusinessException;
}
