package view;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;*/

import javax.swing.*;

public class BuscarProduto {
	private JFrame janela = new JFrame("Buscar produto por código");
	private JLabel busca = new JLabel("Digite o codigo do produto que você procura:");
	private JTextField buscaProduto = new JTextField();
	private JButton buscar = new JButton("Buscar");
	private JButton voltar = new JButton("Voltar");
	
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

	
	}
}
