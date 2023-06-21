package modelo;

import java.util.ArrayList;
import java.util.List;

public class Filial {
    private String nome;
    private List<MaterialConstrucao> estoque1;
    private List<Ferramentas> estoque2;
    

    public Filial(String nome) {
        this.nome = nome;    
        this.estoque1 = new ArrayList<>();
        this.estoque2 = new ArrayList<>();     
    }

    public String getNome() {
        return nome;
    }

    public List<MaterialConstrucao> getMateriais() {
        return estoque1;
    }
    public List<Ferramentas> getFerramentas() {
        return estoque2;
    }
    
    
    public void adicionarMaterialContrucao( MaterialConstrucao mat) {
    	estoque1.add(mat);
    }

    public void adicionarFerramenta(Ferramentas ferramenta) {
    	estoque2.add(ferramenta);
    }
    
   public int removerFerramenta(String nome) {
	   int indice = -1;
       for (int i = 0; i < estoque2.size(); i++) {
           Ferramentas objeto = estoque2.get(i);
           if (objeto.getNome().equals(nome)) {
               indice = i;       
           }
       }
       return indice;
    }
   
   public int removerMaterial(String nome) {
	   int indice = -1;
       for (int i = 0; i < estoque1.size(); i++) {
           MaterialConstrucao objeto = estoque1.get(i);
           if (objeto.getNome().equals(nome)) {
               indice = i;       
           }
       }
       return indice;
    }
    
    public void listarProdutos() {
    	System.out.println("Materiai de contrucao:");
		for(MaterialConstrucao m : estoque1) {
			System.out.println(m.toString());
		}
		System.out.println("Ferramentas: ");
		for(Ferramentas t : estoque2) {
			System.out.println(t.toString());
		}
    }
    
    
    public void buscarProduto(String cp) {
    	for(MaterialConstrucao m : estoque1) {
    		if(m.getCodigoProduto()== cp) {
    			System.out.println(m.toString());
    			
    		}
    	}
    	for(Ferramentas m : estoque2) {
    		if(m.getCodigoProduto()== cp) {
    			System.out.println(m.toString());
    		}
    	}
    	
    	
    }
}