package com.fafica.projeto.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.ScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Button;

public class TelaAtualizarCliente {

	private JFrame frmTelaAtualizarCliente;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textSexo;
	private JTextField textTelefone;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textBairro;
	private JTextField textCidade;
	private Fachada fachada;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarCliente window = new TelaAtualizarCliente();
					window.frmTelaAtualizarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAtualizarCliente() {
		fachada = Fachada.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAtualizarCliente = new JFrame();
		frmTelaAtualizarCliente.setTitle("Tela Atualizar Cliente");
		frmTelaAtualizarCliente.setBounds(100, 100, 520, 434);
		frmTelaAtualizarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaAtualizarCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 484, 66);
		frmTelaAtualizarCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("CPF: ");
		label_1.setBounds(10, 22, 46, 14);
		panel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textCPF = new JTextField();
		textCPF.setBounds(66, 19, 143, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					procurar();
				} catch (ClienteNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CPFInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.setBounds(232, 18, 89, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 110, 484, 215);
		frmTelaAtualizarCliente.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("NOME: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 11, 46, 14);
		panel_1.add(label);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(76, 8, 376, 20);
		panel_1.add(textNome);
		
		JLabel label_2 = new JLabel("SEXO: ");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(253, 39, 46, 14);
		panel_1.add(label_2);
		
		textSexo = new JTextField();
		textSexo.setColumns(10);
		textSexo.setBounds(309, 33, 143, 20);
		panel_1.add(textSexo);
		
		JLabel label_3 = new JLabel("TELEFONE: ");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 36, 69, 14);
		panel_1.add(label_3);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(76, 33, 143, 20);
		panel_1.add(textTelefone);
		
		JLabel label_4 = new JLabel("RUA: ");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 86, 46, 14);
		panel_1.add(label_4);
		
		textRua = new JTextField();
		textRua.setColumns(10);
		textRua.setBounds(76, 83, 376, 20);
		panel_1.add(textRua);
		
		JLabel label_5 = new JLabel("COMPLEMENTO:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 111, 87, 14);
		panel_1.add(label_5);
		
		textComplemento = new JTextField();
		textComplemento.setColumns(10);
		textComplemento.setBounds(107, 108, 345, 20);
		panel_1.add(textComplemento);
		
		JLabel label_6 = new JLabel("BAIRRO:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(10, 136, 56, 14);
		panel_1.add(label_6);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(76, 133, 376, 20);
		panel_1.add(textBairro);
		
		JLabel label_7 = new JLabel("CIDADE:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 161, 59, 14);
		panel_1.add(label_7);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(76, 158, 376, 20);
		panel_1.add(textCidade);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 331, 484, 54);
		frmTelaAtualizarCliente.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(345, 10, 124, 25);
		panel_2.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizar();
				} catch (ClienteNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CPFInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CampoObrigatorioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton button_1 = new JButton("LIMPAR");
		button_1.setBounds(232, 11, 89, 23);
		panel_2.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	}// fim do main
	
	public void limparCampos(){
		textNome.setText("");
		textCPF.setText("");
		textSexo.setText("");
		textTelefone.setText("");
		textRua.setText("");
		textBairro.setText("");
		textComplemento.setText("");
		textCidade.setText("");

	}
	
	public void procurar() throws ClienteNaoEncontradoException, CPFInvalidoException{
		String cpf = textCPF.getText();
		cliente = fachada.procurarCliente(cpf);
		
		
		textNome.setText(cliente.getNome());
		textTelefone.setText(cliente.getNumeroTelefone());
		textSexo.setText(cliente.getSexo());
		
	}
	public void atualizar() throws ClienteNaoEncontradoException, CPFInvalidoException, CampoObrigatorioException {
		
		String nome = textNome.getText();
		String sexo = textSexo.getText();
		String telefone = textTelefone.getText();
		String cpf = textCPF.getText();
		try{
			
			cliente = new Cliente(nome,cpf,sexo,telefone);
			fachada.atualizarCliente(cliente);
			
		JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso");
		limparCampos();
		
		}catch (Exception e) {
			
		}
	}
		
	
	public void preencherDados(){
		 textNome.setText("");
	}
}// fim da classe
