package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fafica.projeto.Carro.Carro;

import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;

public class TelaCadastroSaidaVeiculo {

	private JFrame frmTelaCadastroSaida;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroSaidaVeiculo window = new TelaCadastroSaidaVeiculo();
					window.frmTelaCadastroSaida.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroSaidaVeiculo() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastroSaida = new JFrame();
		frmTelaCadastroSaida.setTitle("Tela Cadastro Saida de Veiculo");
		frmTelaCadastroSaida.setBounds(100, 100, 738, 432);
		frmTelaCadastroSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastroSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 702, 203);
		frmTelaCadastroSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(20, 11, 46, 14);
		panel.add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(76, 8, 377, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblVeiculo = new JLabel("Veiculo:");
		lblVeiculo.setBounds(20, 36, 46, 14);
		panel.add(lblVeiculo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 33, 377, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(30, 61, 36, 14);
		panel.add(lblPlaca);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 58, 107, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTanqueCombustivel = new JLabel("Tanque Combustivel:");
		lblTanqueCombustivel.setBounds(204, 61, 112, 14);
		panel.add(lblTanqueCombustivel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(315, 58, 138, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblValorDiaria = new JLabel("Valor diaria:");
		lblValorDiaria.setBounds(10, 89, 67, 14);
		panel.add(lblValorDiaria);
		
		textField_4 = new JTextField();
		textField_4.setBounds(76, 86, 97, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPevis = new JLabel("Pevis\u00E3o Devolu\u00E7\u00E3o:");
		lblPevis.setBounds(209, 89, 107, 14);
		panel.add(lblPevis);
		
		textField_5 = new JTextField();
		textField_5.setBounds(315, 86, 138, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
	}
}
