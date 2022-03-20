package br.com.fiap.enjoy.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.fiap.enjoy.dao.UsuarioDAO;
import br.com.fiap.enjoy.domains.Usuario;
import br.com.fiap.enjoy.interfaces.UsuarioDAOInterface;
import net.datafaker.Faker;

public class UsuarioMock {

	public UsuarioMock() {
		this.criarUsuario(1);
	}

	public UsuarioMock(int results) {
		this.criarUsuario(results);
	}

	private void criarUsuario(int results) {
		UsuarioDAOInterface usuarioDAO = new UsuarioDAO();

		Faker faker = new Faker(new Locale("pt", "BR"));

		List<Usuario> usuarios = new ArrayList<Usuario>();

		for (int i = 0; i <= results; i++) {
			Usuario usuarioFalso = new Usuario();
			usuarioFalso.setNome(faker.name().fullName());
			usuarioFalso.setEmail(faker.internet().emailAddress());
			usuarioFalso.setSenha(faker.internet().password());
			usuarioFalso.setTelefone(faker.phoneNumber().cellPhone());
			usuarioFalso.setDtNascimento(faker.date().birthday());
			usuarios.add(usuarioFalso);
		}

		usuarioDAO.insert(usuarios);
	}
}
