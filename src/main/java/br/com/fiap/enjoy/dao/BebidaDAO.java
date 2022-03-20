package br.com.fiap.enjoy.dao;

import java.util.List;

import br.com.fiap.enjoy.domains.Bebida;
import br.com.fiap.enjoy.interfaces.BebidaDAOInterface;

public class BebidaDAO extends DAO implements BebidaDAOInterface {

	public BebidaDAO() {
		super();
	}

	@Override
	public List<Bebida> getAll() {
		initEntityManager();

		List<Bebida> bebidas = null;
		try {

			bebidas = em.createQuery("SELECT b FROM Bebida b", Bebida.class).getResultList();

			return bebidas;
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

		return bebidas;
	}

	@Override
	public Bebida getById(int id) {
		initEntityManager();

		Bebida bebida = null;
		try {

			bebida = em.find(Bebida.class, id);

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

		return bebida;
	}

	@Override
	public Bebida insert(Bebida bebida) {
		initEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(bebida);

			em.getTransaction().commit();

			return bebida;
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
	
	@Override
	public List<Bebida> insert(List<Bebida> bebidas) {
		initEntityManager();
		try {

			em.getTransaction().begin();
			
			bebidas.forEach(bebida -> em.persist(bebida));

			em.getTransaction().commit();

			return bebidas;
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
}
