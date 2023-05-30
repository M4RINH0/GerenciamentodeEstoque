package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdministradorFiliais {
	private List<Filial> banco;
	AdministradorFiliais(){
		this.banco = new ArrayList<>();
	}
	public void adicionarFilial(Filial filial) {
		
		banco.add(filial);
	}
	public void listarTudo() {
		for(Filial m : banco) {
			System.out.println(m.getNome()+ ": ");
			m.listarProdutos();
		}
	}
	public void buscarFilial(String nome) {
		for(Filial m : banco) {
			
			if(m.getNome()== nome) {
				m.listarProdutos();
			}else {
				
			}
		}
	}
	public void buscarProduto(String cp) {
		for(Filial m : banco) {
			m.buscarProduto(cp);
		}
	}

}
