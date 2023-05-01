package modelo;

import java.util.*;

public class Filial {
    private String nome;
    private List<Produto> produtos;

    public Filial(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
}