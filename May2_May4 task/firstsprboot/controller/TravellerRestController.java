package com.dal.firstsprboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.firstsprboot.entity.ForeignTour;
import com.dal.firstsprboot.entity.LocalTour;
import com.dal.firstsprboot.entity.Traveller;
import com.dal.firstsprboot.repo.TravellerRepository;
import com.dal.firstsprboot.service.TravellerService;
@RestController
public class TravellerRestController {

	@Autowired
	TravellerService travellerService;
	
	@Autowired
	TravellerRepository travellerRepository;

	
	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi Traveller Divya bhuvana";
	}
	
	@PostMapping("/addtraveller")	
	public Traveller addTraveller(@RequestBody Traveller traveller) {
		traveller.setTravellerPwd(new BCryptPasswordEncoder().encode(traveller.getTravellerPwd()));
		return travellerService.addTraveller(traveller);
	}
	
	//
	@PreAuthorize("hasAuthority('DC')")
	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return travellerService.saveLocalTourRequest(localTour);
	}

	@PreAuthorize("hasAuthority('FC')")
	@PostMapping("/requestforeigntour")
	
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return travellerService.saveForeignTourRequest(foreignTour);
	}
	
	@GetMapping("/listtravellers")

	public List<Traveller> listAllTravellers() {

		return travellerService.listAllTravellers();
	}

	
	@GetMapping("/findbyid/{id}")

	public Optional<Traveller> SearchByTravellerId(@PathVariable Long id) {

		return travellerService.searchByTravellerID(id);
	}
	
	@GetMapping("/findbyname/{name}")

	public Traveller SearchByTravellerName(@PathVariable String name) {

		return travellerService.searchByTravellerName(name);
	}

	
	@DeleteMapping("/deletebyid/{id}")

	public void deleteByID(@PathVariable Long id) {

		 travellerService.deleteByID(id);
	}
	
//	@GetMapping("/login")	
//	public ResponseEntity<Traveller> loginrest(@RequestParam(value = "username", required = false) String username,
//			@RequestParam(value = "password", required = false) String password) {
//		System.out.println("*******This is a login rest controller ***********");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Traveller traveller = travellerRepository.findByTravellerName(auth.getName());
//		System.out.println("After Login__________________"
//				+ "send back to Angular or postman as response__________________" + traveller);
//		return ResponseEntity.ok(traveller);
//	}

}
