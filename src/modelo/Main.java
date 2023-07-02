package modelo;
import view.*;

public class Main {
    public static void main(String[] args) {
    	 /*ControladorTela controller = new ControladorTela();
         controller.exibir();*/
        Ferramentas ferramenta = new Ferramentas("F001", 50.0, "Marca A", "Chave de fenda", 1);
        Ferramentas ferramenta2 = new Ferramentas("F002", 50.0, "Marca B", "Chave de C", 1);
        MaterialConstrucao material = new MaterialConstrucao("M001", 100.0, "Branco", "cimento", "acetato de polivinila");
        MaterialConstrucao material2 = new MaterialConstrucao("D001", 100.0, "Branco", "Duglas", "agua");

        Filial filialA = new Filial("Filial A", "Douglas");
        Filial filialB = new Filial("Filial B", "Marco Túlio");
        filialA.adicionarFerramenta(ferramenta);
        filialA.adicionarMaterialContrucao(material);
        filialB.adicionarMaterialContrucao(material2);
        
        filialB.adicionarFerramenta(ferramenta2);

        Dados SQL = new Dados();
        
        SQL.adicionarFilial(filialA);

        SQL.adicionarFilial(filialB);

        new TelaInicial(SQL);
        
        
    }
}