package com.fafica.projeto.Funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBuscarFuncionario {

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
	private Funcionario funcionario;
	private Endereco endereco;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarFuncionario window = new TelaBuscarFuncionario();
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
	public TelaBuscarFuncionario() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 616, 245);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(21, 30, 46, 14);
		panel.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(73, 27, 183, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnProcurar.setBounds(266, 26, 89, 23);
		panel.add(btnProcurar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 91, 46, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(73, 88, 531, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(21, 116, 46, 14);
		panel.add(lblNewLabel);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(73, 113, 204, 20);
		panel.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo:");
		lblNewLabel_1.setBounds(298, 116, 46, 14);
		panel.add(lblNewLabel_1);
		
		textSexo = new JTextField();
		textSexo.setBounds(333, 113, 117, 20);
		panel.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblDadosCadastrais = new JLabel("Dados Cadastrais");
		lblDadosCadastrais.setBounds(21, 55, 100, 14);
		panel.add(lblDadosCadastrais);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(21, 141, 46, 14);
		panel.add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(73, 138, 531, 20);
		panel.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Bairro:");
		lblNewLabel_2.setBounds(21, 164, 46, 14);
		panel.add(lblNewLabel_2);
		
		textBairro = new JTextField();
		textBairro.setBounds(73, 161, 204, 20);
		panel.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(298, 164, 46, 14);
		panel.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(344, 161, 106, 20);
		panel.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblComple = new JLabel("Comple:");
		lblComple.setBounds(21, 189, 46, 14);
		panel.add(lblComple);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(73, 186, 531, 20);
		panel.add(textComplemento);
		textComplemento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cidade:");
		lblNewLabel_3.setBounds(21, 214, 46, 14);
		panel.add(lblNewLabel_3);
		
		textCidade = new JTextField();
		textCidade.setBounds(73, 211, 204, 20);
		panel.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(298, 217, 46, 14);
		panel.add(lblCep);
		
		textCEP = new JTextField();
		textCEP.setBounds(333, 211, 129, 20);
		panel.add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF que deseja buscar");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf.setBounds(202, 13, 207, 17);
		frame.getContentPane().add(lblDigiteOCpf);
	}
	
	
	public void buscar(){ 
		try{
		String cpf = textCPF.getText();
		funcionario = fachada.buscarFuncionario(cpf);
		
		textNome.setText(funcionario.getNome());
		textTelefone.setText(funcionario.getNumeroTelefone());
		textSexo.setText(funcionario.getSexo());
		
		endereco = fachada.buscarEndereco(cpf);
		
		textRua.setText(endereco.getRua());  
		textBairro.setText(endereco.getBairro());
		textNumero.setText(endereco.getNumero());
		textComplemento.setText(endereco.getComplemento());
		textCidade.setText(endereco.getCidade());
		textCEP.setText(endereco.getCep());
		} catch(Exception e){
			
		}//fim do try
		
}

}
