package com.acme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.entity.ServiceInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDAOTest {

	@Autowired
	private ServiceDAO serviceDAO;

	@Test
	public void testGetServiceById() {
		ServiceInfo serviceInfo = serviceDAO.getServiceById(1);
		assertNotNull(serviceInfo);
		assertTrue(serviceInfo.getDescription().contains("Services to monitor Operations"));
	}

	@Test
	public void testGetAllServices() {
		List<ServiceInfo> list = serviceDAO.getAllServices();
		assertNotNull(list);
		assertEquals(2, list.size());
	}

}