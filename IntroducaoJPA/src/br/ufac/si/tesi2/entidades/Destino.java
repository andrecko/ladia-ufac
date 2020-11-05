package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
public class Destino {

	@Id
	private long id;
	private String cidade;
	private String cep;
	@OneToOne(mappedBy="destino")
	private Encomenda encomenda;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Encomenda getEncomenda() {
		return encomenda;
	}
	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}
}
