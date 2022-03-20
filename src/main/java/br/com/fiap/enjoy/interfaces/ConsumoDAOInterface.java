package br.com.fiap.enjoy.interfaces;

import java.util.List;

import br.com.fiap.enjoy.domains.Consumo;

public interface ConsumoDAOInterface {
	public List<Consumo> getAll();

	public Consumo getById(int id);

	public Consumo insert(Consumo consumo);
	
	public List<Consumo> insert(List<Consumo> consumos);
}
