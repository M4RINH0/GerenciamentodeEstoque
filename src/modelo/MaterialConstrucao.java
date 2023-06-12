package modelo;

public class MaterialConstrucao extends Produto {
	private String cor;
	private String materiaPrima;

	public MaterialConstrucao(String codigoProduto, double valor, String cor, String nome, String materiaPrima) {
		super(codigoProduto, valor, nome);
		this.cor = cor;
		this.materiaPrima = materiaPrima;
	}
	
	public String getMateriaPrima() {
		return materiaPrima;
	}

	public String getCor() {
		return cor;
	}
	public String toString() {
		return "Nome: "+ nome + ", Valor: " + valor + ", Código do Produto: "+ codigoProduto +
				", Materia prima: " + materiaPrima + ", Cor: " + cor; 
	}

}
