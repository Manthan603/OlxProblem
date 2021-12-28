package com.olxmasterdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olxmasterdata.model.Categories;
import com.olxmasterdata.repository.CategoriesRepository;

@Service
public class CategoriesService 
{
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public List<Categories> getAllCategories()
	{
		return categoriesRepository.findAll();
	}
	
	public Categories getCategoriesById(int id)
	{
		return categoriesRepository.findById(id).get();
	}
	
	public Categories saveCategories(Categories categories)
	{
		return categoriesRepository.save(categories);
	}
}
