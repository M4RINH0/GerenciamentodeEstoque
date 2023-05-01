package modelo;


public class Main {
    public static void main(String[] args) {
        Ferramentas ferramenta = new Ferramentas("F001", 50.0, 5, "Marca A", "Chave de fenda");
        MaterialConstrucao material = new MaterialConstrucao("M001", 100.0, 10, "Branco", "Tinta acrilica");

        Filial filialA = new Filial("Filial A");
        filialA.adicionarProduto(ferramenta);

        Filial filialB = new Filial("Filial B");
        filialB.adicionarProduto(material);

        Estoque estoque = new Estoque(filialA, filialB);

        estoque.mostrarProdutosFilial(filialA);
        estoque.mostrarProdutosFilial(filialB);
    }
}