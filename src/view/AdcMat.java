package view;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdcMat  {
	private JFrame tela = new JFrame("Adicionar produto");
	private JButton matC = new JButton("Material de contrução");
	private JButton ferramenta = new JButton("ferramenta");
	private JList<String> nomes;
	private int opc = 9;
	private String selectedValue;
	private Dados banc = new Dados();
	
	
	public AdcMat(Dados banc) {
		this.banc= banc;
		matC.setBounds(540, 599, 200, 50);
		ferramenta.setBounds(540, 530, 200, 50);
		tela.setVisible(true);
		tela.setSize(1280,720);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nomes = new JList<>(banc.filaisN());
		nomes.setBounds(440, 0160, 400, 400);
		tela.add(nomes);
		tela.add(matC);
		tela.add(ferramenta);
		nomes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedValue = nomes.getSelectedValue();        
                    selector(opc,selectedValue);
            		
                    
                }
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