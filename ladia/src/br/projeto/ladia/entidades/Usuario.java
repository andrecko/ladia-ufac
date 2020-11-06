package br.projeto.ladia.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.todos", 
		query="SELECT u FROM Usuario u"), 
	@NamedQuery(name="Usuario.todosPorNome", 
		query="SELECT u FROM Usuario u ORDER BY u.nome"),
	@NamedQuery(name="Usuario.todosPorNomeContendo", 
		query="SELECT u FROM Usuario u WHERE u.nome LIKE :termo ORDER BY u.nome")		
})
@Table(name="usuarios")
public class Usuario {

	@Id
	private long matricula;
	
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=true, length=100)
	private String email;
	@Column(nullable=false, length=60)
	private String endereco;
	@Column(nullable=false, length=11)
	private String fone;
	@Column(nullable=true, length=8)
	private String cep;
	@Column(nullable=false, length=1)
	private String sexo;
	@Column(nullable=false)
	private boolean permissao;
	@Column(nullable=false)
	private boolean ativo;

/*	@ManyToOne()
	@JoinColumn(name="curso")
	private Curso curso;*/
	
	public Usuario () {}
	
//	public Usuario(long matricula, String nome, String endereco, String fone, String cep, String sexo/*, Curso curso*/) {
//		this.matricula = matricula;
//		this.nome = nome;
//		this.endereco = endereco;
//		this.fone = fone;
//		this.cep = cep;
//		this.sexo = sexo;
//		this.curso = curso;
//	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isPermissao() {
		return permissao;
	}
	
	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

/*	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}*/


	//SOBRESCREVENDO PARA APRESENTAR ALGO LEGÍVEL
/*	public String toString() {
		return String.format("Usuário [matrícula=%d, "
				+ "nome=\"%s\", "
				+ "endereço=\"%s\", "
				+ "fone=\"%s\", "
				+ "cep=\"%s\", "
				+ "sexo=\"%s\"]",
//				+ "curso=\"%s\"]", 
				this.matricula, 
				this.nome,
				this.endereco,
				this.fone,
				this.cep,
				this.sexo);
//				this.curso);
	}*/
}
