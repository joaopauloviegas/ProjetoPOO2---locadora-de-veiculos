package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverCarro {

	public JFrame frmTelaRemoverCarro;
	private JTextField textPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverCarro window = new TelaRemoverCarro();
					window.frmTelaRemoverCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverCarro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRemoverCarro = new JFrame();
		frmTelaRemoverCarro.setTitle("Tela Remover Carro");
		frmTelaRemoverCarro.setBounds(100, 100, 436, 274);
		frmTelaRemoverCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaRemoverCarro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 57, 406, 167);
		frmTelaRemoverCarro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setBounds(10, 46, 46, 14);
		panel.add(lblNewLabel);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 43, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(293, 133, 89, 23);
		panel.add(btnRemover);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(179, 133, 89, 23);
		panel.add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 406, 35);
		frmTelaRemoverCarro.getContentPane().add(panel_1);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a placa do carro que deseja remover");
		lblDigiteAPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblDigiteAPlaca);
	}// fim do main
	
	
	public void limparCampos(){
		textPlaca.setText("");
	}
	
	public void remover(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		try{
			fachada.removerCarro(textPlaca.getText());
			JOptionPane.showMessageDialog(null, "Carro removido com sucesso");
			limparCampos();
		}catch(Exception e){
			
		}
		
		
	}// fim do metodo remover

}// fim da classe 
