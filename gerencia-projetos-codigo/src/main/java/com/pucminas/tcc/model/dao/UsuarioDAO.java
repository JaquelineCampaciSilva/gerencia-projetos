package com.pucminas.tcc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pucminas.tcc.model.Usuario;

@Repository
public class UsuarioDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();
	
	public Usuario buscarUsuario(String email, String senha) {
		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.email =:email and u.senha = :senha")
					.setParameter("email", email)
					.setParameter("senha", senha)
					.getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Usuario buscarUsuario(Long id) {
		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.id =:id")
					.setParameter("id", id)
					.getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarFuncionais() {
		try {
			List<Usuario> funcionais = (List<Usuario>) em
					.createQuery("SELECT u from Usuario u where u.perfil =:perfil")
					.setParameter("perfil", "Funcional")
					.getResultList();

			return funcionais;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarGerentes() {
		try {
			List<Usuario> gerentes = (List<Usuario>) em
					.createQuery("SELECT u from Usuario u where u.perfil =:perfil")
					.setParameter("perfil", "Gerente de Projeto")
					.getResultList();

			return gerentes;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarArquitetos() {
		try {
			List<Usuario> arquitetos = (List<Usuario>) em
					.createQuery("SELECT u from Usuario u where u.perfil =:perfil")
					.setParameter("perfil", "Arquiteto")
					.getResultList();

			return arquitetos;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarDesenvolvedores() {
		try {
			List<Usuario> desenvolvedores = (List<Usuario>) em
					.createQuery("SELECT u from Usuario u where u.perfil =:perfil")
					.setParameter("perfil", "Desenvolvedor")
					.getResultList();

			return desenvolvedores;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarArquitetosQA() {
		try {
			List<Usuario> arquitetosQA = (List<Usuario>) em
					.createQuery("SELECT u from Usuario u where u.perfil =:perfil")
					.setParameter("perfil", "QA")
					.getResultList();

			return arquitetosQA;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	public boolean inserirUsuario(Usuario usuario) {
		try {
			transaction.begin();
			em.persist(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
