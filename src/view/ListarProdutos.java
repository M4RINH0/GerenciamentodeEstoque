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
	private JButton atualizar = new JButton("Atualizar");
	private JButton editar = new JButton("Editar");
	private JButton adcFerramenta = new JButton("Adicionar Produto");
	private String nomeIndex;
	
	
	public ListarProdutos(Dados volta){
		
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
		
		modelo.addAll(volta.getGeral());
		

		
		JList<Object> produtosAdicionados = new JList<Object>();
		produtosAdicionados.setModel(modelo);
		produtosAdicionados.setFont(new Font("Arial", Font.ITALIC, 15));
		produtos.add(produtosAdicionados);
		
		
		material.setBounds(1093,130,170,60);
		ferramenta.setBounds(1093,200,170,60);
		adcFerramenta.setBounds(15,130,170,60);
		editar.setBounds(15, 200, 170, 60);
		voltar.setBounds(1093,605,170,60);
		remover.setBounds(15,605,170,60);
		atualizar.setBounds(200, 605, 170, 60);
		produtos.setBounds(190,100, 900, 500);
		filtro.setBounds(1150,10,200,200);
		
		produtosAdicionados.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {		
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try{String texto = (String) produtosAdicionados.getSelectedValue();
				int indiceInicio = texto.indexOf(":")+2;
				int indiceFim = texto.indexOf(",");
				String nome = texto.substring(indiceInicio, indiceFim);
				setNomeIndex(nome);
				}catch (Exception e2) {					
				}
			}
		});	
		
		remover.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {			  
					volta.removerFerramentas(nomeIndex);
					volta.removerMateriais(nomeIndex);
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso.");
									
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
	        	modelo.addAll(volta.getMateriaisGeral());
	          }
	        });
		
		ferramenta.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            ((DefaultListModel<Object>)(produtosAdicionados.getModel())).clear();
	    		modelo.addAll(volta.getFerramentasGeral());
	          }
	        });
		
		adcFerramenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AdcMat(volta);
				janela.dispose();
				
			}

		});
		
		atualizar.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            ((DefaultListModel<Object>)(produtosAdicionados.getModel())).clear();
	           modelo.addAll(volta.getGeral());
	          }
	        });
		
		editar.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
                    String[] selectedValue = volta.buscarProduto(nomeIndex); 
                    if(volta.ferramentaOrMatC(nomeIndex)==0) {
                    	new AdcFerramenta(volta,selectedValue[0],nomeIndex,1);
                    	janela.dispose();
                    }
                    if(volta.ferramentaOrMatC(nomeIndex)==1) {
                    	new AdcMatC(volta,selectedValue[0],nomeIndex,1);
                    	janela.dispose();
                    }   
                                    
	          }
	        });
		
		janela.add(editar);
		janela.add(adcFerramenta);
		janela.add(atualizar);
		janela.add(remover);
		janela.add(voltar);
		janela.add(material);
		janela.add(ferramenta);
		janela.add(filtro);
		janela.add(produtos);
		janela.add(label);		
		janela.setVisible(true);
	}
	
	public void setNomeIndex(String nome) {
		nomeIndex = nome;
	}
	
}

