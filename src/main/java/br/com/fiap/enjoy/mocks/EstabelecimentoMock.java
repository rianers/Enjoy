package br.com.fiap.enjoy.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.fiap.enjoy.dao.EstabelecimentoDAO;
import br.com.fiap.enjoy.domains.Estabelecimento;
import br.com.fiap.enjoy.interfaces.EstabelecimentoDAOInterface;
import net.datafaker.Faker;

public class EstabelecimentoMock {
	public EstabelecimentoMock() {
		this.criarEstabelecimento(1);
	}

	public EstabelecimentoMock(int results) {
		this.criarEstabelecimento(results);
	}

	private void criarEstabelecimento(int results) {

		EstabelecimentoDAOInterface EstabelecimentoDAO = new EstabelecimentoDAO();

		Faker faker = new Faker(new Locale("pt", "BR"));

		List<Estabelecimento> estabelecimentosFalsos = new ArrayList<Estabelecimento>();

		for (int i = 0; i < results; i++) {
			Estabelecimento estabelecimentoFalso = new Estabelecimento();
			estabelecimentoFalso.setNome(faker.restaurant().name());
			estabelecimentoFalso.setEndereco(faker.address().fullAddress());
			estabelecimentoFalso.setCep(faker.address().zipCode());
			estabelecimentoFalso.setCnpj(faker.cnpj().valid());
			estabelecimentosFalsos.add(estabelecimentoFalso);
		}
		
		EstabelecimentoDAO.insert(estabelecimentosFalsos);

		EstabelecimentoDAO.getAll().forEach(item -> System.out.println(item));
	}
}
