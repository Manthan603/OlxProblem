package com.olxadvertise.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.olxadvertise.model.Categories;
import com.olxadvertise.model.AdvStatus;

@FeignClient("APIGATEWAY-SERVICE")
public interface OlxMasterDataClient 
{
	@GetMapping("advertiseMasterapi/getAllCatogies")
	List<Categories> getAllCatogies();
	
	@GetMapping("advertiseMasterapi/getAllAdvStatus")
	List<AdvStatus> getAllAdvStatus();
	
	@GetMapping("advertiseMasterapi/getCatogiesById/{id}")
	Categories getperticularCategories(@PathVariable("id") int id);
	
	@GetMapping("advertiseMasterapi/getAdvStatusById/{id}")
	AdvStatus getperticularAdvStatus(@PathVariable("id") int id);
}
/*
 * package com.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient
{
	@GetMapping("couponapi/getCoupon/{couponCode}")
	Coupon getCoupon(@PathVariable("couponCode") String couponCode);
}

 */
