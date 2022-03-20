package br.com.fiap.enjoy.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.fiap.enjoy.dao.ConsumoDAO;
import br.com.fiap.enjoy.dao.VisitaDAO;
import br.com.fiap.enjoy.domains.Consumo;
import br.com.fiap.enjoy.domains.Visita;
import br.com.fiap.enjoy.interfaces.ConsumoDAOInterface;
import br.com.fiap.enjoy.interfaces.VisitaDAOInterface;
import br.com.fiap.enjoy.utils.MockUtils;
import net.datafaker.Faker;

public class ConsumoMock {
	public ConsumoMock() {
		this.criarConsumo(1);
	}

	public ConsumoMock(int results) {
		this.criarConsumo(results);
	}

	private void criarConsumo(int results) {
		ConsumoDAOInterface consumoDAO = new ConsumoDAO();
		VisitaDAOInterface visitaDAO = new VisitaDAO();

		Faker faker = new Faker(new Locale("pt", "BR"));

		List<Consumo> consumos = new ArrayList<Consumo>();
		List<Visita> visitas = visitaDAO.getAll();

		for (int i = 0; i <= results; i++) {
			Consumo consumoFake = new Consumo();
			consumoFake.setVisita(MockUtils.getRandomItem(visitas));
			consumoFake.setQtdMililitro((float)faker.number().numberBetween((long) 200, (long) 1000));
			consumos.add(consumoFake);
		}

		consumoDAO.insert(consumos);
	}
}
