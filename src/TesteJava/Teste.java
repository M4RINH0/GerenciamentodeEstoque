package TesteJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import modelo.Filial;
import modelo.MaterialConstrucao;
import modelo.Dados;
import modelo.Ferramentas;
/**
 * Classe com a função de realização dos testes
 * @author mtuli
 *
 */

public class Teste {
	Dados bancoT = new Dados();
	/**
	 * Verifica se o metodo está retornando o index corretamente
	 */
	@Test
	public void testDeletarfilial() {
		Filial t1 = new Filial("t1","t11");
		Filial t2 = new Filial("t2","t22");
		Filial t3 = new Filial("t3","t33");
		bancoT.adicionarFilial(t1);
		bancoT.adicionarFilial(t2);
		bancoT.adicionarFilial(t3);
		assertEquals(1,bancoT.excluirFilial("t2")) ;
		
		
		
	}
	/**
	 * Verica se o metodo está retornando o o objeto pedido
	 */
	@Test
	public void testeDadoFerramenta() {
		Filial t1 = new Filial("t1","t11");
		Ferramentas ferramenta = new Ferramentas("F001", 50.0, "Marca A", "Chave de fenda", 1);
		Ferramentas ferramenta2 = new Ferramentas("F002", 50.0, "Marca B", "Chave de C", 1);
		t1.adicionarFerramenta(ferramenta);
		t1.adicionarFerramenta(ferramenta2);
		bancoT.adicionarFilial(t1);
		assertEquals(ferramenta,bancoT.dadosFerramenta("Chave de fenda","t1"));
	
	}
	/**
	 * Verica se o metodo está retornando o o objeto pedido
	 */
	@Test
	public void testeDadomatC() {
		Filial t1 = new Filial("t1","t11");
		MaterialConstrucao material = new MaterialConstrucao("M001", 100.0, "Branco", "cimento", "acetato de polivinila");
        MaterialConstrucao material2 = new MaterialConstrucao("D001", 100.0, "Branco", "Duglas", "agua");
        t1.adicionarMaterialContrucao(material);
        t1.adicionarMaterialContrucao(material2);
		bancoT.adicionarFilial(t1);
		assertEquals(material,bancoT.dadosMatC("cimento", "t1"));
	
	}

}
