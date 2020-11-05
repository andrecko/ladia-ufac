package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Aluno.todos", 
		query="SELECT a FROM Aluno a"), 
	@NamedQuery(name="Aluno.todosPorNome", 
		query="SELECT a FROM Aluno a ORDER BY a.nome"),
	@NamedQuery(name="Aluno.todosPorNomeContendo", 
		query="SELECT a FROM Aluno a WHERE a.nome LIKE :termo ORDER BY a.nome")		
})
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=50)
	private String nome;

	public Aluno(){}
	
	public Aluno(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//SOBRESCREVENDO PARA APRESENTAR ALGO LEGÍVEL
	public String toString() {
		return String.format("Aluno [id=%d, nome=\"%s\"]", 
				this.id, this.nome);
	}
}
