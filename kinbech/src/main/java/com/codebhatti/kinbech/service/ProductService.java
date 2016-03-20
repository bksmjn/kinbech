package com.codebhatti.kinbech.service;

import java.io.IOException;
import java.util.List;

import com.codebhatti.kinbech.domain.Product;

/**
 * @author Tek Ale
 *
 */
public interface ProductService {
	/**
	 * @param product the product to be updated or saved
	 * @return the updated or saved product
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public Product saveOrUpdate(Product product) throws IllegalStateException, IOException;
	/**
	 * @param product  the product to be deleted
	 */
	public void delete(Product product);
	/**
	 * @param productId the id of the product to be found
	 * @return the product object associated with the given ID
	 */
	public Product findByProductId(Long productId);
	/**
	 * @return returns list of all products
	 */
	public List<Product> getAllProducts();
}
