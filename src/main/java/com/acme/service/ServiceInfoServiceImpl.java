package com.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.dao.ServiceDAO;
import com.acme.entity.ServiceInfo;


@Service
public class ServiceInfoServiceImpl implements ServiceInfoService {
	@Autowired
	private ServiceDAO serviceDAO;

	@Override
	public ServiceInfo getServiceById(int serviceId) {
		return serviceDAO.getServiceById(serviceId);
	}

	@Override
	public List<ServiceInfo> getAllServices() {
		return serviceDAO.getAllServices();
	}

	@Override
	public boolean isServiceExistent(int serviceId) {
		return serviceDAO.isServiceExistent(serviceId);
	}
}
