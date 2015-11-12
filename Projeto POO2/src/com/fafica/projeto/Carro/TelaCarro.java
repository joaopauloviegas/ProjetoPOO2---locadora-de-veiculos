package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCarro {

	private JFrame frame;
	private JTextField textNomeCarro;
	private JTextField textAno;
	private JTextField textPlaca;
	private JTextField textPortas;
	private JTextField textKm;
	private JTextField textCategoria;
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarro window = new TelaCarro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCarro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 735, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("salvar");
		btnNewButton.setBounds(75, 11, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.setBounds(239, 11, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("deletar");
		btnNewButton_2.setBounds(403, 11, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Procurar");
		btnNewButton_3.setBounds(567, 11, 89, 23);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 103, 735, 93);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		panel_1.add(lblNome);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(293, 11, 35, 14);
		panel_1.add(lblAno);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(452, 11, 35, 14);
		panel_1.add(lblPlaca);
		
		JLabel lblPortas = new JLabel("Portas:");
		lblPortas.setBounds(10, 36, 46, 14);
		panel_1.add(lblPortas);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setBounds(162, 36, 35, 14);
		panel_1.add(lblKm);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(275, 36, 64, 14);
		panel_1.add(lblCategoria);
		
		textNomeCarro = new JTextField();
		textNomeCarro.setBounds(66, 8, 203, 20);
		panel_1.add(textNomeCarro);
		textNomeCarro.setColumns(10);
		
		textAno = new JTextField();
		textAno.setBounds(338, 8, 86, 20);
		panel_1.add(textAno);
		textAno.setColumns(10);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(497, 8, 86, 20);
		panel_1.add(textPlaca);
		textPlaca.setColumns(10);
		
		textPortas = new JTextField();
		textPortas.setBounds(66, 33, 86, 20);
		panel_1.add(textPortas);
		textPortas.setColumns(10);
		
		textKm = new JTextField();
		textKm.setBounds(183, 33, 86, 20);
		panel_1.add(textKm);
		textKm.setColumns(10);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(338, 33, 139, 20);
		panel_1.add(textCategoria);
		textCategoria.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Placa", "Nome", "Ano", "Portas", "Km", "Categoria"
			}
		));
		table.setBounds(10, 207, 735, 203);
		frame.getContentPane().add(table);
	}
}
