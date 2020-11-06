package br.projeto.ladia.testes;

import java.util.List;

import br.projeto.ladia.entidades.Usuario;
import br.projeto.ladia.gerentes.UsuarioGerente;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		UsuarioGerente ug = new UsuarioGerente();
		Usuario u1, u2, u3;
		List<Usuario> usuarios;
		
//		u1 = new Usuario(1, "Andréyyy", "Rua tal", "999999999", "6999999", "M");
		
//		ug.adicionar(u1);
		
/*		usuarios = ug.recuperarTodos();
		System.out.println("Listando usuários...");
		for(Usuario usuario : usuarios) {
			System.out.println(usuario);
		}*/
		
//		ug.recuperar(1);
//		ug.atualizar(u1);
		
		ug.remover(ug.recuperar(1));
		
		ug.encerrar();

	}

}
