package com.olxmasterdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxmasterdata.model.AdvStatus;
import com.olxmasterdata.model.Categories;
import com.olxmasterdata.service.AdvStatusService;
import com.olxmasterdata.service.CategoriesService;

@RestController
@RequestMapping("advertiseMasterapi")
public class OlxMasterdataController 
{
	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private AdvStatusService advStatusService;
	
	
	@GetMapping("getAllCatogies")
	public List<Categories> getAllCatogies()
	{
		return categoriesService.getAllCategories();
	}
	
	@GetMapping("getCatogiesById/{id}")
	public Categories getPerticularCatogies(@PathVariable("id") int id)
	{
		return categoriesService.getCategoriesById(id);
	}
	
	
	@GetMapping("getAllAdvStatus")
	public List<AdvStatus> getAllAdvStatus()
	{
		return advStatusService.getAllAdvStatus();
	}
	
	
	@GetMapping("getAdvStatusById/{id}")
	public AdvStatus getPerticularAdvStatus(@PathVariable("id") int id)
	{
		return advStatusService.getAdvStatusById(id);
	}
	
	@PostMapping("saveCatogies")
	public Categories saveCatogies(@RequestBody Categories categories)
	{
		return categoriesService.saveCategories(categories);
	}
	
	@PostMapping("saveAdvStatus")
	public AdvStatus saveAdvStatus(@RequestBody AdvStatus advStatus)
	{
		return advStatusService.saveAdvStatus(advStatus);
	}
	
	
}
