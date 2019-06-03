package com.acme.dao;

import java.util.List;

import com.acme.entity.EndPoint;

public interface EndPointDAO {
	
	List<EndPoint> getAllEndPoints();

	EndPoint getEndPointById(int endPointId);
}
