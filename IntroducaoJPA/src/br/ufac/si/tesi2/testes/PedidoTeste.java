package br.ufac.si.tesi2.testes;

import br.ufac.si.tesi2.gerentes.*;
import br.ufac.si.tesi2.entidades.*;

public class PedidoTeste {

	public static void main(String[] args) {
		
		PedidoGerente pg = new PedidoGerente();
		Pedido p1, p2;
		Item i1, i2, i3, i4, i5;

		p1 = new Pedido();
		p1.setStatus("Em trânsito");
		
		p2 = new Pedido();
		p2.setStatus("Aguardando pagamento");

		i1 = new Item();
		i1.setQuantidade(10);
		//i1.setPedido(p1); 	//USAMOS NO BIDIRECIONAL

		i2 = new Item();
		i2.setQuantidade(15);
		//i2.setPedido(p1);		//USAMOS NO BIDIRECIONAL
		
		i3 = new Item();
		i3.setQuantidade(20);
		//i3.setPedido(p1);		//USAMOS NO BIDIRECIONAL
		
		i4 = new Item();
		i4.setQuantidade(25);
		//i4.setPedido(p2);		//USAMOS NO BIDIRECIONAL	
		
		i5 = new Item();
		i5.setQuantidade(30);
		//i5.setPedido(p2);		//USAMOS NO BIDIRECIONAL
		
		p1.adicionarItem(i1);
		p1.adicionarItem(i2);
		p1.adicionarItem(i3);
		
		p2.adicionarItem(i4);
		p2.adicionarItem(i5);
		
		pg.adicionar(p1);
		pg.adicionar(p2);
		
		p1.removerItem(i2);
		pg.atualizar(p1);
				
		pg.encerrar();
	}

}
