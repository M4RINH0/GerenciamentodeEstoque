package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {

	private JLabel label = new JLabel("Gerenciador de Estoque");
	private JFrame inicio = new JFrame("Inicio");
	private JButton filial = new JButton("Adicionar Filial");
	private JButton produto = new JButton("Adicionar Produto");
	private JButton listarProdutos = new JButton("Listar Produtos");
	private JButton buscarProdutos = new JButton("Buscar Produtos");
	
	public TelaInicial(){

		
		//Pegar Imagem de BackGround
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("estoque.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Texto de Titulo
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		
		//Frame da Tela	
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.setSize(1280,720);
		inicio.setLayout(null);
		Image dimg = img.getScaledInstance(inicio.getWidth(),620,
				Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(imageIcon);
		inicio.setVisible(true);
		
		//Funções botões
		filial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaAdcFilial();
                inicio.dispose();
            }
        });
		
		//Botões Tela
		filial.setBounds(540,200,180,60);
		produto.setBounds(540,300,180,60);
		listarProdutos.setBounds(540,400,180,60);
		buscarProdutos.setBounds(540,500,180,60);
		
		
		//adds
		inicio.add(filial);
		inicio.add(produto);
		inicio.add(listarProdutos);
		inicio.add(buscarProdutos);
		inicio.add(label);
	}
	
	

}