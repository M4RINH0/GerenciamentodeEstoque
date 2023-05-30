package modelo;

public class Ferramentas extends Produto {
	private String marca;
	private int unidadePacote;

	public Ferramentas(String codigoProduto, double valor, int quantidade, String marca, String nome, int unidadePacote) {
		super(codigoProduto, valor, quantidade, nome);
		this.marca = marca;
		this.unidadePacote = unidadePacote;
	}
	
	public int getUnidade() {
		return unidadePacote;
	}
	
	public String getMarca() {
		return marca;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public String toString() {
		return "Nome: "+ nome +  " quantidade: "+ quantidade +  " valor: " + valor +  " codigo Produto: "+ codigoProduto + " unidades " +unidadePacote + " marca " + marca; 
	}
	

}