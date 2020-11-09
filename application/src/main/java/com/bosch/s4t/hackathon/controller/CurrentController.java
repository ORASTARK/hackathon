package com.bosch.s4t.hackathon.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.s4t.hackathon.entity.CurrentEntity;
import com.bosch.s4t.hackathon.entity.MasterEntity;
import com.bosch.s4t.hackathon.repository.CurrentRepository;
import com.bosch.s4t.hackathon.repository.MasterRepository;

@RestController
@RequestMapping("/current")
public class CurrentController {

	@Autowired
	public CurrentRepository currentRepo;
	
	@PostMapping
	public String addCurrentData() throws Exception{
		try{
			
			
			
			List<CurrentEntity> currentEntityList = new ArrayList<CurrentEntity>();
			
			CurrentEntity currentEntity1 = new CurrentEntity();
			currentEntity1.setFetchTime(LocalDateTime.now());
			currentEntity1.setNum(1);
			currentEntityList.add(currentEntity1);
			
			CurrentEntity currentEntity2 = new CurrentEntity();
			currentEntity2.setFetchTime(LocalDateTime.now());
			currentEntity2.setNum(2);
			currentEntityList.add(currentEntity2);
			
			CurrentEntity currentEntity3 = new CurrentEntity();
			currentEntity3.setFetchTime(LocalDateTime.now());
			currentEntity3.setNum(3);
			currentEntityList.add(currentEntity3);
			
			CurrentEntity currentEntity4 = new CurrentEntity();
			currentEntity4.setFetchTime(LocalDateTime.now());
			currentEntity4.setNum(4);
			currentEntityList.add(currentEntity4);
	    	
	    	
	    		    	
	    	currentRepo.saveAll(currentEntityList);
	    	return "Add current data successfully!";
	    }catch(Exception e) {
	    	return "Error message is: " + e;
		}	
	}
}
