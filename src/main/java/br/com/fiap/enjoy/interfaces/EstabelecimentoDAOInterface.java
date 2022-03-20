package br.com.fiap.enjoy.interfaces;

import java.util.List;
import br.com.fiap.enjoy.domains.Estabelecimento;

public interface EstabelecimentoDAOInterface {
	
	public List<Estabelecimento> getAll();

	public Estabelecimento getById(int id);

	public Estabelecimento insert(Estabelecimento estabelecimento);
	
	public List<Estabelecimento> insert(List<Estabelecimento> estabelecimento);
}
