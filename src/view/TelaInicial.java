package view;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TelaInicial {
	private static JLabel label = new JLabel("Gerenciador de Estoque");
	private static JFrame inicio = new JFrame("Inicio");
	private static JButton filial = new JButton("Adicionar Filial");
	private static JButton produto = new JButton("Adicionar Produto");
	private static JButton listarProdutos = new JButton("Listar Produtos");
	private static JButton buscarProdutos = new JButton("Buscar Produtos");
	
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