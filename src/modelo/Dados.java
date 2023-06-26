package modelo;

import java.util.ArrayList;

public class Dados{
	public ArrayList<Filial> banco = new ArrayList<Filial>();
	public ArrayList<Filial> bancoReserva = new ArrayList<Filial>();
	public ArrayList<String> produtosGeral = new ArrayList<String>();
	public ArrayList<String> ferramentasGeral = new ArrayList<String>();
	public ArrayList<String> materiaisGeral = new ArrayList<String>();
	
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
	 
	public String[] filaisN() {
		
		
		for(Filial m: banco) {
			frontName[i] = m.getNome();
			i++;
		}
		i=0;
		return frontName;
	}
	
	

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
	
	public void adcFerramenta(Ferramentas f, String filial) {
		
		for(Filial m : banco) {
			if(m.getNome()==filial) {
				m.adicionarFerramenta(f);
			}
		}
		
	}
	public void adcmatC(MaterialConstrucao f, String filial) {
		
		for(Filial m : banco) {
			if(m.getNome()==filial) {
				m.adicionarMaterialContrucao(f);
			}
		}
		
	}
	
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
