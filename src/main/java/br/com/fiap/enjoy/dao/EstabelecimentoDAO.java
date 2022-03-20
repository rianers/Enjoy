package br.com.fiap.enjoy.dao;

import java.util.List;

import br.com.fiap.enjoy.domains.Estabelecimento;
import br.com.fiap.enjoy.interfaces.EstabelecimentoDAOInterface;

public class EstabelecimentoDAO extends DAO implements EstabelecimentoDAOInterface {
	public EstabelecimentoDAO() {
		super();
	}

	@Override
	public List<Estabelecimento> getAll() {
		initEntityManager();

		List<Estabelecimento> estabelecimentos = null;
		try {

			estabelecimentos = em.createQuery("SELECT e FROM Estabelecimento e", Estabelecimento.class).getResultList();

			return estabelecimentos;
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

		return estabelecimentos;
	}

	@Override
	public Estabelecimento getById(int id) {
		initEntityManager();
		Estabelecimento estabelecimento = null;
		try {

			estabelecimento = em.find(Estabelecimento.class, id);

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

		return estabelecimento;
	}

	@Override
	public Estabelecimento insert(Estabelecimento estabelecimento) {
		initEntityManager();
		try {

			em.getTransaction().begin();

			em.persist(estabelecimento);

			em.getTransaction().commit();

			return estabelecimento;
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
	public List<Estabelecimento> insert(List<Estabelecimento> estabelecimentos) {
		initEntityManager();
		try {

			em.getTransaction().begin();

			estabelecimentos.forEach(item -> em.persist(item));

			em.getTransaction().commit();

			return estabelecimentos;
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
