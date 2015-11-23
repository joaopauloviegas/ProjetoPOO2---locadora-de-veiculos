package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRemoverSaidaDeVeiculo {

	public JFrame frmTelaRemoverSaida;
	private JTextField textID;
	private JTable tableSaidaVeiculo;
	private DefaultTableModel defaultTableModelSaidaVeiculo;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverSaidaDeVeiculo window = new TelaRemoverSaidaDeVeiculo();
					window.frmTelaRemoverSaida.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverSaidaDeVeiculo() {
		initialize();
		fachada = Fachada.getInstance();
				
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRemoverSaida = new JFrame();
		frmTelaRemoverSaida.setTitle("Tela Remover Saida de Veiculo");
		frmTelaRemoverSaida.setBounds(100, 100, 810, 471);
		frmTelaRemoverSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaRemoverSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 774, 89);
		frmTelaRemoverSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 33, 46, 14);
		panel.add(lblNewLabel);
		
		textID = new JTextField();
		textID.setToolTipText("Digite o ID que deseja remover");
		textID.setBounds(66, 30, 86, 20);
		panel.add(textID);
		textID.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(162, 29, 120, 23);
		panel.add(btnRemover);
		
		JLabel lblDigiteOId = new JLabel("Digite o ID que deseja remover:");
		lblDigiteOId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDigiteOId.setBounds(270, 11, 256, 22);
		frmTelaRemoverSaida.getContentPane().add(lblDigiteOId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 774, 218);
		frmTelaRemoverSaida.getContentPane().add(scrollPane);
		
		tableSaidaVeiculo = new JTable();
		String colunaTabelaSaidaVeiculo[] = new String[] {"ID", "Cliente", "Funcionario", "Data", "Hora", "Placa", "Valor","Combustivel"};
		defaultTableModelSaidaVeiculo = new DefaultTableModel(new Object[] []{ }, colunaTabelaSaidaVeiculo) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableSaidaVeiculo.setModel(defaultTableModelSaidaVeiculo);
		scrollPane.setViewportView(tableSaidaVeiculo);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarSaidaVeiculo();
				} catch (SQLException | CarroNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(695, 387, 89, 23);
		frmTelaRemoverSaida.getContentPane().add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabelaSaidaVeiculo();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.setBounds(586, 387, 89, 23);
		frmTelaRemoverSaida.getContentPane().add(btnLimpar);
	}

	public void remover(){
		limparTabelaSaidaVeiculo();
		Fachada fachada = new Fachada();
		fachada.getInstance();
				
		String idString = textID.getText();
		int id = Integer.parseInt(idString);
		
		try{
			fachada.removerSaidaDeVeiculos(id);
		}catch(Exception e){
			
		}// fim do try/catch
		JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			try {
				listarSaidaVeiculo();
			} catch (SQLException | CarroNaoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					listarSaidaVeiculo();
				} catch (SQLException | CarroNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}// fim do metodo remover
	
	public void listarSaidaVeiculo() throws SQLException, CarroNaoEncontradoException{
		limparTabelaSaidaVeiculo();
		ArrayList<CadastroSaidaDeVeiculos> saidaVeiculo = fachada.listarSaidaDeVeiculo();

		try{
			for (CadastroSaidaDeVeiculos cadastroSaidaDeVeiculos : saidaVeiculo) {
				Vector vector = new Vector();
				vector.add(cadastroSaidaDeVeiculos.getId());
				vector.add(cadastroSaidaDeVeiculos.getNomeCliente());
				vector.add(cadastroSaidaDeVeiculos.getNomeFuncionario());
				vector.add(cadastroSaidaDeVeiculos.getData());
				vector.add(cadastroSaidaDeVeiculos.getHora());
				vector.add(cadastroSaidaDeVeiculos.getPlaca());
				vector.add(cadastroSaidaDeVeiculos.getValor());
				vector.add(cadastroSaidaDeVeiculos.getCombustivel());
				defaultTableModelSaidaVeiculo.addRow(vector);
			
				
			}//fim do for
		
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
	
	private void limparTabelaSaidaVeiculo() {
		  defaultTableModelSaidaVeiculo.setRowCount(0);
	}
}