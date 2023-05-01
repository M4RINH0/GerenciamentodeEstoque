package modelo;

public class MaterialConstrucao extends Produto {
	private String cor;

	public MaterialConstrucao(String codigoProduto, double valor, int quantidade, String cor, String nome) {
		super(codigoProduto, valor, quantidade, nome);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}


	public void imprimirDescricao() {
		System.out.println("Material de construção: " + nome + " (" + getCodigoProduto() + "), " + getQuantidade()
				+ " unidades, R$" + getValor() + " cada.");
		System.out.println("Cor: " + cor);
	}
}
