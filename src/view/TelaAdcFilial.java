package view;
import modelo.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class TelaAdcFilial {
	private  JLabel label = new JLabel();
	private  JLabel label2 = new JLabel();
	private  JLabel texto = new JLabel();
	private  JFrame adcFilial = new JFrame("Adicionar Filial");
	private  JTextField nome = new JTextField();
	private  JTextField gerente = new JTextField();
	private  JTextPane area =new JTextPane();
	private  JButton filial = new JButton("Adicionar Filial");
	private JButton voltar = new JButton("Voltar");
	
	public TelaAdcFilial(Dados banco) {
	
		//Pegar Imagem de BackGround
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("backgroundAdc.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		label2.setText("Digite o nome para a Filial:");
		label2.setFont(new Font("Arial", Font.ITALIC, 30));
		label2.setForeground(Color.WHITE);
		
		texto.setText("Digite o nome para o Gerente da Filial:");
		texto.setFont(new Font("Arial", Font.ITALIC, 30));
		texto.setForeground(Color.WHITE);
		
		area.setText("Ao criar uma nova filial ela será guardada em nosso banco de dados"
				+ " e conseguirá adicionar novos produtos na mesma!");
		area.setEditable(false);
		area.setFont(new Font("Arial", Font.ITALIC, 30));
		area.setOpaque(true);
		area.setBackground(null);
		
		label.setText("Adicionar Filial");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);

		adcFilial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adcFilial.setSize(1280,720);
		adcFilial.setLayout(null);
		
		nome.setFont(new Font("Arial", Font.PLAIN, 30));
		
		gerente.setFont(new Font("Arial", Font.PLAIN, 30));
		
		Image dimg = img.getScaledInstance(adcFilial.getWidth(),650,
				Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		filial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             Filial f = new Filial(nome.getText(), gerente.getText());
             banco.adicionarFilial(f);
             JOptionPane.showMessageDialog(null, "Filial criada com sucesso.");	
             new TelaInicial(banco);
             adcFilial.dispose();
            }
        });
		
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new GerenciadorFilial(banco);
                adcFilial.dispose();
            }
        });
		
		voltar.setBounds(1093,600,170,60);
		filial.setBounds(50,600,180,60);
		label2.setBounds(50,210,500,45);
		texto.setBounds(50,300,800,45);
		label.setBounds(0, 0, 1280, 720);
		nome.setBounds(50,250, 500,45);
		gerente.setBounds(50,350, 500,45);
		area.setBounds(50,400, 920,100);  
		
		label.setIcon(imageIcon);
		adcFilial.setVisible(true);
		
		adcFilial.add(gerente);
		adcFilial.add(voltar);
		adcFilial.add(filial);
		adcFilial.add(area);
		adcFilial.add(texto);
		adcFilial.add(label2);
		adcFilial.add(nome);
		adcFilial.add(label);
	}
}
