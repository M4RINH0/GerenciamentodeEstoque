package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Dados;
import modelo.Ferramentas;
import modelo.Produto;

public class AdcFerramenta {
	private JFrame tela = new JFrame("Adicionar Ferramenta");
	private JTextField nome = new JTextField();
	private JTextField codigoP = new JTextField();
	private JTextField valor = new JTextField();
	private JTextField marca = new JTextField();
	private JTextField unidade = new JTextField();
	private  JLabel name = new JLabel();
	private  JLabel code = new JLabel();
	private  JLabel brand = new JLabel();
	private  JLabel unit = new JLabel();
	private  JLabel price = new JLabel();
	private  JButton salvar = new JButton("Salvar");
	private Dados banc = new Dados();
	private String filial = new String();
	
	
	
	public AdcFerramenta(Dados banc,String filial,String nomeF,int opc) {
		this.filial=filial;
		this.banc=banc;
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nome.setBounds(490, 100, 300, 50);
		codigoP.setBounds(490, 200, 300, 50);
		marca.setBounds(490, 300, 300, 50);
		unidade.setBounds(490, 400, 300, 50);
		valor.setBounds(490, 500, 300, 50);
		name.setBounds(490, 50, 300, 50);
		name.setText("Nome: ");
		code.setBounds(490, 150, 300, 50);
		code.setText("Codigo do Produto: ");
		brand.setBounds(490, 250, 300, 50);
		brand.setText("Marca: ");
		unit.setBounds(490, 350, 300, 50);
		unit.setText("Quantidade: ");
		price.setBounds(490, 450, 300, 50);
		price.setText("Valor: ");
		salvar.setBounds(1100, 600, 70, 50);
		if(opc==1) {
			Ferramentas impor = banc.dadosFerramenta(nomeF, filial);
			nome.setText(impor.getNome());
			codigoP.setText(impor.getCodigoProduto());
			marca.setText(impor.getMarca());
			unidade.setText(String.valueOf(impor.getUnidade()));
			valor.setText(Double.toString(impor.getValor()));
		}
		
		tela.add(nome);
		tela.add(codigoP);
		tela.add(marca);
		tela.add(unidade);
		tela.add(valor);
		tela.add(name);
		tela.add(brand);
		tela.add(code);
		tela.add(unit);
		tela.add(price);
		tela.add(salvar);
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeF = nome.getText();
				String codigoF = codigoP.getText();
				String marcaF = marca.getText();
				String unidadesF = unidade.getText();
				String valorF = valor.getText();
			
				
				
				if(opc==1) {
				//	banc.removerFerramenta(nomeF, filial);
					
				}
				Ferramentas f = new Ferramentas(codigoF,Double.parseDouble(valorF),marcaF,nomeF,Integer.parseInt(unidadesF));
				banc.adcFerramenta(f,filial );
				
				tela.dispose();
				//new AdcFerramenta(banc,filial);
				new TelaInicial(banc);   
				
				
				
			}
			
		});
		
	}

}
