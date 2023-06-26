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
	
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	
	public String getCor() {
		return cor;
	}
	public String toString() {
		return "Nome: "+ nome + ", Valor: " + valor + ", Código do Produto: "+ codigoProduto +
				", Materia prima: " + materiaPrima + ", Cor: " + cor; 
	}

}
