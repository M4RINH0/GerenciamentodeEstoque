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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import modelo.Dados;

public class EstoqueF {
	private JFrame tela = new JFrame("Estoque da Filial");
	private JList<String> nomes;
	private JList<String> nomes2;
	private JButton voltar = new JButton("Voltar");
	private  JLabel matC = new JLabel();
	private  JLabel ferramenta = new JLabel();
	private JLabel label = new JLabel();
	
	
	public EstoqueF(Dados banc,String filial){
		
		//Pegar Imagem de BackGround
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("backgroundAdc.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(1280,650,
				Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);

		
		
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		matC.setText("Materiais de construção:");
		matC.setForeground(Color.WHITE);
		matC.setFont(new Font("Arial", Font.BOLD, 30));
		
		ferramenta.setFont(new Font("Arial", Font.BOLD, 30));	
		ferramenta.setText("Ferramentas:");		
		ferramenta.setForeground(Color.WHITE);
		
		DefaultListModel<String> modelo1 = new DefaultListModel<String>();
		DefaultListModel<String> modelo2 = new DefaultListModel<String>();
		
		modelo1.addAll(banc.buscandoFerramentas(filial));
		modelo2.addAll(banc.buscandoMatC(filial));
		
		nomes = new JList<>();
		nomes.setModel(modelo1);
		nomes2 = new JList<>();
		nomes2.setModel(modelo2);
		
		if(modelo1.isEmpty() && modelo2.isEmpty()) {
			tela.dispose();
			new GerenciadorFilial(banc);
			JOptionPane.showMessageDialog(null, "Filial não encontrada no sistema.");
		}
		
		label.setText(filial + " :");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(imageIcon);
		
		
		nomes.setBounds(150, 160, 400, 400);
		nomes2.setBounds(730, 160, 400, 400);
		voltar.setBounds(1093,605,170,60);
		ferramenta.setBounds(150, 100, 400, 50);
		matC.setBounds(730, 100, 400, 50);
		
		
		tela.add(voltar);
		tela.add(nomes);
		tela.add(nomes2);
		tela.add(matC);
		tela.add(ferramenta);
		tela.add(label);
			
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new GerenciadorFilial(banc);
                tela.dispose();
            }
        });
		
	}

}
