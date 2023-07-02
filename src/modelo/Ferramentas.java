package modelo;
/**
 * Classe com atributos de uma ferramenta
 * @author mtuli
 *
 */
public class Ferramentas extends Produto {
	private String marca;
	private int unidadePacote;
	/**
	 * construtor que recebe todos os atributos de uma ferramenta
	 * @param codigoProduto
	 * @param valor
	 * @param marca
	 * @param nome
	 * @param unidadePacote
	 */

	public Ferramentas(String codigoProduto, double valor, String marca, String nome, int unidadePacote) {
		super(codigoProduto, valor, nome);
		this.marca = marca;
		this.unidadePacote = unidadePacote;
	}
	
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setUnidadePacote(int unidadePacote) {
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