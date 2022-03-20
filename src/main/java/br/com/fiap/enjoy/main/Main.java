package br.com.fiap.enjoy.main;

import br.com.fiap.enjoy.mocks.BebidaMock;
import br.com.fiap.enjoy.mocks.ConsumoMock;
import br.com.fiap.enjoy.mocks.EstabelecimentoMock;
import br.com.fiap.enjoy.mocks.TipoBebidaMock;
import br.com.fiap.enjoy.mocks.UsuarioMock;
import br.com.fiap.enjoy.mocks.VisitaMock;

public class Main {

	public static void main(String[] args) {
	
		new EstabelecimentoMock(50);
		new UsuarioMock(15);
		new TipoBebidaMock(50);
 		new BebidaMock(50);
		new VisitaMock(50);
		new ConsumoMock(50);
	}
}
