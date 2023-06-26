package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Dados;

public class GerenciadorFilial {
	
	private JFrame tela = new JFrame("Gerenciador de filial");
	private JList<String> nomes;
	private JList<String> opcs;
	private JPanel filiais = new JPanel();
	private Dados banc;
	private JTextField nomeBusca = new JTextField();
	private JButton buscar = new JButton("Buscar");
	private JButton voltar = new JButton("Voltar");
	private JLabel label = new JLabel();
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	
	String[] useropc = {"Excluir","Atualizar","Estoque","Criar"};
	String selectedValue1;
	String opcsDesejada;
	public GerenciadorFilial(Dados banc){
		
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
		
		this.banc=banc;
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label.setText("Gerenciador de Filial");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(Color.BLACK);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(imageIcon);
		
		
		
		for(int i = 0; i < banc.getFilial().size(); i++) {
			modelo.addElement(banc.getFilial().get(i).getNome());
		}
		
		nomes = new JList<String>();
		nomes.setModel(modelo);
		
		filiais.setBackground(Color.white);
		filiais.add(nomes);
		
		opcs = new JList<>(useropc);
		
		nomes.setFont(new Font("Arial", Font.BOLD, 18));
		nomes.setCellRenderer(new CenteredTextRenderer());
		
		filiais.setBounds(440, 100, 400, 400);
		opcs.setBounds(440, 510, 400, 75);
		nomeBusca.setBounds(440, 600, 290, 30);
		buscar.setBounds(740,600 , 100, 30);
		voltar.setBounds(1093,605,170,60);
		
		
		tela.add(voltar);
		tela.add(filiais);
		tela.add(opcs);
		tela.add(nomeBusca);
		tela.add(buscar);
		tela.add(label);
		
		
		nomes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedValue1 = nomes.getSelectedValue();        
                    selector(opcsDesejada,selectedValue1);                  
                }
            }
        });
		
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TelaInicial(banc);
                tela.dispose();
            }
        });
		
		opcs.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	opcsDesejada = opcs.getSelectedValue();  
            	if(opcsDesejada == "Atualizar") {
        			((DefaultListModel<String>)(nomes.getModel())).clear();
        			for(int i = 0; i < banc.getFilial().size(); i++) {
        				modelo.addElement(banc.getFilial().get(i).getNome());

        			}	
        		}
                if (!e.getValueIsAdjusting()) {
                    opcsDesejada = opcs.getSelectedValue();        
                    selector(opcsDesejada,selectedValue1);
            		
                    
                }
            }
        });
		
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tela.dispose();
				new EstoqueF(banc,nomeBusca.getText());				
			}
			
		});
		
		 
		
	}
	public void selector(String opc, String filial) {
		
		if(opc=="Excluir" && filial != null) {	
			System.out.println(filial);
			int a = banc.excluirFilial(filial);
			banc.getFilial().remove(a);
			JOptionPane.showMessageDialog(null, "Filial removida com sucesso.");					
			}
		if(opc=="Estoque" && filial != null) {
			tela.dispose();
			new EstoqueF(banc,filial);			
		}
		if(opc == "Criar") {
			tela.dispose();
			new TelaAdcFilial(banc);
		}
		
	}
}

class CenteredTextRenderer extends DefaultListCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setHorizontalAlignment(SwingConstants.CENTER); // Definindo a centralização do texto

        return label;
    }
}
