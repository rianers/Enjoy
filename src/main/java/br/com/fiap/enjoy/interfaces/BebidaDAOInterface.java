package br.com.fiap.enjoy.interfaces;

import java.util.List;

import br.com.fiap.enjoy.domains.Bebida;

public interface BebidaDAOInterface {
	public List<Bebida> getAll();

	public Bebida getById(int id);

	public Bebida insert(Bebida bebida);

	public List<Bebida> insert(List<Bebida> bebidas);
}
