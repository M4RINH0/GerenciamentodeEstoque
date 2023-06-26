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

import modelo.Dados;
import modelo.Ferramentas;

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
	private JLabel label = new JLabel();

	
	
	
	public AdcFerramenta(Dados banc,String filial,String nomeF,int opc) {		
		//Pegar Imagem de BackGround
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("backgroundAdc.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(1280,650,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
				
		label.setText("Adicionar Ferramenta");
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
		
		
		nome.setBounds(490, 100, 300, 50);
		codigoP.setBounds(490, 200, 300, 50);
		marca.setBounds(490, 300, 300, 50);
		unidade.setBounds(490, 400, 300, 50);
		valor.setBounds(490, 500, 300, 50);
		name.setBounds(490, 50, 300, 50);
		code.setBounds(490, 150, 300, 50);
		brand.setBounds(490, 250, 300, 50);
		unit.setBounds(490, 350, 300, 50);
		price.setBounds(490, 450, 300, 50);
		salvar.setBounds(1100, 600, 70, 50);
		
		
		name.setText("Nome: ");	
		name.setForeground(Color.WHITE);
		code.setText("Codigo do Produto: ");
		code.setForeground(Color.WHITE);
		brand.setText("Marca: ");
		brand.setForeground(Color.WHITE);
		unit.setText("Unidades por Pacote: ");
		unit.setForeground(Color.WHITE);
		price.setText("Valor: ");
		price.setForeground(Color.WHITE);
		
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
		tela.add(label);
		
		
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeF = nome.getText();
				String codigoF = codigoP.getText();
				String marcaF = marca.getText();
				String unidadesF = unidade.getText();
				String valorF = valor.getText();
	
				if(opc!=1) {
					Ferramentas f = new Ferramentas(codigoF,Double.parseDouble(valorF),marcaF,nomeF,
							Integer.parseInt(unidadesF));
					banc.adcFerramenta(f,filial );
					JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.");
				}
				if(opc==1) {
					Ferramentas impor = banc.dadosFerramenta(nomeF, filial);
					impor.setNome(nome.getText());
					impor.setCodigoProduto(codigoP.getText());
					impor.setMarca(marca.getText());;
					impor.setUnidadePacote(Integer.parseInt(unidade.getText()));
					impor.setValor(Double.parseDouble(valor.getText()));
					JOptionPane.showMessageDialog(null, "Produto editado com sucesso.");
				}
				
				
				tela.dispose();
				new TelaInicial(banc);   			
			}
			
		});
		
	}

}
