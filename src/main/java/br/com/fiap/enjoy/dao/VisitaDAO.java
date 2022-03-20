package br.com.fiap.enjoy.dao;

import java.util.List;

import br.com.fiap.enjoy.domains.Visita;
import br.com.fiap.enjoy.interfaces.VisitaDAOInterface;

public class VisitaDAO extends DAO implements VisitaDAOInterface {

	public VisitaDAO() {
		super();
	}

	@Override
	public List<Visita> getAll() {
		initEntityManager();
		List<Visita> visitas = null;
		try {

			visitas = em.createQuery("SELECT v FROM Visita v", Visita.class).getResultList();

			return visitas;
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

		return visitas;
	}

	@Override
	public Visita getById(int id) {
		initEntityManager();
		Visita visita = null;
		try {

			visita = em.find(Visita.class, id);

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

		return visita;
	}

	@Override
	public Visita insert(Visita visita) {
		initEntityManager();
		try {

			em.getTransaction().begin();

			em.persist(visita);

			em.getTransaction().commit();

			return visita;
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
	public List<Visita> insert(List<Visita> visitas) {
		initEntityManager();
		try {

			em.getTransaction().begin();
			
			visitas.forEach(visita -> em.persist(visita));

			em.getTransaction().commit();

			return visitas;
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
