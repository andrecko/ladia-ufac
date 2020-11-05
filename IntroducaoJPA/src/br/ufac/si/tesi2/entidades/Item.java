package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double quantidade;
//	@ManyToOne(cascade=CascadeType.ALL)		// USAMOS PARA CRIAR, 
//	@JoinColumn(name="pedido")				// SUBSEQUENTEMNETE,
//	private Pedido pedido;					// O BIDIRECIOINAL.
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
//	public Pedido getPedido() {
//		return pedido;
//	}
//	public void setPedido(Pedido pedido) {
//		this.pedido = pedido;
//	}
	
}
