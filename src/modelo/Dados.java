package modelo;

import java.util.ArrayList;

public class Dados{
	public ArrayList<Filial> banco = new ArrayList<Filial>();
	public ArrayList<Filial> bancoReserva = new ArrayList<Filial>();
	
	public void adicionarFilial(Filial filial) {
		
		banco.add(filial);
	}
	
	public String[] buscandoFerramentas (String filial) {
		String[] nome = new String[50];
		int i = 0;
		for(Filial m : banco) {
			if(m.getNome()==filial) {
				for(Ferramentas e : m.getFerramentas()) {
					nome[i]=e.getNome();
					i++;
				}
				
				
			}
		}
		return nome;
		
    }
	
	public String[] buscandoMatC (String filial) {
		String[] nome = new String[50];
		int i = 0;
		for(Filial m : banco) {
			if(m.getNome()==filial) {
				for(MaterialConstrucao e : m.getMateriais()) {
					nome[i]=e.getNome();
					i++;
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
	
	

	public void excluirFilial(String nome) {
		System.out.println(banco.toString());
		for(Filial m : banco) {			
			if(m.getNome()!= nome) {
				bancoReserva.add(m);
				
			}
		}
	
		banco = bancoReserva;
		bancoReserva.clear();
		System.out.println(banco.toString());
		
		filaisN();
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
	
	public String[] buscarProduto(String nome) {
		int i = 0;
		String[] nomeFilial = new String[50];
		for(Filial m : banco) {
			
			
			for(MaterialConstrucao t : m.getMateriais()) {
				if(t.getNome().equals(nome)) {
					nomeFilial[i]=m.getNome();
				
				}
			}
			for(Ferramentas s : m.getFerramentas()) {
				if(s.getNome().equals(nome)) {
					nomeFilial[i]=m.getNome();
				}
			}
			i++;
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
