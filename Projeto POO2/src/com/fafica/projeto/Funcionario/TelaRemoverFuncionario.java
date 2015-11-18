package com.fafica.projeto.Funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

public class TelaRemoverFuncionario {

	private JFrame frmRemoverFuncionario;
	private JTextField textCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverFuncionario window = new TelaRemoverFuncionario();
					window.frmRemoverFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemoverFuncionario = new JFrame();
		frmRemoverFuncionario.setTitle("Remover Funcionario");
		frmRemoverFuncionario.setBounds(100, 100, 433, 199);
		frmRemoverFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRemoverFuncionario.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 86, 56, 16);
		frmRemoverFuncionario.getContentPane().add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(46, 83, 148, 22);
		frmRemoverFuncionario.getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(206, 82, 97, 25);
		frmRemoverFuncionario.getContentPane().add(btnRemover);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(167, 13, 6, 22);
		frmRemoverFuncionario.getContentPane().add(textPane);
		
		JTextPane txtpnDigiteOCpf = new JTextPane();
		txtpnDigiteOCpf.setText("Digite o CPF do funcionario que deseja excluir");
		txtpnDigiteOCpf.setForeground(Color.GRAY);
		txtpnDigiteOCpf.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnDigiteOCpf.setBounds(63, 24, 335, 30);
		frmRemoverFuncionario.getContentPane().add(txtpnDigiteOCpf);
	}
}
