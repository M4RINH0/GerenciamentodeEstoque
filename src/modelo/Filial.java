package modelo;

import java.util.ArrayList;
import java.util.List;

public class Filial {
    private String nome;
    private String gerente;
    private List<MaterialConstrucao> estoque1;
    private List<Ferramentas> estoque2;
    

    public Filial(String nome, String gerente) {
        this.nome = nome;
        this.gerente = gerente;
        this.estoque1 = new ArrayList<>();
        this.estoque2 = new ArrayList<>();     
    }
    
    public String getGerente() {
        return gerente;
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