package modelo;

public abstract class Produto {
	protected String codigoProduto;
	protected double valor;
	protected String nome;

	public Produto(String codigoProduto, double valor, String nome) {
		this.codigoProduto = codigoProduto;
		this.valor = valor;
		this.nome = nome;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public double getValor() {
		return valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}