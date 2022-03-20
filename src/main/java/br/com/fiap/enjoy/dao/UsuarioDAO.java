package br.com.fiap.enjoy.dao;

import java.util.List;

import br.com.fiap.enjoy.domains.Usuario;
import br.com.fiap.enjoy.interfaces.UsuarioDAOInterface;

public class UsuarioDAO extends DAO implements UsuarioDAOInterface {

	public UsuarioDAO() {
		super();
	}

	public List<Usuario> getAll() {
		initEntityManager();

		List<Usuario> users = null;
		try {

			users = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

			return users;
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return users;
	}

	public Usuario getById(int id) {
		initEntityManager();
		Usuario user = null;
		try {

			user = em.find(Usuario.class, id);

		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return user;
	}

	public Usuario insert(Usuario user) {
		initEntityManager();
		try {

			em.getTransaction().begin();

			em.persist(user);

			em.getTransaction().commit();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return null;
	}
	
	public List<Usuario> insert(List<Usuario > users) {
		initEntityManager();
		try {

			em.getTransaction().begin();
			
			users.forEach(user -> em.persist(user));

			em.getTransaction().commit();

			return users;
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return null;
	}

	public void remove(int id) {
		initEntityManager();

		try {

			em.getTransaction().begin();

			Usuario user = em.find(Usuario.class, id);

			em.remove(user);

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
