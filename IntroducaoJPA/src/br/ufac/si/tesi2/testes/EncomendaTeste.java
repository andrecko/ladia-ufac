package br.ufac.si.tesi2.testes;

import br.ufac.si.tesi2.gerentes.*;
import br.ufac.si.tesi2.entidades.*;

public class EncomendaTeste {

	public static void main(String[] args) {
		
		EncomendaGerente eg = new EncomendaGerente();
		Encomenda e1, e2, e3, e4;
		Destino d1, d2, d3, d4;

		e1 = new Encomenda();
		e1.setId(123);
		e1.setDescricao("Em trânsito");

		e2 = new Encomenda();
		e2.setId(456);
		e2.setDescricao("Aguardando pagamento");
		
		d1 = new Destino();
		d1.setId(12);
		d1.setCidade("Rio Branco");
		d1.setCep("69900");
		
		d2 = new Destino();
		d2.setId(45);
		d2.setCidade("Vila Califórnia");
		d2.setCep("78840");
		
		e3 = new Encomenda();
		e3.setId(788);
		e3.setDescricao("Cancelado");
		
		d3 = new Destino();
		d3.setId(78);
		d3.setCidade("Xapuri");
		d3.setCep("12345");
	
		e1.setDestino(d1);
		e2.setDestino(d2);
		
		eg.adicionar(e1);
		eg.adicionar(e2);
		eg.adicionar(e3);
		
		e1.setDescricao("Pagamento efetuado");
		e1.getDestino().setCep("99999");

		eg.atualizar(e1);
		
		e4 = eg.recuperar(123);
		d4 = e4.getDestino();
		
		System.out.printf("Encomenda: %s, Destino: %s\n", 
				e4.getId(), d4.getId());
		System.out.printf("Encomenda: %s, Destino: %s\n", 
				d4.getEncomenda().getId(), e4.getDestino().getId());
		
		eg.encerrar();
	}

}
