package com.acme.service;

import java.util.List;

import com.acme.entity.ServiceInfo;

public interface ServiceInfoService {
	List<ServiceInfo> getAllServices();

	ServiceInfo getServiceById(int serviceId);
	
    boolean isServiceExistent(int serviceId);
}
