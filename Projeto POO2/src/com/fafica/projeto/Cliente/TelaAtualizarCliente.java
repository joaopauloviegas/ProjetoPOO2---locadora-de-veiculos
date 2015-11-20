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
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class TelaAtualizarCliente {

	public JFrame frmTelaAtualizarCliente;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textTelefone;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textBairro;
	private JTextField textCidade;
	private Fachada fachada;
	private Cliente cliente;
	private Endereco endereco;
	private JTextField textNumero;
	private JTextField textCep;
	private JTable tableCliente;
	private DefaultTableModel defaultTableModelCliente;
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
		frmTelaAtualizarCliente.setBounds(100, 100, 827, 435);
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
		textCPF.setToolTipText("Digite o CPF");
		textCPF.setBounds(74, 19, 135, 20);
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
				} catch (EnderecoNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.setBounds(232, 18, 105, 23);
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
		textNome.setToolTipText("Digite o nome");
		textNome.setColumns(10);
		textNome.setBounds(76, 8, 376, 20);
		panel_1.add(textNome);
		
		JLabel label_2 = new JLabel("SEXO: ");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(253, 39, 46, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("TELEFONE: ");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 36, 69, 14);
		panel_1.add(label_3);
		
		textTelefone = new JTextField();
		textTelefone.setToolTipText("Digite o telefone");
		textTelefone.setColumns(10);
		textTelefone.setBounds(76, 33, 143, 20);
		panel_1.add(textTelefone);
		
		JLabel label_4 = new JLabel("RUA: ");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 67, 46, 14);
		panel_1.add(label_4);
		
		textRua = new JTextField();
		textRua.setToolTipText("Digite o nome da rua");
		textRua.setColumns(10);
		textRua.setBounds(76, 64, 376, 20);
		panel_1.add(textRua);
		
		JLabel label_5 = new JLabel("COMPLEMENTO:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 92, 87, 14);
		panel_1.add(label_5);
		
		textComplemento = new JTextField();
		textComplemento.setToolTipText("Digite o complemento");
		textComplemento.setColumns(10);
		textComplemento.setBounds(107, 89, 345, 20);
		panel_1.add(textComplemento);
		
		JLabel label_6 = new JLabel("BAIRRO:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(10, 117, 56, 14);
		panel_1.add(label_6);
		
		textBairro = new JTextField();
		textBairro.setToolTipText("Digite o nome do bairro");
		textBairro.setColumns(10);
		textBairro.setBounds(76, 114, 376, 20);
		panel_1.add(textBairro);
		
		JLabel label_7 = new JLabel("CIDADE:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 148, 59, 14);
		panel_1.add(label_7);
		
		textCidade = new JTextField();
		textCidade.setToolTipText("Digite o nome da cidade");
		textCidade.setColumns(10);
		textCidade.setBounds(76, 145, 376, 20);
		panel_1.add(textCidade);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(10, 173, 56, 14);
		panel_1.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setToolTipText("Digite o numero da residencia");
		textNumero.setBounds(76, 171, 86, 20);
		panel_1.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCep.setBounds(206, 174, 46, 14);
		panel_1.add(lblCep);
		
		textCep = new JTextField();
		textCep.setToolTipText("Digite o cep");
		textCep.setBounds(262, 171, 99, 20);
		panel_1.add(textCep);
		textCep.setColumns(10);
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(304, 35, 46, 23);
		panel_1.add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(369, 35, 56, 23);
		panel_1.add(rdbtnF);
		
		grupo.add(rdbtnM);
		grupo.add(rdbtnF);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 331, 791, 54);
		frmTelaAtualizarCliente.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(326, 10, 124, 25);
		panel_2.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizar();
					atualizarEndereco();
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
		button_1.setBounds(227, 11, 89, 23);
		panel_2.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton("LISTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (SQLException | CarroNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(692, 12, 89, 23);
		panel_2.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(542, 32, 259, 293);
		frmTelaAtualizarCliente.getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		String colunaTabelaCliente[] = new String[] {"Nome", "CPF"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCliente.setModel(defaultTableModelCliente);
		scrollPane.setViewportView(tableCliente);
	}// fim do main
	
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
	
	public void procurar() throws ClienteNaoEncontradoException, CPFInvalidoException, EnderecoNaoEncontradoException{
		String cpf = textCPF.getText();
		cliente = fachada.procurarCliente(cpf);
		endereco = fachada.buscarEndereco(cpf);
		
		
		
		textNome.setText(cliente.getNome());
		textTelefone.setText(cliente.getNumeroTelefone());
		textRua.setText(endereco.getRua());
		textBairro.setText(endereco.getBairro());
		textComplemento.setText(endereco.getComplemento());
		textCidade.setText(endereco.getCidade());
		textNumero.setText(endereco.getNumero());
		textCep.setText(endereco.getCep());
		
		
	}
	
		public void atualizarEndereco() throws ClienteNaoEncontradoException, CPFInvalidoException, CampoObrigatorioException {
		
		
		String rua = textRua.getText();
		String bairro = textBairro.getText();
		String complemento = textComplemento.getText();
		String cidade = textCidade.getText(); 
		String numero = textNumero.getText();
		String cep = textCep.getText();
		String cpf = textCPF.getText();
		
		try{
			endereco = new Endereco(rua,cpf, numero, bairro, complemento, cidade, cep);
			fachada.atualizarEndereco(endereco);
			
		
		limparCampos();
		
		}catch (Exception e) {
			
		}
	}
	public void atualizar() throws ClienteNaoEncontradoException, CPFInvalidoException, CampoObrigatorioException {
		
		String nome = textNome.getText();
		String sexo = selecionarSexo();
		String telefone = textTelefone.getText();
		String cpf = textCPF.getText();
		
		/*String rua = textRua.getText();
		String bairro = textBairro.getText();
		String complemento = textComplemento.getText();
		String cidade = textCidade.getText(); 
		String numero = textNumero.getText();
		String cep = textCep.getText();*/
		try{
			
			cliente = new Cliente(nome,cpf,sexo,telefone);
			fachada.atualizarCliente(cliente);
			
			//endereco = new Endereco(rua,cpf, numero, bairro, complemento, cidade, cep);
			//fachada.atualizarEndereco(endereco);
			
		
		limparCampos();
		
		}catch (Exception e) {
			
		}
	}
		
	
	public void preencherDados(){
		 textNome.setText("");
	}
	
	public void listar() throws SQLException, CarroNaoEncontradoException{
		limparTabelaCarro();
		ArrayList<Cliente> clientes = fachada.listarCliente();

		try{
			for (Cliente cliente : clientes) {
				Vector vector = new Vector();
				vector.add(cliente.getNome());
				vector.add(cliente.getCpf());
				
				defaultTableModelCliente.addRow(vector);
			}//fim do for
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
	
	private void limparTabelaCarro() {
		defaultTableModelCliente.setRowCount(0);
	}
	
	private String selecionarSexo(){
		String sexo = "";
		if(rdbtnM.isSelected()) sexo = "M";
		if(rdbtnF.isSelected()) sexo = "F";
		return sexo;
		
	}
}// fim da classe
