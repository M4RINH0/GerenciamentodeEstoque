package modelo;

public class MaterialConstrucao extends Produto {
	private String cor;
	private String materiaPrima;

	public MaterialConstrucao(String codigoProduto, double valor, int quantidade, String cor, String nome, String materiaPrima) {
		super(codigoProduto, valor, quantidade, nome);
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
		return "Nome: "+ nome +  " quantidade: "+ quantidade +  " valor: " + valor +  " codigo Produto: "+ codigoProduto +
				" Materia prima: " + materiaPrima + " cor: " + cor; 
	}

}
