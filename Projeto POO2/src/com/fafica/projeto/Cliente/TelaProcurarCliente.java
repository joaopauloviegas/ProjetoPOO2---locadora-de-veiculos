package com.fafica.projeto.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaProcurarCliente {

	public JFrame frmTelaProcurarCliente;
	
	private JTextField textCPF;
	private JTextField textSexo;
	private JTextField textTelefone;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textNome;
	private JTextField textNumero;
	private JTextField textCep;
	private Cliente cliente;
	private Endereco endereco;
	private DefaultTableModel defaultTableModelCliente;
	private Fachada fachada;
	private JTable tableCliente;

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
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaProcurarCliente = new JFrame();
		frmTelaProcurarCliente.setTitle("Tela Procurar Cliente");
		frmTelaProcurarCliente.setBounds(100, 100, 747, 365);
		frmTelaProcurarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaProcurarCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 33, 711, 284);
		frmTelaProcurarCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 31, 39, 14);
		panel.add(lblNewLabel);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("Digite CPF que deseja remover");
		textCPF.setBounds(122, 29, 163, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(311, 28, 102, 23);
		panel.add(btnProcurar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(10, 84, 46, 14);
		panel.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(314, 109, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(10, 109, 67, 14);
		panel.add(lblTelefone);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(105, 69, 46, -3);
		panel.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBairro.setBounds(10, 188, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComplemento.setBounds(10, 163, 102, 14);
		panel.add(lblComplemento);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCidade.setBounds(10, 213, 67, 14);
		panel.add(lblCidade);
		
		JLabel lblRua_1 = new JLabel("Rua:");
		lblRua_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRua_1.setBounds(10, 138, 46, 14);
		panel.add(lblRua_1);
		
		textSexo = new JTextField();
		textSexo.setToolTipText("Digite o sexo");
		textSexo.setText("");
		textSexo.setBounds(370, 107, 62, 20);
		panel.add(textSexo);
		textSexo.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setToolTipText("Digite o telefone");
		textTelefone.setText("");
		textTelefone.setBounds(122, 107, 143, 20);
		panel.add(textTelefone);
		textTelefone.setColumns(10);
		
		textRua = new JTextField();
		textRua.setToolTipText("Digite o nome da rua");
		textRua.setBounds(122, 135, 310, 20);
		panel.add(textRua);
		textRua.setColumns(10);
		
		textComplemento = new JTextField();
		textComplemento.setToolTipText("Digite o complemento");
		textComplemento.setBounds(122, 161, 310, 20);
		panel.add(textComplemento);
		textComplemento.setColumns(10);
		
		textBairro = new JTextField();
		textBairro.setToolTipText("Digite o bairro");
		textBairro.setBounds(122, 186, 310, 20);
		panel.add(textBairro);
		textBairro.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setToolTipText("Digite o nome da cidade");
		textCidade.setBounds(122, 210, 310, 20);
		panel.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblDadosCadastrais = new JLabel("Dados Cadastrais");
		lblDadosCadastrais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosCadastrais.setBounds(10, 59, 120, 14);
		panel.add(lblDadosCadastrais);
		
		textNome = new JTextField();
		textNome.setToolTipText("Digite o nome");
		textNome.setBounds(122, 82, 310, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(10, 238, 67, 14);
		panel.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setToolTipText("Digite o numero");
		textNumero.setBounds(122, 236, 86, 20);
		panel.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCep.setBounds(258, 241, 46, 14);
		panel.add(lblCep);
		
		textCep = new JTextField();
		textCep.setToolTipText("Digite o CEP");
		textCep.setBounds(314, 236, 118, 20);
		panel.add(textCep);
		textCep.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(446, 30, 255, 200);
		panel.add(scrollPane);
		
		tableCliente = new JTable();
		String colunaTabelaCliente[] = new String[] {"Nome", "CPF"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableCliente.setModel(defaultTableModelCliente);
		scrollPane.setViewportView(tableCliente);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarClientes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(612, 235, 89, 23);
		panel.add(btnListar);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o CPF que deseja procurar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(228, 8, 266, 22);
		frmTelaProcurarCliente.getContentPane().add(lblNewLabel_1);
	}
	
	public void procurar(){
	
		try{
			
			String cpf = textCPF.getText();
			cliente = fachada.procurarCliente(cpf);
			
			
			
			textNome.setText(cliente.getNome());
			textTelefone.setText(cliente.getNumeroTelefone());
			textSexo.setText(cliente.getSexo());
			
			endereco = fachada.buscarEndereco(cpf);
			
			textRua.setText(endereco.getRua());
			textBairro.setText(endereco.getBairro());
			textCidade.setText(endereco.getCidade());
			textComplemento.setText(endereco.getComplemento());
			textCep.setText(endereco.getCep());
			textNumero.setText(endereco.getNumero());

			
			
		}catch(Exception e){
			
		}
		
	}// fim do metodo procurar
	

	public void listarClientes() throws SQLException{
	    limparTabelaCliente();
		ArrayList<Cliente> clientes = fachada.listarCliente();
		
		try{
			Vector vector = null;
			for (Cliente cliente : clientes) {
					vector =  new Vector();
					vector.add(cliente.getNome());
					vector.add(cliente.getCpf());
					defaultTableModelCliente.addRow(vector);
			}// fim do for  
			
			
		}catch(Exception e){
			
		}//fim do try/catch
	
	}
	
	private void limparTabelaCliente() {
		  defaultTableModelCliente.setRowCount(0);
	}
}// fim da classe
