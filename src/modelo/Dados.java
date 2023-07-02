package modelo;

import java.util.ArrayList;
/**
 * Classe responsavel pelos CRUDs e por salvar informações
 * @author mtuli
 *
 */

public class Dados{
	public ArrayList<Filial> banco = new ArrayList<Filial>();
	public ArrayList<Filial> bancoReserva = new ArrayList<Filial>();
	public ArrayList<String> produtosGeral = new ArrayList<String>();
	public ArrayList<String> ferramentasGeral = new ArrayList<String>();
	public ArrayList<String> materiaisGeral = new ArrayList<String>();
	/**
	 * Metodo responsavel por adicionar filial ao banco de dados
	 * @param filial
	 */
	public void adicionarFilial(Filial filial) {
		
		banco.add(filial);
	}
	
	public ArrayList<String> getFerramentasGeral(){
		ferramentasGeral.clear();
		for(Filial m : banco) {
			for(Ferramentas e : m.getFerramentas()) {
				ferramentasGeral.add(e.toString());
			}	
		}		
		return ferramentasGeral;
	}
	
	public ArrayList<String> getMateriaisGeral(){
		materiaisGeral.clear();
		for(Filial m : banco) {
			for(MaterialConstrucao j : m.getMateriais()) {
				materiaisGeral.add(j.toString());
			}	
		}		
		return materiaisGeral;
	}
	
	public ArrayList<String> getGeral(){
		produtosGeral.clear();
		for(Filial m : banco) {
			for(Ferramentas e : m.getFerramentas()) {
				produtosGeral.add(e.toString() + "; " + m.getNome()+"-");
			}	
			for(MaterialConstrucao j : m.getMateriais()) {
				produtosGeral.add(j.toString()+ "; " + m.getNome() + "-");
			}
		}
		
		return produtosGeral;
	}
	/**
	 * Metodo responsavel por remover ferramenta especifica de alguma filial
	 * @param nome
	 */
	public void removerFerramentas(String nome) {
		int indice = -1;
		int excluir = 1000;
		for(Filial m : banco) {
				indice = -1;
				excluir = 1000;
				for(Ferramentas e : m.getFerramentas()) {
					indice++;
					if(e.getNome().equals(nome)) {
						excluir = indice;
					}
				}
				if(excluir == indice) {
				m.getFerramentas().remove(excluir);
				}			
		}	
	}
	/**
	 * Metodo responsavel por remover material de construcao especifico de alguma filial
	 * @param nome
	 */
	public void removerMateriais(String nome) {
		int indice = -1;
		int excluir = 1000;
		for(Filial m : banco) {
				indice = -1;
				excluir = 1000;
				for(MaterialConstrucao e : m.getMateriais()) {
					indice++;
					if(e.getNome().equals(nome)) {
						excluir = indice;
					}
				}
				if(excluir == indice) {
				m.getMateriais().remove(excluir);
				}		
		}	
	}
	/**
	 * Metodo responsavel por buscar ferramentas  em alguma filial em especifico 
	 * @param filial
	 * @return nome das ferramentas
	 */
	public ArrayList<String> buscandoFerramentas (String filial) {
		ArrayList<String> nome = new ArrayList<String>();
		for(Filial m : banco) {
			if(m.getNome().equals(filial)) {
				for(Ferramentas e : m.getFerramentas()) {
					nome.add(e.getNome());
					i++;
				}		
			}
		}
		return nome;
		
    }
	/**
	 * Metodo responsavel por buscar material de construcao  em alguma filial em especifico 
	 * @param nome da filial
	 * @return nome dos materiais de construcao
	 */
	public ArrayList<String> buscandoMatC (String filial) {
		ArrayList<String> nome = new ArrayList<String>();
		for(Filial m : banco) {
			if(m.getNome().equals(filial)) {
				for(MaterialConstrucao e : m.getMateriais()) {
					nome.add(e.getNome());
				}
				
				
			}
		}
		return nome;		
    }
	
