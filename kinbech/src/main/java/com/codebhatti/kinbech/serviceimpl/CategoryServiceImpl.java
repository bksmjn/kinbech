package com.codebhatti.kinbech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Category;
import com.codebhatti.kinbech.repository.CategoryRepository;
import com.codebhatti.kinbech.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return (List<Category>)categoryRepository.findAll();
	}
}
