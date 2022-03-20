package br.com.fiap.enjoy.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.fiap.enjoy.dao.TipoBebidaDAO;
import br.com.fiap.enjoy.domains.TipoBebida;
import br.com.fiap.enjoy.interfaces.TipoBebidaDAOInterface;
import net.datafaker.Faker;

public class TipoBebidaMock {

	public TipoBebidaMock() {
		this.createTipoBebida(1);
	}

	public TipoBebidaMock(int results) {
		this.createTipoBebida(results);
	}

	private void createTipoBebida(int results) {
		TipoBebidaDAOInterface tipoBebidaDAO = new TipoBebidaDAO();

		Faker faker = new Faker(new Locale("pt", "BR"));

		List<TipoBebida> tipoBebidas = new ArrayList<TipoBebida>();

		for (int i = 0; i <= results; i++) {
			TipoBebida tipoBebida = new TipoBebida();
			tipoBebida.setNome(faker.beer().name());
			tipoBebida.setPctAlcoolico((float) faker.number().numberBetween((long) 2.1, (long) 10.9));
			tipoBebidas.add(tipoBebida);
		}

		tipoBebidaDAO.insert(tipoBebidas);
	}
}
