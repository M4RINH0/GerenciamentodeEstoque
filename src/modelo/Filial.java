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

    public List<MaterialConstrucao> getProdutos1() {
        return estoque1;
    }
    public List<Ferramentas> getProdutos2() {
        return estoque2;
    }
    
    
    public void adicionarMaterialContrucao( MaterialConstrucao mat) {
    	estoque1.add(mat);
    }

    public void adicionarFerramenta(Ferramentas ferramenta) {
    	estoque2.add(ferramenta);
    }
    
    public void removerFerramenta(Ferramentas ferramenta) {
    	int x = ferramenta.getQuantidade();
    	ferramenta.setQuantidade(x- 1);	
    }
    public void removerMat(MaterialConstrucao mat) {
    	int x = mat.getQuantidade();
    	mat.setQuantidade(x- 1);	
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