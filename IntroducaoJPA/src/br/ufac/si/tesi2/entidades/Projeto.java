package br.ufac.si.tesi2.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Colaborador> colaboradores = new ArrayList<Colaborador>();

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

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	public void adicionarColaborador(Colaborador c) {
		this.colaboradores.add(c);
	}

	public void removeColaborador(Colaborador c) {
		this.colaboradores.remove(c);
	}

	
}
