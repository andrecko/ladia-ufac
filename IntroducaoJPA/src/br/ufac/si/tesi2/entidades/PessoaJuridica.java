package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Jurídica")
public class PessoaJuridica extends Pessoa {

	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
