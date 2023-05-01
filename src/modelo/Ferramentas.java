package modelo;

public class Ferramentas extends Produto {
	private String marca;

	public Ferramentas(String codigoProduto, double valor, int quantidade, String marca, String nome) {
		super(codigoProduto, valor, quantidade, nome);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}


	public void imprimirDescricao() {
		System.out.println("Ferramenta: " + nome + " (" + getCodigoProduto() + "), " + getQuantidade() + " unidades, R$"
				+ getValor() + " cada.");
		System.out.println("Marca: " + marca);
	}
}