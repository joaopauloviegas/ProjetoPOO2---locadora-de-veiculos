package com.fafica.projeto.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverCliente {

	public JFrame frmTelaRemoverCliente;
	private JTextField textCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverCliente window = new TelaRemoverCliente();
					window.frmTelaRemoverCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRemoverCliente = new JFrame();
		frmTelaRemoverCliente.setTitle("Tela Remover Cliente");
		frmTelaRemoverCliente.setBounds(100, 100, 442, 203);
		frmTelaRemoverCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaRemoverCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 406, 113);
		frmTelaRemoverCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite CPF ou ID do cliente que deseja remover");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(46, 11, 312, 14);
		panel.add(lblNewLabel);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					remover();
				} catch (ClienteNaoEncontradoException e) {
					
					e.printStackTrace();
				} catch (EnderecoNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemover.setBounds(304, 57, 89, 23);
		panel.add(btnRemover);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 64, 46, 14);
		panel.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(46, 58, 132, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
	}
	
	public void remover() throws ClienteNaoEncontradoException, EnderecoNaoEncontradoException{
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{
			String cpf = textCPF.getText();
			fachada.removerCliente(cpf);
			fachada.removerEndereco(cpf);
			//JOptionPane.showMessageDialog(null,"cliente removido com sucesso");
			
		}catch( CPFInvalidoException e){
			
		}
		
				
			
    }// fim do metodo remover 
}
