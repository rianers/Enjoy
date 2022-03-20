package br.com.fiap.enjoy.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.enjoy.dao.EstabelecimentoDAO;
import br.com.fiap.enjoy.dao.UsuarioDAO;
import br.com.fiap.enjoy.dao.VisitaDAO;
import br.com.fiap.enjoy.domains.Estabelecimento;
import br.com.fiap.enjoy.domains.Usuario;
import br.com.fiap.enjoy.domains.Visita;
import br.com.fiap.enjoy.interfaces.EstabelecimentoDAOInterface;
import br.com.fiap.enjoy.interfaces.UsuarioDAOInterface;
import br.com.fiap.enjoy.interfaces.VisitaDAOInterface;
import br.com.fiap.enjoy.utils.MockUtils;

public class VisitaMock {
	public VisitaMock() {
		this.criarVisita(1);
	}

	public VisitaMock(int results) {
		this.criarVisita(results);
	}
	
	private void criarVisita(int results) {
		VisitaDAOInterface visitaDAO = new VisitaDAO();
		UsuarioDAOInterface usuarioDAO = new UsuarioDAO();
		EstabelecimentoDAOInterface estabelecimentoDAO = new EstabelecimentoDAO();

		List<Visita> visitas = new ArrayList<Visita>();
		List<Usuario> usuarios = usuarioDAO.getAll();
		List<Estabelecimento> estabelecimentos = estabelecimentoDAO.getAll();
		
		for (int i = 0; i <= results; i++) {
			Visita visitaFake = new Visita();
			visitaFake.setUser(MockUtils.getRandomItem(usuarios));
			visitaFake.setEstabelecimento(MockUtils.getRandomItem(estabelecimentos));
			visitas.add(visitaFake);
		}

		visitaDAO.insert(visitas);
	}
}

