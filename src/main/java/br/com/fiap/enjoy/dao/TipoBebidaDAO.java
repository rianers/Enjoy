package br.com.fiap.enjoy.dao;

import java.util.List;

import br.com.fiap.enjoy.domains.TipoBebida;
import br.com.fiap.enjoy.interfaces.TipoBebidaDAOInterface;

public class TipoBebidaDAO extends DAO implements TipoBebidaDAOInterface {

	public TipoBebidaDAO() {
		super();
	}

	@Override
	public List<TipoBebida> getAll() {
		initEntityManager();

		List<TipoBebida> tiposBebidas = null;
		try {

			tiposBebidas = em.createQuery("SELECT tp FROM TipoBebida tp", TipoBebida.class).getResultList();

			return tiposBebidas;
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

		return tiposBebidas;
	}

	@Override
	public TipoBebida getById(int id) {
		initEntityManager();

		TipoBebida tipoBebida = null;
		try {

			tipoBebida = em.find(TipoBebida.class, id);

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

		return tipoBebida;
	}

	@Override
	public TipoBebida insert(TipoBebida tipoBebida) {
		initEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(tipoBebida);

			em.getTransaction().commit();

			return tipoBebida;
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
	public List<TipoBebida> insert(List<TipoBebida> tipoBebidas) {
		initEntityManager();

		try {

			em.getTransaction().begin();

			tipoBebidas.forEach(item -> em.persist(item));

			em.getTransaction().commit();

			return tipoBebidas;
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
