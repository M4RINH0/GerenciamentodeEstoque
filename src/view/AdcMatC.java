package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.MaterialConstrucao;
import modelo.Dados;

public class AdcMatC {
	private JFrame tela = new JFrame("Adicionar Matrial de Construcao");
	private JTextField nome = new JTextField();
	private JTextField codigoP = new JTextField();
	private JTextField valor = new JTextField();
	private JTextField matP = new JTextField();
	private JTextField cor = new JTextField();
	private  JLabel name = new JLabel();
	private  JLabel code = new JLabel();
	private  JLabel color = new JLabel();
	private  JLabel materiaPrima = new JLabel();
	private  JLabel price = new JLabel();
	private  JButton salvar = new JButton("Salvar");
	
	public AdcMatC(Dados banc,String filial,String nomeP,int opc) {
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nome.setBounds(490, 100, 300, 50);
		
		if(opc==1) {
			MaterialConstrucao s = banc.dadosMatC(nomeP, filial);
			nome.setText(s.getNome());
			codigoP.setText(s.getCodigoProduto());
			cor.setText(s.getCor());
			matP.setText(s.getMateriaPrima());
			valor.setText(Double.toString(s.getValor()));
		}
		codigoP.setBounds(490, 200, 300, 50);
		matP.setBounds(490, 300, 300, 50);
		cor.setBounds(490, 400, 300, 50);
		valor.setBounds(490, 500, 300, 50);
		name.setBounds(490, 50, 300, 50);
		name.setText("Nome: ");
		code.setBounds(490, 150, 300, 50);
		code.setText("Codigo do Produto: ");
		color.setBounds(490, 250, 300, 50);
		color.setText("Cor: ");
		materiaPrima.setBounds(490, 350, 300, 50);
		materiaPrima.setText("Materia Prima: ");
		price.setBounds(490, 450, 300, 50);
		price.setText("Valor: ");
		salvar.setBounds(1100, 600, 70, 50);
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeM = nome.getText();
				String codigoM = codigoP.getText();
				String matPM = matP.getText();
				String valorM = valor.getText();
				String corM = cor.getText();
				if(opc==1) {
			//		banc.removerMat(nomeP, filial);
				}
				MaterialConstrucao f = new MaterialConstrucao(codigoM,Double.parseDouble(valorM),corM,nomeM,matPM);
				banc.adcmatC(f, filial);
				
				tela.dispose();
				new TelaInicial(banc);
				
				
			}
			
		});
		
		tela.add(nome);
		tela.add(codigoP);
		tela.add(matP);
		tela.add(color);
		tela.add(valor);
		tela.add(name);
		tela.add(cor);
		tela.add(code);
		tela.add(materiaPrima);
		tela.add(price);
		tela.add(salvar);
	}

}
