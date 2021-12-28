package com.olxadvertise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olxadvertise.model.Advertises;

@Repository
public interface AdvertisesReposiory extends JpaRepository<Advertises, Integer> 
{

}
