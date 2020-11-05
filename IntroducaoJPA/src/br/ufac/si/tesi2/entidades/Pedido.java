package br.ufac.si.tesi2.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String status;

//	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)	// USAMOS NO BIDIRECIONAL DO ManyToOne
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)						// SEM O JoinColumn, UNIDIRECIONAL COM TABELA DE JUNÇÃO 
	@JoinColumn(name="pedido")								// COM ISSO, UNIDIRECIONAL SEM TABELA DE JUNÇÃO (lol)
	private List<Item> itens = new ArrayList<Item>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public void adicionarItem(Item item) {
		
		this.itens.add(item);
		//item.setPedido(this);		// USAMOS NO BIDIREICONAL
		
	}
	
	public void removerItem(Item item) {
		this.itens.remove(item);
		//item.setPedido(null);		// USAMOS NO BIDIREICONAL
	}
	
}
