package br.ufac.si.tesi2.testes;

import br.ufac.si.tesi2.gerentes.*;
import br.ufac.si.tesi2.entidades.*;

public class ProjetoTeste {

	public static void main(String[] args) {
		
		ProjetoGerente pg = new ProjetoGerente();
		Projeto p1, p2;
		Colaborador c1, c2, c3;

		p1 = new Projeto();
		p1.setDescricao("Livro Azul");
		
		p2 = new Projeto();
		p2.setDescricao("Outubro Rosa");

		c1 = new Colaborador();
		c1.setNome("Francisco");
	
		c2 = new Colaborador();
		c2.setNome("Carlos");
		
		c3 = new Colaborador();
		c3.setNome("Aline");
	
		p1.adicionarColaborador(c1);
		p1.adicionarColaborador(c2);
		
		p2.adicionarColaborador(c2);
		p2.adicionarColaborador(c3);
		
		pg.adicionar(p1);
		pg.adicionar(p2);
				
		pg.encerrar();
	}

}
