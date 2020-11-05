package br.ufac.si.tesi2.gerentes;

import javax.persistence.*;
import br.ufac.si.tesi2.entidades.*;

public class PessoaGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PessoaGerente() {
		emf = Persistence.createEntityManagerFactory("IntroducaoJPA");
		em = emf.createEntityManager();
	}

	public void adicionarPf(PessoaFisica pf) {

		em.getTransaction().begin();
		em.persist(pf);
		em.getTransaction().commit();
		
	}
	
	public void adicionarPj(PessoaJuridica pj) {

		em.getTransaction().begin();
		em.persist(pj);
		em.getTransaction().commit();
		
	}
	
	public PessoaFisica recuperarPf(long id) {
		return em.find(PessoaFisica.class, id);
	}

	public PessoaJuridica recuperarPj(long id) {
		return em.find(PessoaJuridica.class, id);
	}	
	
	public void atualizarPf(PessoaFisica pf) {
		
		em.getTransaction().begin();
		em.merge(pf);
		em.getTransaction().commit();
		
	}
	
	public void atualizarPj(PessoaJuridica pj) {
		
		em.getTransaction().begin();
		em.merge(pj);
		em.getTransaction().commit();
		
	}

	public void removerPf(PessoaFisica pf) {
		
		em.getTransaction().begin();
		em.remove(pf);
		em.getTransaction().commit();
		
	}
	
	public void removerPf(PessoaJuridica pj) {
		
		em.getTransaction().begin();
		em.remove(pj);
		em.getTransaction().commit();
		
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
