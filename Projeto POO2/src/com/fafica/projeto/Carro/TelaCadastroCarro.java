package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class TelaCadastroCarro {

	public JFrame frmTelaCadastroCarro;
	private JTextField textNome;
	private JTextField textPlaca;
	private JTextField textAno;
	private JTextField textPortas;
	private JTextField textKm;
	private JTextField textCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCarro window = new TelaCadastroCarro();
					window.frmTelaCadastroCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCarro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastroCarro = new JFrame();
		frmTelaCadastroCarro.setTitle("Tela Cadastro Carro");
		frmTelaCadastroCarro.setBounds(100, 100, 516, 314);
		frmTelaCadastroCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastroCarro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 480, 253);
		frmTelaCadastroCarro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 31, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(10, 106, 46, 14);
		panel.add(lblAno);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlaca.setBounds(10, 56, 46, 14);
		panel.add(lblPlaca);
		
		JLabel lblPortas = new JLabel("Portas:");
		lblPortas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPortas.setBounds(10, 81, 46, 14);
		panel.add(lblPortas);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKm.setBounds(10, 131, 46, 14);
		panel.add(lblKm);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategoria.setBounds(10, 156, 67, 14);
		panel.add(lblCategoria);
		
		textNome = new JTextField();
		textNome.setBounds(87, 28, 383, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(87, 53, 103, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		textAno = new JTextField();
		textAno.setBounds(87, 103, 124, 20);
		panel.add(textAno);
		textAno.setColumns(10);
		
		textPortas = new JTextField();
		textPortas.setBounds(87, 78, 46, 20);
		panel.add(textPortas);
		textPortas.setColumns(10);
		
		textKm = new JTextField();
		textKm.setBounds(87, 128, 124, 20);
		panel.add(textKm);
		textKm.setColumns(10);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(87, 153, 281, 20);
		panel.add(textCategoria);
		textCategoria.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnCadastrar.setBounds(367, 219, 103, 23);
		panel.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(268, 219, 89, 23);
		panel.add(btnLimpar);
	}// fim do main
	
	public void limparCampos(){
		textNome.setText("");
		textAno.setText("");
		textCategoria.setText("");
		textKm.setText("");
		textPlaca.setText("");
		textPortas.setText("");
	}
	
	public void cadastrar(){
		String nome = textNome.getText();
		String placa = textPlaca.getText();
		int ano = Integer.parseInt(textAno.getText());
		int quantidadePorta = Integer.parseInt(textPortas.getText());
		double quilometragem = Double.parseDouble(textKm.getText());
		String categoria = textCategoria.getText();
	
		Carro carro =  new Carro(nome, ano, placa, quantidadePorta, quilometragem, categoria);
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		try{
			fachada.cadastarCarro(carro);
			JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
			limparCampos();
		}catch(Exception e){
			
		}
		
	}//fim do metodo cadastrar
}
