package com.olxadvertise.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.olxadvertise.config.OlxMasterDataClient;
import com.olxadvertise.model.AdvStatus;
import com.olxadvertise.model.Advertises;
import com.olxadvertise.model.Categories;
import com.olxadvertise.repositories.AdvertisesReposiory;

@Service
public class AdvertisesService
{
	@Autowired
	private AdvertisesReposiory advertisesReposiory;
	
	@Autowired
	private OlxMasterDataClient olxMasterDataClient;
	
	public Advertises saveAdvertises(@RequestBody Advertises advertises)
	{
//		Categories categories = new Categories();
//		AdvStatus advStatus = new AdvStatus();
		Categories categories = olxMasterDataClient.getperticularCategories(advertises.getCategoryId());
		AdvStatus advStatus = olxMasterDataClient.getperticularAdvStatus(advertises.getStatusId());
		/*
				List<Categories> listOfCategories = olxMasterDataClient.getAllCatogies();
		List<AdvStatus> listOfAdvStatus = olxMasterDataClient.getAllAdvStatus();
		System.out.println(advertises);
		System.out.println();
		for(Categories obj :listOfCategories)
		{
			System.out.println(obj);
			if(obj.getId()==advertises.getCategoryId())
			{
				categories = obj;
				break;
			}
		}
		
		for(AdvStatus obj :listOfAdvStatus)
		{
			System.out.println(obj);
			if(obj.getId()==advertises.getStatusId())
			{
				advStatus = obj;
				break;
			}
		}
		*/
		
		advertises.setActive(advStatus.getId());
		advertises.setCategory(categories.getName());
		advertises.setPostedBy(advertises.getUsername());
		LocalDateTime now = LocalDateTime.now(); 
		advertises.setCreatedDate(now.toLocalDate());
		advertises.setModifiedDate(now.toLocalDate());
		advertises.setStatus(advStatus.getStatus());
		System.out.println(categories);
		System.out.println(advStatus);
		/*
		 * {"title": "laptop sale", "price": 54000, "categoryId": 1, "description": "intel core 3 Sony Vaio"}
		 *{"id": 2, "title": "Sofa available for sale", "price": 30000, "category": "Furniture", 
		 * "description": "Sofa 5 years old available for Sale in Pune", "username": "anand", 
		 * "createdDate": xxx, "modifiedDate": xxx, "status": "OPEN"} 
		 */
		return advertisesReposiory.save(advertises);
	}
	
	public Advertises updateAdvertises(@RequestBody Advertises advertises)
	{
		Categories categories = new Categories();
		AdvStatus advStatus = new AdvStatus();
		List<Categories> listOfCategories = olxMasterDataClient.getAllCatogies();
		List<AdvStatus> listOfAdvStatus = olxMasterDataClient.getAllAdvStatus();
		System.out.println(advertises);
		System.out.println();
		for(Categories obj :listOfCategories)
		{
			System.out.println(obj);
			if(obj.getId()==advertises.getCategoryId())
			{
				categories = obj;
				break;
			}
		}
		
		for(AdvStatus obj :listOfAdvStatus)
		{
			System.out.println(obj);
			if(obj.getId()==advertises.getStatusId())
			{
				advStatus = obj;
				break;
			}
		}
		
		Optional<Advertises> advertisesCopyOptional = advertisesReposiory.findById(advertises.getId());
		Advertises advertisesCopy = advertisesCopyOptional.get();
		
		
		advertisesCopy.setActive(advStatus.getId());
		advertisesCopy.setCategory(categories.getName());
		advertisesCopy.setPostedBy(advertises.getUsername());
		LocalDateTime now = LocalDateTime.now(); 
		advertisesCopy.setModifiedDate(now.toLocalDate());
		advertisesCopy.setStatus(advStatus.getStatus());
		advertisesCopy.setTitle(advertises.getTitle());
		advertisesCopy.setPrice(advertises.getPrice());
		advertisesCopy.setDescription(advertises.getDescription());
		System.out.println(categories);
		System.out.println(advStatus);

		return advertisesReposiory.save(advertisesCopy);
	}
	
	public String deleteAdvertise(int id)
	{
		if(advertisesReposiory.existsById(id))
			advertisesReposiory.deleteById(id);
		else
			return "Data Not Present";
		if(advertisesReposiory.existsById(id))
		{
			return "Not Deleted Successfully !!!";
		}
		return "Deleted Successfully !!!";
	}
	
	
	public Advertises getAdvertiseById(int id)
	{
		return advertisesReposiory.findById(id).get();
	}
	
	public List<Advertises> getAllAdvertise()
	{
		return advertisesReposiory.findAll();
	}
	
}
