package com.acme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acme.entity.EndPoint;

@Transactional
@Repository
public class EndPointDAOImpl implements EndPointDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EndPoint getEndPointById(int endPointId) {
		return entityManager.find(EndPoint.class, endPointId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EndPoint> getAllEndPoints() {
		String hql = "FROM EndPoint as endPoint ORDER BY endPoint.endPointId";
		return entityManager.createQuery(hql).getResultList();
	}
}
