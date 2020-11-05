package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
public class Encomenda {

	@Id
	private long id;
	private String descricao;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="destino_fk")
	private Destino destino;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
	
}
