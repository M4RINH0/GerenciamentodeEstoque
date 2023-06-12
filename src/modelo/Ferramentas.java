package modelo;

public class Ferramentas extends Produto {
	private String marca;
	private int unidadePacote;

	public Ferramentas(String codigoProduto, double valor, String marca, String nome, int unidadePacote) {
		super(codigoProduto, valor, nome);
		this.marca = marca;
		this.unidadePacote = unidadePacote;
	}
	
	public int getUnidade() {
		return unidadePacote;
	}
	
	public String getMarca() {
		return marca;
	}
	
	
	public String toString() {
		return "Nome: "+ nome + ", Valor: " + valor + ", Codigo do Produto: "+ codigoProduto + 
				", Unidades: " +unidadePacote + ", Marca: " + marca; 
	}
	

}