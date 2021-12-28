package com.olxadvertise.model;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Advertises
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String category;
	@Transient
	private int categoryId;
	@Transient
	private int statusId;
	private String status;
	private double price;
	private String description;
	private Blob photo;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
	private int active;
	private String postedBy;
	private String username;
	
}
