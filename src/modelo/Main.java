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

        Filial filialA = new Filial("Filial A");
        Filial filialB = new Filial("Filial B");
      //  Filial filialC = new Filial("Filial C");
        filialA.adicionarFerramenta(ferramenta);
        filialA.adicionarFerramenta(ferramenta2);
        filialA.adicionarMaterialContrucao(material);
        filialA.adicionarMaterialContrucao(material2);
        filialB.adicionarMaterialContrucao(material);
        
        //filialC.adicionarFerramenta(ferramenta2);
        filialB.adicionarMaterialContrucao(material2);
        Dados SQL = new Dados();
        
        SQL.adicionarFilial(filialA);
        //SQL.excluirFilial("Filial A");
        SQL.adicionarFilial(filialB);
        /*SQL.adicionarFilial(filialB);
         
        SQL.adicionarFilial(filialC);
        SQL.listarTudo();
        System.out.println("-------------------------------------------------------------------");        
        //SQL.buscarFilial("Filial A");
        //SQL.buscarProduto("F001");
        */
        //SQL.removerFerramenta("Chave de C","Filial A");
        //new EstoqueF(SQL,"Filial A");
        //new GerenciadorFilial(SQL);
        //SQL.removerMat("cimento", "Filial A");
        //AdcMatC tela = new AdcMatC(SQL,"Filial A","cimento",1);
        //new EstoqueF(SQL,"Filial A");
        new TelaInicial(SQL);
        
        
    }
}