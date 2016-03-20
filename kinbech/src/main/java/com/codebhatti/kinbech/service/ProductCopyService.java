package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Product;
import com.codebhatti.kinbech.domain.ProductCopy;
import com.codebhatti.kinbech.exception.BusinessException;

/**
 * @author Yugal Koirala
 *
 */
public interface ProductCopyService {
	/**
	 * @param product the product whose  copy is to be made
	 * @return returns the list of copies created 
	 */
	public List<ProductCopy> addProductCopies(Product product);
	
	/**
	 * @param product the product whose quantity is requested
	 * @return the number of available copies of the product
	 */
	public Integer getTotalAvailableQuantity(Product product);
	/**
	 * @param productId the id of the product whose copies are requested
	 * @param quantity the quantity of product requested
	 * @return list of the requested productcopy 
	 * @throws BusinessException
	 */
	public List<ProductCopy> getProductCopiesFromProductId(Long productId, Integer quantity)
					throws BusinessException;
	/**
	 * @param productCopy the product copy which is to be marked sold
	 * @return the product copy marked as sold
	 */
	public ProductCopy updateProductAsSold(ProductCopy productCopy);
}
