package br.ufac.si.tesi2.entidades;

import javax.persistence.*;

@Entity
// SE A ABORDAGEM DE "TABLE_PER_CLASS", 
// NÃO USAR GERADORES DE VALORES PARA IDs
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo")
public abstract class Pessoa {

	@Id
	// NÃO USAR COM A ABORDAGEM DE "TABLE_PER_CLASS"
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	private String nome;
	
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
	
}