	private int i = 0;
	String[] frontName = new String[50];
	/**
	 * Metodo responsavel por buscar o nome das filiais no banco de dados 
	 * @return nome das filiais salvas
	 */
	public String[] filaisN() {
		
		
		for(Filial m: banco) {
			frontName[i] = m.getNome();
			i++;
		}
		i=0;
		return frontName;
	}
	
	
	/**
	 * Metodo responsavel por excluir filial da classa dados
	 * @param nome da filial
	 * @return ince da filial a ser excluida no arraylist da classe daos
	 */
	public int excluirFilial(String nome) {
		   int indice = -1;
	       for (int i = 0; i < banco.size(); i++) {
	           Filial objeto = banco.get(i);
	           if (objeto.getNome().equals(nome)) {
	               indice = i;       
	           }
	       }
	       return indice;
		}
	/**
	 * Metodo reponsavel por adicionar ferramenta ao estoque de detrminada filial
	 * @param objeto ferramenta
	 * @param filial
	 */
	public void adcFerramenta(Ferramentas f, String filial) {
		
		for(Filial m : banco) {
			if(m.getNome()==filial) {
				m.adicionarFerramenta(f);
			}
		}
		
	}
	/**
	 * Metodo reponsavel por adicionar material de construcao ao estoque de detrminada filial
	 * @param nome do material
	 * @param nome da filial
	 */
	public void adcmatC(MaterialConstrucao f, String filial) {
		
		for(Filial m : banco) {
			if(m.getNome()==filial) {
				m.adicionarMaterialContrucao(f);
			}
		}
		
	}
	/**
	 * Metodo reponsavel por puxar dados de deteriminado material de construcao
	 * @param nome do material
	 * @param nome da filial
	 * @return dados do material de contrucao
	 */
	public MaterialConstrucao dadosMatC(String nome,String filial) {
		MaterialConstrucao send = null;
		
		for(Filial m : banco) {
			if(m.getNome().equals(filial)) {
				for(MaterialConstrucao t : m.getMateriais()) {
					if(t.getNome().equals(nome)) {
						send = t;
					}
				}
			}
		}
		return send;
	}
	/**
	 * Metodo reponsavel por puxar dados de deteriminada ferramenta
	 * @param nome da ferramenta
	 * @param nome da filial
	 * @return dados da ferramenta
	 */
	public Ferramentas dadosFerramenta(String nome,String filial) {
		Ferramentas send = null;
		
		for(Filial m : banco) {
			if(m.getNome().equals(filial)) {
				for(Ferramentas t : m.getFerramentas()) {
					if(t.getNome().equals(nome)) {
						send = t;
					}
				}
			}
		}
		return send;
		
	}
	/**
	 * Metodo que tem como função saber em quais filiais detriminado produto se encontra
	 * @param nome do produto
	 * @return nome das filiais em que o produto se encontra
	 */
	public ArrayList<String> buscarProduto(String nome) {
		ArrayList<String> nomeFilial = new ArrayList<>();
		for(Filial m : banco) {
			for(MaterialConstrucao t : m.getMateriais()) {
				if(t.getNome().equalsIgnoreCase(nome)) {
							nomeFilial.add(m.getNome());
				}
			}
			for(Ferramentas s : m.getFerramentas()) {
				if(s.getNome().equalsIgnoreCase(nome)) {
					nomeFilial.add(m.getNome());
				}
				}
			}
			return nomeFilial;	
	}
	/**
	 * Metodo com a unica função de diferenciar um produto entre materital de contrução ou não
	 * @param nome do produto
	 * @return 0 para ferramentas e 1 para matC
	 */
	public int ferramentaOrMatC(String nome) {	
		//0 para ferramentas e 1 para matC
		for(Filial m : banco) {		
			for(MaterialConstrucao t : m.getMateriais()) {
				if(t.getNome().equals(nome)) {
					return 1;				
				}
			}
			for(Ferramentas s : m.getFerramentas()) {
				if(s.getNome().equals(nome)) {
					return 0;
				}
			}
			
		}
		return 1000;
	}
	
	public ArrayList<Filial> getFilial() {
		return banco;
	}

}
