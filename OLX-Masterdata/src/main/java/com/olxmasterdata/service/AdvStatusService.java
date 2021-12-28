package com.olxmasterdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olxmasterdata.model.AdvStatus;
import com.olxmasterdata.model.Categories;
import com.olxmasterdata.repository.AdvStatusRepository;

@Service
public class AdvStatusService 
{
	@Autowired
	private AdvStatusRepository advStatusRepository;
	
	public List<AdvStatus> getAllAdvStatus()
	{
		return advStatusRepository.findAll();
	}
	
	public AdvStatus getAdvStatusById(int id)
	{
		return advStatusRepository.findById(id).get();
	}
	
	
	public AdvStatus saveAdvStatus(AdvStatus advStatus)
	{
		return advStatusRepository.save(advStatus);
	}
}
