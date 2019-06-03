package com.acme.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.entity.ServiceInfo;
import com.acme.service.ServiceInfoService;

@RestController
@RequestMapping("/acme")
public class ServiceInfoController {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceInfoController.class);
	
	@Autowired
	private ServiceInfoService serviceInfoService;
	
	@GetMapping("/service/{id}")
	public ResponseEntity<ServiceInfo> getServiceById(@PathVariable("id") Integer id) {
		
		logger.info("Obtaining service with id:{}", id);
		
		if(serviceInfoService.isServiceExistent(id)) {
			ServiceInfo serviceInfo = serviceInfoService.getServiceById(id);
			return new ResponseEntity<>(serviceInfo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/services")
	public ResponseEntity<List<ServiceInfo>> getAllServices() {
		List<ServiceInfo> list = serviceInfoService.getAllServices();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
		
} 