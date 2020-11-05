package br.ufac.si.tesi2.testes;

import br.ufac.si.tesi2.gerentes.*;
import br.ufac.si.tesi2.entidades.*;
import java.util.*;

public class AlunoTeste {

	public static void main(String[] args) {
		
		AlunoGerente ag = new AlunoGerente();
		Aluno a1, a2, a3;
		List<Aluno> alunos;
		
		a1 = new Aluno();
		a1.setNome("José");
		
		a2 = new Aluno();
		a2.setNome("Maria");
		
		a3 = new Aluno();
		a3.setNome("Jenniffer");
		
		ag.adicionar(a1);
		ag.adicionar(a2);
		ag.adicionar(a3);
		
		alunos = ag.recuperarTodos();	
		System.out.println("Listando alunos...");
		for (Aluno aluno : alunos) {
			System.out.println(aluno); // EXIGIU REESCRITA DO toString
		}
		
		alunos = ag.recuperarTodosPorNome();	
		System.out.println("Listando alunos, por nome...");
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
		
		alunos = ag.recuperarTodosPorNomeContendo("r");	
		System.out.println("Listando alunos, por nome, contendo 'r'...");
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}	
		
		ag.encerrar();
	}

}
