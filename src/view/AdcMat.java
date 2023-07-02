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
/**
 * Classe em que representa a tela em que o o usuario define a filial e o tipo de produto se deseja incluir no estoque
 * @author mtuli
 *
 */
public class AdcMat  {
	private JFrame tela = new JFrame("Adicionar produto");
	private JButton matC = new JButton("Material de contrução");
	private JButton ferramenta = new JButton("Ferramenta");
	private JList<String> nomes;
	private int opc = 9;
	private String selectedValue;
	private JButton voltar = new JButton("Voltar");
	private Dados banc = new Dados();
	private JLabel label = new JLabel();
	
	/**
	 * Construtor da classe em que necessita de apenas as informações do banco de dados para
	 * poder funcionar 
	 * @param banc
	 */
	public AdcMat(Dados banc) {
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
		
		label.setText("Adicionar Produto");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);	
		label.setIcon(imageIcon);		
				
		this.banc= banc;
		
		
		matC.setBounds(540, 599, 200, 50);
		ferramenta.setBounds(540, 530, 200, 50);
		voltar.setBounds(1093,605,170,60);
		label.setBounds(0, 0, 1280, 720);
		
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		nomes = new JList<>(banc.filaisN());
		nomes.setBounds(440, 0160, 400, 400);
		
		tela.add(voltar);
		tela.add(nomes);
		tela.add(matC);
		tela.add(ferramenta);
		tela.add(label);
		
		
		nomes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedValue = nomes.getSelectedValue();        
                    selector(opc,selectedValue);
            		
                    
                }
            }
        });
		
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TelaInicial(banc);
                tela.dispose();
            }
        });
		
		matC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opc = 2;
				selector(opc,selectedValue);
				
			}
			
		});
		
		ferramenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				opc = 1;
				selector(opc,selectedValue);
			}
			
		});
		
		
		}
	/**
	 * A função selector funciona de maneira em que ela só permite abrir a proxima tela  
	 * se as duas opções(filial e tipo do produto) estiverem sido escolhidas 
	 * @param opção
	 * @param filial selecionada
	 */
	public void selector(int op, String p) {
		if(op==1 && p!=null) {
			new AdcFerramenta(banc,p,"",2);
			tela.dispose();
			
		}
		if(op==2 &&p!=null) {
			new AdcMatC(banc,p,"",2);
			tela.dispose();
			
		}
		
	}
	
}