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
	private static JLabel label = new JLabel();
	private static JLabel label2 = new JLabel();
	private static JFrame adcFilial = new JFrame("Adicionar Filial");
	private static JTextField nome = new JTextField();
	private static JTextPane area =new JTextPane();
	private static JButton filial = new JButton("Adicionar Filial");
	
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
		
		Image dimg = img.getScaledInstance(adcFilial.getWidth(),650,
				Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		filial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TelaInicial(banco);
                adcFilial.dispose();
            }
        });
		
		filial.setBounds(50,500,180,60);
		label2.setBounds(50,210,500,45);
		label.setBounds(0, 0, 1280, 720);
		nome.setBounds(50,250, 500,45);
		area.setBounds(50,300, 920,100);  
		
		label.setIcon(imageIcon);
		adcFilial.setVisible(true);
		
		adcFilial.add(filial);
		adcFilial.add(area);
		adcFilial.add(label2);
		adcFilial.add(nome);
		adcFilial.add(label);
	}
}
