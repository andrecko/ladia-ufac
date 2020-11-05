package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Física")
public class PessoaFisica extends Pessoa {

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
