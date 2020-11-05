package br.ufac.si.tesi2.gerentes;

import javax.persistence.*;
import br.ufac.si.tesi2.entidades.*;

public class ProjetoGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProjetoGerente() {
		emf = Persistence.createEntityManagerFactory("IntroducaoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Projeto projeto) {

		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
		
	}
	
	public Projeto recuperar(long id) {
		return em.find(Projeto.class, id);
	}
	
	public void atualizar(Projeto projeto) {
		
		em.getTransaction().begin();
		em.merge(projeto);
		em.getTransaction().commit();
		
	}
	
	public void remover(Projeto projeto) {
		
		em.getTransaction().begin();
		em.remove(projeto);
		em.getTransaction().commit();
		
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
