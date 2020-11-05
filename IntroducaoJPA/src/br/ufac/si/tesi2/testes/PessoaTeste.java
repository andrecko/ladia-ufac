package br.ufac.si.tesi2.testes;

import br.ufac.si.tesi2.gerentes.*;
import br.ufac.si.tesi2.entidades.*;

public class PessoaTeste {

	public static void main(String[] args) {
		
		PessoaGerente ag = new PessoaGerente();
		PessoaFisica pf1, pf2;
		PessoaJuridica pj1, pj2;
		
		pf1 = new PessoaFisica();
		//pf1.setId(123);
		pf1.setNome("José");
		pf1.setCpf("123");
		
		pf2 = new PessoaFisica();
		//pf2.setId(456);
		pf2.setNome("Maria");
		pf2.setCpf("456");
		
		pj1 = new PessoaJuridica();
		//pj1.setId(1234);
		pj1.setNome("Casa da Sogra");
		pj1.setCnpj("1234");
		
		pj2 = new PessoaJuridica();
		//pj2.setId(5678);
		pj2.setNome("Tardizinha");
		pj2.setCnpj("5678");		
		
		ag.adicionarPf(pf1);
		ag.adicionarPf(pf2);
		ag.adicionarPj(pj1);
		ag.adicionarPj(pj2);
		
		ag.encerrar();
	}

}
