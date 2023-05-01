package modelo;

public abstract class Produto {
	protected String codigoProduto;
	protected double valor;
	protected int quantidade;
	protected String nome;

	public Produto(String codigoProduto, double valor, int quantidade, String nome) {
		this.codigoProduto = codigoProduto;
		this.valor = valor;
		this.quantidade = quantidade;
		this.nome = nome;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}