package br.ufac.si.tesi2.gerentes;

import java.util.*;

import javax.persistence.*;
import br.ufac.si.tesi2.entidades.*;

public class AlunoGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AlunoGerente() {
		emf = Persistence.createEntityManagerFactory("IntroducaoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public Aluno recuperar(long id) {
		return em.find(Aluno.class, id);
	}
	
	public void atualizar(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}
	
	public void remover(Aluno aluno) {
		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
	}
	
	public List<Aluno> recuperarTodos(){
		return em.createNamedQuery("Aluno.todos")
				.getResultList();	
	}

	public List<Aluno> recuperarTodosPorNome(){
		return em.createNamedQuery("Aluno.todosPorNome")
				.getResultList();
	}
	
	public List<Aluno> recuperarTodosPorNomeContendo(String termo){
		return em
				.createNamedQuery("Aluno.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
}
