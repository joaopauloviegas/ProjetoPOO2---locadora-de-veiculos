package com.fafica.projeto.Cliente;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class TelaListarCliente {

	private JTable tableCliente;
	private DefaultTableModel defaultTableModelCliente;
	private JFrame frame;
	private JButton btnListar;
	private JTable tableClientes;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTabelaCliente = new JPanel();
		panelTabelaCliente.setBounds(10, 37, 766, 387);
		frame.getContentPane().add(panelTabelaCliente);
		panelTabelaCliente.setLayout(null);
		
		tableClientes = new JTable();
		tableClientes.setToolTipText("");
		tableClientes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "CPF", "Sexo", "Telefone", "Rua", "Complemento", "Bairro", "Cidade"
			}
		));
		tableClientes.setBounds(10, 11, 746, 365);
		panelTabelaCliente.add(tableClientes);
		
		
		
		
		/*JScrollPane scrollPaneTabelaCliente = new JScrollPane();
		scrollPaneTabelaCliente.setBounds(10, 198, 613, 163);
		frame.getContentPane().add(scrollPaneTabelaCliente);
		
		tableCliente = new JTable();
		String colunaTabelaCliente[] = new String[] {"ID", "Nome", "CPF", "Sexo", "Telefone", "Rua","Complemento","Bairro","Cidade"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableCliente.setModel(defaultTableModelCliente);
		scrollPaneTabelaCliente.setViewportView(tableCliente);
		*/
		
		btnListar = new JButton("listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  listar();
			}
		});
		btnListar.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnListar);
	}
	
	private void limparTabelaCliente() {
		defaultTableModelCliente.setNumRows(0);;
	}
	public void listar(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		this.limparTabelaCliente();
		ArrayList<Cliente> clientes = fachada.listarCliente();
		for (Cliente cliente : clientes) {
			Vector vector = new Vector();
			vector.add(cliente.getId());
			vector.add(cliente.getNome());
			vector.add(cliente.getCpf());
			vector.add(cliente.getSexo());
			vector.add(cliente.getNumeroTelefone());
			vector.add(cliente.getEndereco().getRua());
			vector.add(cliente.getEndereco().getComplemento());
			vector.add(cliente.getEndereco().getBairro());
			vector.add(cliente.getEndereco().getCidade());
			tableClientes.add(vector);  
			//defaultTableModelCliente.addRow(vector);
			
			
		}
	}

}
