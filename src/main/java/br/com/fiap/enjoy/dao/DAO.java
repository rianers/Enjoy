package br.com.fiap.enjoy.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

abstract class DAO {
	protected String persistentName = "enjoy";
	protected static EntityManager em = null;
	
	public DAO() {
		super();
	}

	protected void setPersistentName(String persistentName) {
		this.persistentName = persistentName;
	}

	protected void initEntityManager() {
		this.em = Persistence.createEntityManagerFactory(this.persistentName).createEntityManager();
	}
}
