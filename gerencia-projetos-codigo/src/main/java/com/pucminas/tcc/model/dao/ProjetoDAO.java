package com.pucminas.tcc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pucminas.tcc.model.Projeto;

@Repository
public class ProjetoDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();
	
	public Projeto buscarProjeto(String id) {
		try {
			Projeto projeto = (Projeto) em
					.createQuery("SELECT u from Projeto u where u.id =:id")
					.setParameter("id", id)
					.getSingleResult();

			return projeto;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> buscarProjetos() {
		try {
			List<Projeto> projetos = (List<Projeto>) em
					.createQuery("SELECT u from Projeto u")
					.getResultList();

			return projetos;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	public boolean inserirProjeto(Projeto projeto) {
		try {
			transaction.begin();
			em.persist(projeto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
