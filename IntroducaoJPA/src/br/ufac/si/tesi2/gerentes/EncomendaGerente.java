package br.ufac.si.tesi2.gerentes;

import javax.persistence.*;
import br.ufac.si.tesi2.entidades.*;

public class EncomendaGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EncomendaGerente() {
		emf = Persistence.createEntityManagerFactory("IntroducaoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Encomenda encomenda) {

		em.getTransaction().begin();
		em.persist(encomenda);
		em.getTransaction().commit();
		
	}
	
	public Encomenda recuperar(long id) {
		return em.find(Encomenda.class, id);
	}
	
	public void atualizar(Encomenda encomenda) {
		
		em.getTransaction().begin();
		em.merge(encomenda);
		em.getTransaction().commit();
		
	}
	
	public void remover(Encomenda encomenda) {
		
		em.getTransaction().begin();
		em.remove(encomenda);
		em.getTransaction().commit();
		
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
