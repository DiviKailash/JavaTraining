package com.dal.firstsprboot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.firstsprboot.entity.Traveller;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Long>{
	public Traveller findByTravellerName(String travellerName);
	public Traveller findByTravellerId(Long travelcode);
	
	
}
