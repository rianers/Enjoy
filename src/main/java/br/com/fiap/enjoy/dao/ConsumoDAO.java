package br.com.fiap.enjoy.dao;

import java.util.List;

import br.com.fiap.enjoy.domains.Consumo;
import br.com.fiap.enjoy.interfaces.ConsumoDAOInterface;

public class ConsumoDAO extends DAO implements ConsumoDAOInterface {

	public ConsumoDAO() {
		super();
	}

	@Override
	public List<Consumo> getAll() {
		initEntityManager();

		List<Consumo> consumos = null;
		try {

			consumos = em.createQuery("SELECT c FROM Consumo c", Consumo.class).getResultList();

			return consumos;
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

		return consumos;
	}

	@Override
	public Consumo getById(int id) {
		initEntityManager();

		Consumo consumo = null;
		try {

			consumo = em.find(Consumo.class, id);

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

		return consumo;
	}

	@Override
	public Consumo insert(Consumo consumo) {
		initEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(consumo);

			em.getTransaction().commit();

			return consumo;
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
	public List<Consumo> insert(List<Consumo> consumos) {
		initEntityManager();
		try {

			em.getTransaction().begin();
			
			consumos.forEach(consumo -> em.persist(consumo));

			em.getTransaction().commit();

			return consumos;
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
