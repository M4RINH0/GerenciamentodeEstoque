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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListarProdutos {
	private JFrame janela = new JFrame("Listagem");
	private JPanel produtos = new JPanel();
	private JLabel label = new JLabel();
	private JLabel filtro = new JLabel("Filtrar:");
	private JButton material = new JButton("Material de Construção");
	private JButton ferramenta = new JButton("Ferramentas");
	private JButton voltar = new JButton("Voltar");
	private JButton remover = new JButton("Remover");
	private int indexDoElementoSelecionado;
	
	
	public ListarProdutos(Filial banco, Dados volta){	
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
		
		filtro.setFont(new Font("Arial", Font.BOLD, 20));
		filtro.setForeground(Color.WHITE);
		
		janela.setSize(1280,720);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label.setText("Listar Produtos");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(imageIcon);	
		
		produtos.setBackground(Color.white);
		
		DefaultListModel<Object> modelo = new DefaultListModel<Object>();
		
		for(int i = 0; i < banco.getMateriais().size(); i++) {
			modelo.addElement(banco.getMateriais().get(i).toString());
		}
		for(int i = 0; i < banco.getFerramentas().size(); i++) {
			modelo.addElement(banco.getFerramentas().get(i).toString());
		}
		
		JList<Object> produtosAdicionados = new JList<Object>();
		produtosAdicionados.setModel(modelo);
		produtosAdicionados.setFont(new Font("Arial", Font.ITALIC, 15));
		produtos.add(produtosAdicionados);
		
		
		material.setBounds(1093,130,170,60);
		ferramenta.setBounds(1093,200,170,60);
		voltar.setBounds(1093,605,170,60);
		remover.setBounds(15,605,170,60);
		produtos.setBounds(190,100, 900, 500);
		filtro.setBounds(1150,10,200,200);
		
		produtosAdicionados.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int elemento = produtosAdicionados.getSelectedIndex();
				setIndexDoElementoSelecionado(elemento);
			}
		});
		
		
		remover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(indexDoElementoSelecionado);
				
				banco.getFerramentas().remove(getIndexDoElementoSelecionado());
				JOptionPane.showMessageDialog(null, "Veículo removido com sucesso.");
				//janela.dispose();
			}
		});
		
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TelaInicial(volta);
                janela.dispose();
            }
        });
		
		material.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            ((DefaultListModel<Object>)(produtosAdicionados.getModel())).clear();
	        	for(int i = 0; i < banco.getMateriais().size(); i++) {
	    			modelo.addElement(banco.getMateriais().get(i).toString());
	    		}
	          }
	        });
		
		ferramenta.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            ((DefaultListModel<Object>)(produtosAdicionados.getModel())).clear();
	    		for(int i = 0; i < banco.getFerramentas().size(); i++) {
	    			modelo.addElement(banco.getFerramentas().get(i).toString());
	    		}
	          }
	        });
		
		
		janela.add(remover);
		janela.add(voltar);
		janela.add(material);
		janela.add(ferramenta);
		janela.add(filtro);
		janela.add(produtos);
		janela.add(label);		
		janela.setVisible(true);
	}
	
	public void setIndexDoElementoSelecionado(int index) {
		indexDoElementoSelecionado = index;
	}
	public int getIndexDoElementoSelecionado() {
		return indexDoElementoSelecionado;
	}
}
