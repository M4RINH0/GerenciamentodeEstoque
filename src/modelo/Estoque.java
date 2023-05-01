package modelo;

import java.util.*;

public class Estoque {
    private static final int MAX_FILIAIS = 2;
    private int numFiliais;
    private List<Filial> filiais;

    public Estoque(Filial... filiais) {
        this.numFiliais = 0;
        this.filiais = new ArrayList<>();
        for (Filial filial : filiais) {
            adicionarFilial(filial);
        }
    }

    public int getNumFiliais() {
        return numFiliais;
    }

    public List<Filial> getFiliais() {
        return filiais;
    }

    public void adicionarFilial(Filial filial) {
        if (numFiliais < MAX_FILIAIS) {
            filiais.add(filial);
            numFiliais++;
        } else {
            System.out.println("Não foi possível adicionar a filial " + filial.getNome() + " - limite máximo atingido.");
        }
    }

    public void mostrarProdutosFilial(Filial filial) {
        System.out.println("Produtos da filial " + filial.getNome() + ":");
        for (Produto produto : filial.getProdutos()) {
            System.out.println("Código: " + produto.getCodigoProduto() + " - Nome: " + produto.getNome() + " - Valor: " + produto.getValor() + " - Quantidade: " + produto.getQuantidade());
        }
    }
    
    //metodo de filtrar:
    
}