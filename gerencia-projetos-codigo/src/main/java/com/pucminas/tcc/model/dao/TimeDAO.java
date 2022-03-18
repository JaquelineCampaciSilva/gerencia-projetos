package com.pucminas.tcc.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pucminas.tcc.model.Time;

@Repository
public class TimeDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();
	
	@Transactional
	public boolean configurarTime(Time time) {
		try {
			transaction.begin();
			em.persist(time);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
