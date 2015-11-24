package com.fafica.projeto.Funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarFuncionario {

	public JFrame frame;
	private JTextField textCPF;
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textSexo;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField textComplemento;
	private JTextField textCidade;
	private JTextField textCEP;
	private Fachada fachada;
	private Endereco endereco;
	private Funcionario funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarFuncionario window = new TelaAtualizarFuncionario();
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
	public TelaAtualizarFuncionario() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 668, 84);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 24, 58, 21);
		panel.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(70, 23, 137, 22);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					procurar();
				} catch (ClienteNaoEncontradoException | CPFInvalidoException
						| EnderecoNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(217, 23, 89, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 106, 668, 175);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(66, 8, 569, 20);
		panel_1.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(10, 36, 46, 14);
		panel_1.add(lblNewLabel);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(66, 33, 144, 20);
		panel_1.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo:");
		lblNewLabel_1.setBounds(241, 39, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		textSexo = new JTextField();
		textSexo.setBounds(297, 33, 144, 20);
		panel_1.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rua:");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textRua = new JTextField();
		textRua.setBounds(66, 58, 569, 20);
		panel_1.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 86, 46, 14);
		panel_1.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(66, 83, 144, 20);
		panel_1.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(241, 86, 46, 14);
		panel_1.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(297, 83, 144, 20);
		panel_1.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 111, 58, 14);
		panel_1.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(66, 108, 569, 20);
		panel_1.add(textComplemento);
		textComplemento.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 136, 46, 14);
		panel_1.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(66, 133, 144, 20);
		panel_1.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CEP:");
		lblNewLabel_3.setBounds(241, 136, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		textCEP = new JTextField();
		textCEP.setBounds(297, 133, 144, 20);
		panel_1.add(textCEP);
		textCEP.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setBounds(599, 292, 89, 23);
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(497, 292, 89, 23);
		frame.getContentPane().add(btnLimpar);
	}
	
	public void procurar() throws ClienteNaoEncontradoException, CPFInvalidoException, EnderecoNaoEncontradoException{
		String cpf = textCPF.getText();
		funcionario = fachada.buscarFuncionario(cpf);
		endereco = fachada.buscarEndereco(cpf);
				
		textNome.setText(funcionario.getNome());
		textTelefone.setText(funcionario.getNumeroTelefone());
		textSexo.setText(funcionario.getSexo());
		textRua.setText(endereco.getRua());
		textBairro.setText(endereco.getBairro());
		textComplemento.setText(endereco.getComplemento());
		textCidade.setText(endereco.getCidade());
		textNumero.setText(endereco.getNumero());
		textCEP.setText(endereco.getCep());
		
		
	}
	
	
public void atualizar() throws ClienteNaoEncontradoException, CPFInvalidoException, CampoObrigatorioException {
		
		String nome = textNome.getText();
		String sexo = textSexo.getText();
		String telefone = textTelefone.getText();
		String cpf = textCPF.getText();
		
		String rua = textRua.getText();
		String bairro = textBairro.getText();
		String complemento = textComplemento.getText();
		String cidade = textCidade.getText(); 
		String numero = textNumero.getText();
		String cep = textCEP.getText();
		try{
			
			funcionario =  new Funcionario(nome,cpf,sexo,telefone);
			fachada.atualizarFuncionario(funcionario);
			
			endereco = new Endereco(rua,cpf, numero, bairro, complemento, cidade, cep);
			fachada.atualizarEndereco(endereco);
			
		
		limparCampos();
		
		}catch (Exception e) {
			
		}
	}//fim datualizar
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


}

