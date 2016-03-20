package com.codebhatti.kinbech.service;

import java.util.List;

import com.codebhatti.kinbech.domain.Category;

/**
 * @author Tek Ale
 *
 */
public interface CategoryService {
	/**
	 * @return returns all the category available in the database
	 */
	public List<Category> getAllCategories();
}
