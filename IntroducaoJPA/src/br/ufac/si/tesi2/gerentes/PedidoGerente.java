package br.ufac.si.tesi2.gerentes;

import javax.persistence.*;
import br.ufac.si.tesi2.entidades.*;

public class PedidoGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PedidoGerente() {
		emf = Persistence.createEntityManagerFactory("IntroducaoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Pedido pedido) {

		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
		
	}
	
	public Pedido recuperar(long id) {
		return em.find(Pedido.class, id);
	}
	
	public void atualizar(Pedido pedido) {
		
		em.getTransaction().begin();
		em.merge(pedido);
		em.getTransaction().commit();
		
	}
	
	public void remover(Pedido pedido) {
		
		em.getTransaction().begin();
		em.remove(pedido);
		em.getTransaction().commit();
		
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
