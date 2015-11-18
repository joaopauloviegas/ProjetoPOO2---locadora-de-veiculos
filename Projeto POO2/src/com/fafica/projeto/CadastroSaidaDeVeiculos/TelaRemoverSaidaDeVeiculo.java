package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverSaidaDeVeiculo {

	private JFrame frmTelaRemoverSaida;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverSaidaDeVeiculo window = new TelaRemoverSaidaDeVeiculo();
					window.frmTelaRemoverSaida.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverSaidaDeVeiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRemoverSaida = new JFrame();
		frmTelaRemoverSaida.setTitle("Tela Remover Saida de Veiculo");
		frmTelaRemoverSaida.setBounds(100, 100, 450, 300);
		frmTelaRemoverSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaRemoverSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 414, 105);
		frmTelaRemoverSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 33, 46, 14);
		panel.add(lblNewLabel);
		
		textID = new JTextField();
		textID.setBounds(66, 30, 86, 20);
		panel.add(textID);
		textID.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(304, 71, 89, 23);
		panel.add(btnRemover);
		
		JLabel lblDigiteOId = new JLabel("Digite o ID que deseja remover:");
		lblDigiteOId.setBounds(64, 11, 245, 14);
		frmTelaRemoverSaida.getContentPane().add(lblDigiteOId);
	}

	public void remover(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
				
		String idString = textID.getText();
		int id = Integer.parseInt(idString);
		
		try{
			fachada.removerSaidaDeVeiculos(id);
		}catch(Exception e){
			
		}// fim do try/catch
	}// fim do metodo remover
}
