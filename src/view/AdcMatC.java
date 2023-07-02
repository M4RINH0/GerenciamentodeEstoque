package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.MaterialConstrucao;
import modelo.Dados;
/**
 * Classe que contem a tela de adicionar material de construcao 
 * @author mtuli
 *
 */
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
	private JLabel label = new JLabel();
	
	/**
	 * Construtor que recebe os dados, uma string com o nome da filial em que o produto sera 
	 * adicionado ou editado, em casos de edicao de produtos o construtor também recebe o nome do produto
	 * e um int = 1.
	 * @param banc
	 * @param filial
	 * @param nomeP
	 * @param opc
	 */
	public AdcMatC(Dados banc,String filial,String nomeP,int opc) {
		//Pegar Imagem de BackGround
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("backgroundAdc.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(1280,650,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
				
		label.setText("Adicionar Material de Construção");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(imageIcon);		
			
		
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		if(opc==1) {
			MaterialConstrucao s = banc.dadosMatC(nomeP, filial);
			nome.setText(s.getNome());
			codigoP.setText(s.getCodigoProduto());
			cor.setText(s.getCor());
			matP.setText(s.getMateriaPrima());
			valor.setText(Double.toString(s.getValor()));
		}
	
		
		nome.setBounds(490, 100, 300, 50);
		codigoP.setBounds(490, 200, 300, 50);
		matP.setBounds(490, 300, 300, 50);
		cor.setBounds(490, 400, 300, 50);
		valor.setBounds(490, 500, 300, 50);
		name.setBounds(490, 50, 300, 50);
		code.setBounds(490, 150, 300, 50);
		color.setBounds(490, 250, 300, 50);
		materiaPrima.setBounds(490, 350, 300, 50);
		price.setBounds(490, 450, 300, 50);
		salvar.setBounds(1100, 600, 70, 50);
		
		name.setText("Nome: ");	
		name.setForeground(Color.WHITE);
		code.setText("Codigo do Produto: ");		
		code.setForeground(Color.WHITE);
		color.setText("Cor: ");	
		color.setForeground(Color.WHITE);
		materiaPrima.setText("Materia Prima: ");
		materiaPrima.setForeground(Color.WHITE);
		price.setText("Valor: ");
		price.setForeground(Color.WHITE);
		
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeM = nome.getText();
				String codigoM = codigoP.getText();
				String matPM = matP.getText();
				String valorM = valor.getText();
				String corM = cor.getText();
				if(opc!=1) {
					MaterialConstrucao f = new MaterialConstrucao(codigoM,Double.parseDouble(valorM),
							corM,nomeM,matPM);
					banc.adcmatC(f, filial);
					JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.");
				}
				if(opc==1) {
					MaterialConstrucao s = banc.dadosMatC(nomeP, filial);
					s.setNome(nome.getText());
					s.setCodigoProduto(codigoP.getText());
					s.setCor(cor.getText());;
					s.setMateriaPrima(matP.getText());
					s.setValor(Double.parseDouble(valor.getText()));
					JOptionPane.showMessageDialog(null, "Produto editado com sucesso.");
				}
												
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
		tela.add(label);
	}

}
