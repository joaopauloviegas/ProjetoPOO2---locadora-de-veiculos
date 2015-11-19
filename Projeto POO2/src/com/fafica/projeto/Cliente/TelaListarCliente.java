package com.fafica.projeto.Cliente;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaListarCliente {

	private JFrame frame;
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
	public TelaListarCliente() {
		fachada = Fachada.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 746, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 710, 320);
		frame.getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		String colunaTabelaCliente[] = new String[] {"Nome", "CPF", "Sexo", "Telefone", "Rua", "Numero","Complemento","Bairro","Cidade","CEP"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableCliente.setModel(defaultTableModelCliente);
		scrollPane.setViewportView(tableCliente);
		
		JButton btnListarCliente = new JButton("Listar Clientes");
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
		frame.getContentPane().add(btnListarCliente);
	
	
	
	
	
	
	}
	
	public void listarClientes() throws SQLException{
	
		ArrayList<Cliente> clientes = fachada.listarCliente();
		
		try{
			for (Cliente cliente : clientes) {
				Vector vector =  new Vector<>();
				vector.add(cliente.getNome());
				vector.add(cliente.getCpf());
				vector.add(cliente.getSexo());
				vector.add(cliente.getNumeroTelefone());
				defaultTableModelCliente.addRow(vector);
			}// fim do fot
		}catch(Exception e){
			
		}//fim do try/catch
	
	}
}// fim da classe
