package view;
import modelo.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {

	private JLabel label = new JLabel("Gerenciador de Estoque");
	private JFrame janela = new JFrame("Inicio");
	private JButton gerenciaF = new JButton("Gerenciar Filiais");
	private JButton listarProdutos = new JButton("Gerenciar Produtos");
	private JButton buscarProdutos = new JButton("Buscar Produtos");
	
	public TelaInicial(Dados banco){

		
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
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(1280,720);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		Image dimg = img.getScaledInstance(janela.getWidth(),620,
				Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(imageIcon);
		janela.setVisible(true);
		
		//Funções botões
		buscarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BuscarProduto(banco);
                janela.dispose();
            }
        });
		gerenciaF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GerenciadorFilial(banco);
                janela.dispose();
            }
        });
		
		listarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListarProdutos(banco.getFilial().get(0), banco);
                janela.dispose();
            }
        });
		
		
		//Botões Tela
		gerenciaF.setBounds(540,300,180,60);
		listarProdutos.setBounds(540,400,180,60);
		buscarProdutos.setBounds(540,500,180,60);
		
		
		//adds
		janela.add(gerenciaF);
		janela.add(listarProdutos);
		janela.add(buscarProdutos);
		janela.add(label);
	}
	
	

}