package br.com.fiap.enjoy.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.fiap.enjoy.dao.BebidaDAO;
import br.com.fiap.enjoy.dao.TipoBebidaDAO;
import br.com.fiap.enjoy.domains.Bebida;
import br.com.fiap.enjoy.domains.TipoBebida;
import br.com.fiap.enjoy.interfaces.BebidaDAOInterface;
import br.com.fiap.enjoy.interfaces.TipoBebidaDAOInterface;
import br.com.fiap.enjoy.utils.MockUtils;
import net.datafaker.Faker;

public class BebidaMock {

	public BebidaMock() {
		this.criarBebida(1);
	}

	public BebidaMock(int results) {
		this.criarBebida(results);
	}
	
	private void criarBebida(int results) {
		BebidaDAOInterface bebidaDAO = new BebidaDAO();
		TipoBebidaDAOInterface tipoBebidaDAO = new TipoBebidaDAO();
		Faker faker = new Faker(new Locale("pt", "BR"));

		List<Bebida> bebidas = new ArrayList<Bebida>();
		List<TipoBebida> tipoBebidas = tipoBebidaDAO.getAll();

		for (int i = 0; i <= results; i++) {
			Bebida bebidaFake = new Bebida();
			bebidaFake.setNome(faker.beer().name());
			bebidaFake.setVlMililitro((float)faker.number().numberBetween((int) 1, (int) 20));
			bebidaFake.setTipo(MockUtils.getRandomItem(tipoBebidas));
			bebidas.add(bebidaFake);
		}

		bebidaDAO.insert(bebidas);
	}
}