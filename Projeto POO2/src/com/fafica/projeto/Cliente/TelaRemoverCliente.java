package com.fafica.projeto.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRemoverCliente {

	public JFrame frmTelaRemoverCliente;
	private JTextField textCPF;
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
					TelaRemoverCliente window = new TelaRemoverCliente();
					window.frmTelaRemoverCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverCliente() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRemoverCliente = new JFrame();
		frmTelaRemoverCliente.setTitle("Tela Remover Cliente");
		frmTelaRemoverCliente.setBounds(100, 100, 558, 338);
		frmTelaRemoverCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaRemoverCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 406, 113);
		frmTelaRemoverCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite CPF do cliente que deseja remover");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(46, 11, 312, 14);
		panel.add(lblNewLabel);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					remover();
				} catch (ClienteNaoEncontradoException e) {
					
					e.printStackTrace();
				} catch (EnderecoNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemover.setBounds(222, 57, 100, 23);
		panel.add(btnRemover);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 61, 46, 14);
		panel.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("Digite o CPF do cliente que deseja remover");
		textCPF.setBounds(66, 59, 132, 20);
		panel.add(textCPF);
		textCPF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 264, 150);
		frmTelaRemoverCliente.getContentPane().add(scrollPane);
		
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
			public void actionPerformed(ActionEvent arg0) {
				try {
					listarClientes();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(432, 265, 100, 23);
		frmTelaRemoverCliente.getContentPane().add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(327, 262, 89, 23);
		frmTelaRemoverCliente.getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
	}
	
	public void remover() throws ClienteNaoEncontradoException, EnderecoNaoEncontradoException{
		//Fachada fachada = new Fachada();
		//fachada.getInstance();
		try{
			String cpf = textCPF.getText();
			fachada.removerCliente(cpf);
			fachada.removerEndereco(cpf);
			//JOptionPane.showMessageDialog(null,"cliente removido com sucesso");
			
		}catch( CPFInvalidoException e){
			
		}
		
				
			
    }// fim do metodo remover 
	
	public void listarClientes() throws SQLException{
	    limparTabelaCliente();
		ArrayList<Cliente> clientes = fachada.listarCliente();

		try{
			
			for (Cliente cliente : clientes) {
	
					
					Vector vector =  new Vector();
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
	
	public void limparCampos(){
		textCPF.setText("");
		limparTabelaCliente();
	}
}
