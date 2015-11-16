package com.fafica.projeto.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProcurarCliente {

	private JFrame frmTelaProcurarCliente;
	
	private JTextField textCPF;
	private JTextField textSexo;
	private JTextField textTelefone;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcurarCliente window = new TelaProcurarCliente();
					window.frmTelaProcurarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// fim do main

	/**
	 * Create the application.
	 */
	public TelaProcurarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaProcurarCliente = new JFrame();
		frmTelaProcurarCliente.setTitle("Tela Procurar Cliente");
		frmTelaProcurarCliente.setBounds(100, 100, 747, 393);
		frmTelaProcurarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaProcurarCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 711, 332);
		frmTelaProcurarCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 31, 39, 14);
		panel.add(lblNewLabel);
		
		textCPF = new JTextField();
		textCPF.setBounds(59, 28, 163, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(232, 27, 89, 23);
		panel.add(btnProcurar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 84, 46, 14);
		panel.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(244, 112, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(3, 109, 46, 14);
		panel.add(lblTelefone);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(105, 69, 46, -3);
		panel.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 265, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 240, 89, 14);
		panel.add(lblComplemento);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 290, 46, 14);
		panel.add(lblCidade);
		
		JLabel lblRua_1 = new JLabel("Rua:");
		lblRua_1.setBounds(10, 215, 46, 14);
		panel.add(lblRua_1);
		
		textSexo = new JTextField();
		textSexo.setText("");
		textSexo.setBounds(300, 109, 86, 20);
		panel.add(textSexo);
		textSexo.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setText("");
		textTelefone.setBounds(59, 106, 143, 20);
		panel.add(textTelefone);
		textTelefone.setColumns(10);
		
		textRua = new JTextField();
		textRua.setBounds(59, 212, 631, 20);
		panel.add(textRua);
		textRua.setColumns(10);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(105, 237, 585, 20);
		panel.add(textComplemento);
		textComplemento.setColumns(10);
		
		textBairro = new JTextField();
		textBairro.setBounds(66, 262, 624, 20);
		panel.add(textBairro);
		textBairro.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setBounds(66, 287, 624, 20);
		panel.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereo.setBounds(10, 177, 78, 14);
		panel.add(lblEndereo);
		
		JLabel lblDadosCadastrais = new JLabel("Dados Cadastrais");
		lblDadosCadastrais.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDadosCadastrais.setBounds(10, 59, 120, 14);
		panel.add(lblDadosCadastrais);
		
		textNome = new JTextField();
		textNome.setBounds(59, 81, 327, 20);
		panel.add(textNome);
		textNome.setColumns(10);
	}
	
	public void procurar(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{
			
			String cpf = textCPF.getText();
			Cliente cliente = fachada.procurarCliente(cpf);
			
			
			textNome.setText(cliente.getNome());
			textTelefone.setText(cliente.getNumeroTelefone());
			textSexo.setText(cliente.getSexo());
			
			// ta faltando retornar o endereco e setar no text
			/*textRua.setText(cliente.getEndereco().getRua());
			textComplemento.setText(cliente.getEndereco().getComplemento());
			textBairro.setText(cliente.getEndereco().getBairro());
			textCidade.setText(cliente.getEndereco().getCidade());*/
			
		}catch(Exception e){
			
		}
		
	}// fim do metodo procurar
}// fim da classe
