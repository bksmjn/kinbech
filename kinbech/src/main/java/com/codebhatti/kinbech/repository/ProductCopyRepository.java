package com.codebhatti.kinbech.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.ProductCopy;

@Repository
public interface ProductCopyRepository extends CrudRepository<ProductCopy, Long> {
	@Query("SELECT p FROM ProductCopy p WHERE productid = :productid")
	public List<ProductCopy> getAllProductCopies(@Param("productid") Long productId);
	
	@Query("SELECT p FROM ProductCopy p WHERE productid = :productid AND "
			+ "PRODUCT_STATUS='NOT_SOLD'")
	public List<ProductCopy> getAllProductCopiesWithLimit(@Param("productid") Long productId,
			Pageable pageable);
}
