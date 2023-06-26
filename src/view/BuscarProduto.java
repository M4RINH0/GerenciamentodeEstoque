 package view;
import modelo.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BuscarProduto {
	private JFrame janela = new JFrame("Buscar produto por código");
	private JLabel busca = new JLabel("Digite o nome do produto que você procura:");
	private JTextField buscaProduto = new JTextField();
	private JLabel whatF = new JLabel("Em qual filial deseja buscar o produto?");
	private JButton buscar = new JButton("Buscar");
	private JButton voltar = new JButton("Voltar");
	private JList<String> nomes;
	
	public BuscarProduto(Dados banco) {
		janela.setSize(600,200);
		janela.setLayout(null);
		busca.setBounds(15,15,280,45);
		buscaProduto.setBounds(15, 50, 540,45);
		buscar.setBounds(15, 105, 100, 40);
		voltar.setBounds(455,105,100,40);
		
		janela.add(busca);
		janela.add(buscaProduto);
		janela.add(buscar);
		janela.add(voltar);
		
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new TelaInicial(banco);
                janela.dispose();
            }
        });
		buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	janela.setSize(800,600);
            	janela.remove(buscaProduto);
            	janela.remove(buscar);
            	janela.remove(busca);
            	voltar.setBounds(550,500,100,40);
            	janela.add(voltar);
            	whatF.setBounds(200,55, 400, 50);
            	whatF.setFont(new Font("Arial", Font.BOLD, 20));
            	janela.add(whatF);
            	
            	nomes = new JList<>(banco.buscarProduto(buscaProduto.getText()));
            	ListModel<?> listModel = nomes.getModel();
            	if(listModel.getSize() == 0) {
            		new TelaInicial(banco);
            		janela.dispose();
            		JOptionPane.showMessageDialog(null, "Produto não está cadastrado em nenhuma filial.");
            	}
        		nomes.setBounds(350, 200, 100, 200);
        		janela.add(nomes);
        		nomes.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            String selectedValue = nomes.getSelectedValue(); 
                            if(banco.ferramentaOrMatC(buscaProduto.getText())==0) {
                            	new AdcFerramenta(banco,selectedValue,buscaProduto.getText(),1);
                            	janela.dispose();
                            }
                            if(banco.ferramentaOrMatC(buscaProduto.getText())==1) {
                            	new AdcMatC(banco,selectedValue,buscaProduto.getText(),1);
                            	janela.dispose();
                            }                       
                        }
                    }
                });
            	
            	
            	
            	
            }
        });

	
	}
}
