package com.acme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acme.entity.ServiceInfo;


@Transactional
@Repository
public class ServiceDAOImpl implements ServiceDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ServiceInfo getServiceById(int serviceId) {
		return entityManager.find(ServiceInfo.class, serviceId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceInfo> getAllServices() {
		String hql = "FROM ServiceInfo as srvcInfo ORDER BY srvcInfo.serviceId";
		return entityManager.createQuery(hql).getResultList();
	}
	
	@Override	
    public boolean isServiceExistent(int id) {
		
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT COUNT(s) FROM ServiceInfo s where s.serviceId=:id", Long.class);
		long count = query.setParameter("id", id).getSingleResult();
		return count > 0 ? true : false;
	}
}
