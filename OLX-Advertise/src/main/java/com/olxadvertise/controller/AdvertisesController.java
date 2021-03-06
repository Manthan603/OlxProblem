package com.olxadvertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxadvertise.model.Advertises;
import com.olxadvertise.service.AdvertisesService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("advertiseapi")
public class AdvertisesController
{
	@Autowired
	private AdvertisesService advertisesService;
	
	public List<Advertises> getAllAdvertiseeHandler(Exception e)
	{
		return null;
	}
	
	@GetMapping("getAllAdevertise")
	@Retry(name="getAllAdvertise",fallbackMethod = "getAllAdvertiseeHandler")
	public List<Advertises> getAllAdvertise()
	{
		return advertisesService.getAllAdvertise();
	}
	
	public Advertises getPerticularAdvertiseHandler(int id,Exception e)
	{
		return new Advertises();
	}
	
	@GetMapping("getAdvertiseById/{id}")
	@Retry(name="getPerticularAdvertise",fallbackMethod = "getPerticularAdvertiseHandler")
	public Advertises getPerticularAdvertise(@PathVariable("id") int id)
	{
		return advertisesService.getAdvertiseById(id);
	}
	
	public Advertises saveAdvertisesHandler(Advertises advertises,Exception e)
	{
		return advertises;
	}
	
	@PostMapping("saveAdvertise")
	@Retry(name="saveAdvertises",fallbackMethod = "saveAdvertisesHandler")
	public Advertises saveAdvertises(@RequestBody Advertises advertises)
	{
		return advertisesService.saveAdvertises(advertises);
	}
	
	@PutMapping("updateAdvertise")
	public Advertises updateAdvertises(@RequestBody Advertises advertises)
	{
		return advertisesService.updateAdvertises(advertises);
	}
	
	@DeleteMapping("deleteAdvertiseById/{id}")
	public String deleteAdvertise(@PathVariable("id") int id)
	{
		return advertisesService.deleteAdvertise(id);
	}
}
