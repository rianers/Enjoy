package br.com.fiap.enjoy.interfaces;

import java.util.List;

import br.com.fiap.enjoy.domains.TipoBebida;

public interface TipoBebidaDAOInterface {
	public List<TipoBebida> getAll();

	public TipoBebida getById(int id);

	public TipoBebida insert(TipoBebida tipoBebida);
	
	public List<TipoBebida> insert(List<TipoBebida> tipoBebida);
}
