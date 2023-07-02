package modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe com atributos e metodos de uma filial
 * @author mtuli
 *
 */
public class Filial {
    private String nome;
    private String gerente;
    private List<MaterialConstrucao> estoque1;
    private List<Ferramentas> estoque2;
    
    /**
     * construtor que recebe os atributos de uma filial
     * @param nome
     * @param gerente
     */
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
    
   /**
    * Metodo que adiciona material de contrucao ao estoque da filial 
    * @param mat
    */
    public void adicionarMaterialContrucao( MaterialConstrucao mat) {
    	estoque1.add(mat);
    }
    /**
     * Metodo que adiciona ferramenta ao estoque da filial 
     * @param ferramenta
     */
    public void adicionarFerramenta(Ferramentas ferramenta) {
    	estoque2.add(ferramenta);
    }
    
   
    
    
    
}