package com.fafica.projeto.Funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Endereco.CampoObrigatorioException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFuncionario {

	public JFrame frmCadastroFuncionario;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textSexo;
	private JTextField textTelefone;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField textComplemento;
	private JTextField textCidade;
	private JTextField textCEP;
	private JTextField textLogin;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario window = new TelaCadastroFuncionario();
					window.frmCadastroFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroFuncionario = new JFrame();
		frmCadastroFuncionario.setTitle("Cadastro Funcionario");
		frmCadastroFuncionario.setBounds(100, 100, 495, 408);
		frmCadastroFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroFuncionario.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 33, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(74, 30, 355, 22);
		frmCadastroFuncionario.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 68, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(74, 65, 134, 22);
		frmCadastroFuncionario.getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(216, 68, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(258, 65, 171, 22);
		frmCadastroFuncionario.getContentPane().add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 103, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(74, 100, 116, 22);
		frmCadastroFuncionario.getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(12, 188, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(74, 185, 355, 22);
		frmCadastroFuncionario.getContentPane().add(textRua);
		textRua.setColumns(10); 
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(12, 217, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(74, 214, 144, 22);
		frmCadastroFuncionario.getContentPane().add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero:");
		lblNewLabel.setBounds(230, 217, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblNewLabel);
		
		textNumero = new JTextField();
		textNumero.setBounds(290, 214, 139, 22);
		frmCadastroFuncionario.getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Comple:");
		lblComplemento.setBounds(12, 246, 84, 16);
		frmCadastroFuncionario.getContentPane().add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(74, 243, 355, 22);
		frmCadastroFuncionario.getContentPane().add(textComplemento);
		textComplemento.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(12, 275, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(74, 272, 116, 22);
		frmCadastroFuncionario.getContentPane().add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(202, 275, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblCep);
		
		textCEP = new JTextField();
		textCEP.setBounds(232, 272, 197, 22);
		frmCadastroFuncionario.getContentPane().add(textCEP);
		textCEP.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastrar();
				} catch (FuncionarioJaCadastradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(368, 325, 97, 25);
		frmCadastroFuncionario.getContentPane().add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			limparCampos();
			}
		});
		btnLimpar.setBounds(259, 325, 97, 25);
		frmCadastroFuncionario.getContentPane().add(btnLimpar);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(12, 135, 56, 16);
		frmCadastroFuncionario.getContentPane().add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(74, 135, 116, 22);
		frmCadastroFuncionario.getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(202, 135, 70, 16);
		frmCadastroFuncionario.getContentPane().add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(267, 132, 116, 22);
		frmCadastroFuncionario.getContentPane().add(textPassword);
		textPassword.setColumns(10);
	}
	
	public void limparCampos(){
		textNome.setText("");
		textCPF.setText("");
		textSexo.setText("");
		textTelefone.setText("");
		textRua.setText("");
		textBairro.setText("");
		textNumero.setText("");
		textComplemento.setText("");
		textCidade.setText("");
		textCEP.setText("");
		
	}
	
	public void cadastrar()throws FuncionarioJaCadastradoException{
		String nome = textNome.getText();
		String cpf = textCPF.getText();
		String sexo = textSexo.getText();
		String telefone = textTelefone.getText();
		String login = textLogin.getText();
		String password = textPassword.getText();
		String rua = textRua.getText();
		String bairro = textBairro.getText();
		String numero = textNumero.getText();
		String complemento = textComplemento.getText();
		String cidade = textCidade.getText();
		String cep = textCEP.getText();
		
		Funcionario funcionario = new Funcionario(nome, cpf, sexo, telefone);
		Endereco endereco = new Endereco(rua,cpf,numero,bairro,complemento,cidade,cep);
		
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		try{
			fachada.cadastrarFuncionario(funcionario);
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
	}
}
