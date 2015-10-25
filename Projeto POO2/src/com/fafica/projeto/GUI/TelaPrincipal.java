package com.fafica.projeto.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Locadora de Veiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarCliente = new JButton("Cliente");
		btnCadastrarCliente.setBounds(96, 54, 146, 23);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnNewButton = new JButton("Funcionario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(96, 88, 146, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCarro = new JButton("Carro");
		btnCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarro.setBounds(96, 122, 146, 23);
		contentPane.add(btnCarro);
		
		JButton btnSaidaDeVeiculo = new JButton("Saida de veiculo");
		btnSaidaDeVeiculo.setBounds(96, 156, 146, 23);
		contentPane.add(btnSaidaDeVeiculo);
		
		JButton btnReservarCarro = new JButton("Reservar Carro");
		btnReservarCarro.setBounds(96, 193, 146, 23);
		contentPane.add(btnReservarCarro);
	}
}
