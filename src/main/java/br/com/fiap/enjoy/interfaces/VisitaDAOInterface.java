package br.com.fiap.enjoy.interfaces;

import java.util.List;

import br.com.fiap.enjoy.domains.Visita;

public interface VisitaDAOInterface {
	public List<Visita> getAll();

	public Visita getById(int id);

	public Visita insert(Visita visita);
	
	public List<Visita> insert (List<Visita> visitas);
}
