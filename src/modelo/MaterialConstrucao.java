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

}
