package com.bosch.s4t.hackathon.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
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

import com.bosch.s4t.hackathon.entity.MasterEntity;
import com.bosch.s4t.hackathon.repository.MasterRepository;

@RestController
@RequestMapping("/master")
public class MasterController {

	@Autowired
	public MasterRepository masterRepo;
	
	@PostMapping
	public String addMasterData() throws Exception{
		try{
			
			List<MasterEntity> masterEntityList = new ArrayList<MasterEntity>();
			
	    	MasterEntity masterEntity1 = new MasterEntity();
	    	masterEntity1.setINum(1);
	    	masterEntity1.setIMac("EAC5B7C514F1");
	    	masterEntity1.setICircle(70);
	    	masterEntity1.setICenter(50);
	    	masterEntity1.setSNum(1);
	    	masterEntityList.add(masterEntity1);
	    	
	    	MasterEntity masterEntity2 = new MasterEntity();
	    	masterEntity2.setINum(2);
	    	masterEntity2.setIMac("FBF65BA2306D");
	    	masterEntity2.setICircle(70);
	    	masterEntity2.setICenter(50);
	    	masterEntityList.add(masterEntity2);
	    	
	    	MasterEntity masterEntity3 = new MasterEntity();
	    	masterEntity3.setINum(3);
	    	masterEntity3.setIMac("D2FAC6A687E3");
	    	masterEntity3.setICircle(70);
	    	masterEntity3.setICenter(50);
	    	masterEntityList.add(masterEntity3);
	    	
	    	MasterEntity masterEntity4 = new MasterEntity();
	    	masterEntity4.setINum(4);
	    	masterEntity4.setIMac("F4624CB7A63A");
	    	masterEntity4.setICircle(70);
	    	masterEntity4.setICenter(50);
	    	masterEntityList.add(masterEntity4);
	    	
	    	MasterEntity masterEntity5 = new MasterEntity();
	    	masterEntity5.setINum(5);
	    	masterEntity5.setIMac("E4C08922EDDB");
	    	masterEntity5.setICircle(70);
	    	masterEntity5.setICenter(50);
	    	masterEntityList.add(masterEntity5);
	    	
	    	MasterEntity masterEntity6 = new MasterEntity();
	    	masterEntity6.setINum(6);
	    	masterEntity6.setIMac("E3B3C49220E7");
	    	masterEntity6.setICircle(70);
	    	masterEntity6.setICenter(50);
	    	masterEntity6.setSNum(4);
	    	masterEntityList.add(masterEntity6);
	    	
	    	MasterEntity masterEntity7 = new MasterEntity();
	    	masterEntity7.setINum(7);
	    	masterEntity7.setIMac("E82CFA225074");
	    	masterEntity7.setICircle(70);
	    	masterEntity7.setICenter(50);
	    	masterEntityList.add(masterEntity7);
	    	
	    	MasterEntity masterEntity8 = new MasterEntity();
	    	masterEntity8.setINum(8);
	    	masterEntity8.setIMac("E3E459805DAD");
	    	masterEntity8.setICircle(70);
	    	masterEntity8.setICenter(50);
	    	masterEntityList.add(masterEntity8);
	    	
	    	MasterEntity masterEntity9 = new MasterEntity();
	    	masterEntity9.setINum(9);
	    	masterEntity9.setIMac("E908C024BF5B");
	    	masterEntity9.setICircle(70);
	    	masterEntity9.setICenter(50);
	    	masterEntity9.setSNum(2);
	    	masterEntityList.add(masterEntity9);
	    	
	    	MasterEntity masterEntity10 = new MasterEntity();
	    	masterEntity10.setINum(10);
	    	masterEntity10.setIMac("D4E97FABAD52");
	    	masterEntity10.setICircle(70);
	    	masterEntity10.setICenter(50);
	    	masterEntityList.add(masterEntity10);
	    	
	    	MasterEntity masterEntity11 = new MasterEntity();
	    	masterEntity11.setINum(11);
	    	masterEntity11.setIMac("DDF2BE0886E0");
	    	masterEntity11.setICircle(70);
	    	masterEntity11.setICenter(50);
	    	masterEntity11.setSNum(3);
	    	masterEntityList.add(masterEntity11);
	    	
	    	MasterEntity masterEntity12 = new MasterEntity();
	    	masterEntity12.setINum(12);
	    	masterEntity12.setIMac("E2DAFE7391D8");
	    	masterEntity12.setICircle(70);
	    	masterEntity12.setICenter(50);
	    	masterEntityList.add(masterEntity12);
/*	    	
	    	MasterEntity masterEntity13 = new MasterEntity();
	    	masterEntity13.setSNum(1);
	    	masterEntity13.setSCircle(70);
	    	masterEntity13.setSCenter(50);
	    	masterEntityList.add(masterEntity13);
	    	
	    	MasterEntity masterEntity14 = new MasterEntity();
	    	masterEntity14.setSNum(2);
	    	masterEntity14.setSCircle(70);
	    	masterEntity14.setSCenter(50);
	    	masterEntityList.add(masterEntity14);
	    	
	    	MasterEntity masterEntity15 = new MasterEntity();
	    	masterEntity15.setSNum(3);
	    	masterEntity15.setSCircle(70);
	    	masterEntity15.setSCenter(50);
	    	masterEntityList.add(masterEntity15);
	    	
	    	MasterEntity masterEntity16 = new MasterEntity();
	    	masterEntity16.setSNum(4);
	    	masterEntity16.setSCircle(70);
	    	masterEntity16.setSCenter(50);
	    	masterEntityList.add(masterEntity16);
*/	    		    	
	    	masterRepo.saveAll(masterEntityList);
	    	return "Add master data successfully!";
	    }catch(Exception e) {
	    	return "Error message is: " + e;
		}	
	}
}
