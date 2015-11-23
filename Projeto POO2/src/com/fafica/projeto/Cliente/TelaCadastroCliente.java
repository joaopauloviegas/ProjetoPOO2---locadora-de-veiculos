package com.fafica.projeto.Cliente;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.fafica.projeto.Endereco.CampoObrigatorioException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.acl.Group;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaCadastroCliente {

	public JFrame frmTelaCadastroCliente;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textTelefone;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textCep;
	private JTextField textNumero;
	private ButtonGroup grupo = new ButtonGroup();
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmTelaCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastroCliente = new JFrame();
		frmTelaCadastroCliente.setTitle("Tela Cadastro Cliente");
		frmTelaCadastroCliente.setBounds(100, 100, 528, 374);
		frmTelaCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastroCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 492, 296);
		frmTelaCadastroCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(76, 8, 376, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 36, 46, 14);
		panel.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(76, 33, 143, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblSexo = new JLabel("SEXO: ");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setBounds(253, 39, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblTelefone = new JLabel("TELEFONE: ");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(10, 61, 69, 14);
		panel.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(76, 58, 143, 20);
		panel.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblRua = new JLabel("RUA: ");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setBounds(10, 86, 46, 14);
		panel.add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(76, 83, 376, 20);
		panel.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblComplemento = new JLabel("COMPLEMENTO:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplemento.setBounds(10, 136, 87, 14);
		panel.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(107, 133, 345, 20);
		panel.add(textComplemento);
		textComplemento.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setBounds(10, 168, 56, 14);
		panel.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(76, 165, 376, 20);
		panel.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(10, 199, 59, 14);
		panel.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(76, 196, 376, 20);
		panel.add(textCidade);
		textCidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarCliente();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(359, 262, 123, 23);
		panel.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.setBounds(260, 262, 89, 23);
		panel.add(btnLimpar);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(10, 111, 46, 14);
		panel.add(lblCep);
		
		textCep = new JTextField();
		textCep.setBounds(76, 108, 114, 20);
		panel.add(textCep);
		textCep.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(200, 111, 56, 14);
		panel.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(266, 108, 86, 20);
		panel.add(textNumero);
		textNumero.setColumns(10);
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(303, 35, 46, 23);
		panel.add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(359, 35, 46, 23);
		panel.add(rdbtnF);
		
		grupo.add(rdbtnM);
		grupo.add(rdbtnF);
	}
	

	
	public void limparCampos(){
		textNome.setText("");
		textCPF.setText("");
		textTelefone.setText("");
		textRua.setText("");
		textBairro.setText("");
		textComplemento.setText("");
		textCidade.setText("");
		textNumero.setText("");
		textCep.setText("");

	}
	private String selecionarSexo(){
		String sexo = "";
		if(rdbtnM.isSelected()) sexo = "M";
		if(rdbtnF.isSelected()) sexo = "F";
		return sexo;
		
	}
	public void cadastrarCliente(){
		
		String nome = textNome.getText();
		String cpf = textCPF.getText();
		String sexo =  selecionarSexo();
		String numeroTelefone = textTelefone.getText();
		String rua = textRua.getText();
		String bairro = textBairro.getText();
		String complemento = textComplemento.getText();
		String cidade = textCidade.getText();
		String cep = textCep.getText();
		String numero = textNumero.getText();

		Cliente cliente = new Cliente(nome, cpf, sexo, numeroTelefone);
		Endereco endereco = new Endereco(rua, cpf, numero,bairro, complemento, cidade, cep);
		
		
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		try{
			fachada.cadastarCliente(cliente);
			fachada.cadastrarEndereco(endereco);
		
			limparCampos();
			
		}catch (IllegalArgumentException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CPFInvalidoException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EnderecoJaCadastradoException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		

		
		
	}// fim do metodo cadastrar cliente
}// fim da classe
