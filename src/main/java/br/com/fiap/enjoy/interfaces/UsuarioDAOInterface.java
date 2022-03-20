package br.com.fiap.enjoy.interfaces;

import java.util.List;

import br.com.fiap.enjoy.domains.Usuario;


public interface UsuarioDAOInterface {
	public List<Usuario> getAll();

	public Usuario getById(int id);

	public Usuario insert(Usuario user);
	
	public List<Usuario> insert(List<Usuario> user);
}
