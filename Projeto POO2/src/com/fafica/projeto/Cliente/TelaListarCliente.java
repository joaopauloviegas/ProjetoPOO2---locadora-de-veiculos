package com.fafica.projeto.Cliente;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaListarCliente {

	public JFrame frmTelaListarClientes;
	private JTable tableCliente;
	private DefaultTableModel defaultTableModelCliente;
	private Fachada fachada;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarCliente window = new TelaListarCliente();
					window.frmTelaListarClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarCliente() {
		fachada = Fachada.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaListarClientes = new JFrame();
		frmTelaListarClientes.setTitle("Tela Listar Clientes");
		frmTelaListarClientes.setBounds(100, 100, 847, 430);
		frmTelaListarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaListarClientes.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 811, 320);
		frmTelaListarClientes.getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		String colunaTabelaCliente[] = new String[] {"Nome", "CPF", "Sexo", "Telefone", "Rua", "Numero","Bairro","Complemento","Cidade","CEP"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableCliente.setModel(defaultTableModelCliente);
		scrollPane.setViewportView(tableCliente);
		
		JButton btnListarCliente = new JButton("Listar Clientes");
		btnListarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listarClientes();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListarCliente.setBounds(269, 11, 147, 23);
		frmTelaListarClientes.getContentPane().add(btnListarCliente);
	
	
	
	
	
	
	}
	
	
	public void listarClientes() throws SQLException{
	    limparTabelaCliente();
		ArrayList<Cliente> clientes = fachada.listarCliente();
		ArrayList<Endereco> enderecos = fachada.listarEndereco();
		try{
			Vector vector = null;
			for (Cliente cliente : clientes) {
				
				for (Endereco endereco : enderecos) {
					
					vector =  new Vector();
					vector.add(cliente.getNome());
					vector.add(cliente.getCpf());
					vector.add(cliente.getSexo());
					vector.add(cliente.getNumeroTelefone());
					vector.add(endereco.getRua());
					vector.add(endereco.getNumero());
					vector.add(endereco.getBairro());
					vector.add(endereco.getComplemento());
					vector.add(endereco.getCidade());
					vector.add(endereco.getCep());
					//defaultTableModelCliente.addRow(vector);
				}
				
				defaultTableModelCliente.addRow(vector);
			}// fim do for  
			
			
		}catch(Exception e){
			
		}//fim do try/catch
	
	}
	
	private void limparTabelaCliente() {
		  defaultTableModelCliente.setRowCount(0);
	}
}// fim da classe
