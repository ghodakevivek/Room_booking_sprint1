package com.example.roombooking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.DemoRepository;
import com.example.roombooking.entity.Demo;
import com.example.roombooking.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private DemoRepository demoRepository;
	
	@Override
	public Demo login(String demoUsername, String demoPassword) {
		Demo demo=demoRepository.findByDemoUsernameAndDemoPassword(demoUsername, demoPassword);
		return demo;
	}
}
