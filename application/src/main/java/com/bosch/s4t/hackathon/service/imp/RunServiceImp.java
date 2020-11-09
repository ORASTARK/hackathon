package com.bosch.s4t.hackathon.service.imp;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bosch.s4t.hackathon.repository.CurrentRepository;
import com.bosch.s4t.hackathon.service.RunService;


@Service
public class RunServiceImp implements RunService {
	@Autowired
	public CurrentRepository currentRepo;
	
	public String RunCalculate() {
		return null;
	}
}
