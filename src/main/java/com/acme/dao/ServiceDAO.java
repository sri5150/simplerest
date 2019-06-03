package com.acme.dao;

import java.util.List;

import com.acme.entity.ServiceInfo;

public interface ServiceDAO {
	
	List<ServiceInfo> getAllServices();

	ServiceInfo getServiceById(int serviceId);
	
    boolean isServiceExistent(int serviceId);
}
