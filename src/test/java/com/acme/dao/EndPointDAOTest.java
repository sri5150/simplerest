package com.acme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.entity.EndPoint;
import com.acme.entity.HttpVerb;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EndPointDAOTest {

	@Autowired
	private EndPointDAO endPointDAO;

	@Test
	public void testGetEndPointById() {
		EndPoint endPoint = endPointDAO.getEndPointById(1);
		assertNotNull(endPoint);
		assertEquals(1, endPoint.getServiceInfo().getServiceId());
		assertEquals(HttpVerb.GET, endPoint.getVerb());
		
	}

	@Test
	public void testGetAllEndPoints() {
		List<EndPoint> endPoints = endPointDAO.getAllEndPoints();
		assertNotNull(endPoints);
		assertEquals(5, endPoints.size());		
	}

}