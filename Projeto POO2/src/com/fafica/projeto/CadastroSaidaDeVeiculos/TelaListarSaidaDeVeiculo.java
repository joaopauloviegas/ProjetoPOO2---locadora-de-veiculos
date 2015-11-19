package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaListarSaidaDeVeiculo {

	private JFrame frame;
	private JTable tableSaidaVeiculo;
	private DefaultTableModel defaultTableModelSaidaVeiculo;
	private Fachada fachada;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarSaidaDeVeiculo window = new TelaListarSaidaDeVeiculo();
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
	public TelaListarSaidaDeVeiculo() {
		fachada = Fachada.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 767, 350);
		frame.getContentPane().add(scrollPane);
		
		tableSaidaVeiculo = new JTable();
		String colunaTabelaSaidaVeiculo[] = new String[] {"ID", "Cliente", "Funcionario", "Data", "Hora", "Valor", "Placa","Combustivel"};
		defaultTableModelSaidaVeiculo = new DefaultTableModel(new Object[] []{ }, colunaTabelaSaidaVeiculo) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableSaidaVeiculo.setModel(defaultTableModelSaidaVeiculo);
		scrollPane.setViewportView(tableSaidaVeiculo);
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		btnListar.setBounds(674, 389, 89, 23);
		frame.getContentPane().add(btnListar);
	}
	
	public void listarSaidaVeiculo() throws SQLException, CarroNaoEncontradoException{

		ArrayList<CadastroSaidaDeVeiculos> saidaVeiculo = fachada.listarSaidaDeVeiculo();

		try{
			for (CadastroSaidaDeVeiculos cadastroSaidaDeVeiculos : saidaVeiculo) {
				Vector vector = new Vector();
				vector.add(cadastroSaidaDeVeiculos.getId());
				vector.add(cadastroSaidaDeVeiculos.getNomeCliente());
				vector.add(cadastroSaidaDeVeiculos.getNomeFuncionario());
				vector.add(cadastroSaidaDeVeiculos.getData());
				vector.add(cadastroSaidaDeVeiculos.getHora());
				vector.add(cadastroSaidaDeVeiculos.getValor());
				vector.add(cadastroSaidaDeVeiculos.getPlaca());
				vector.add(cadastroSaidaDeVeiculos.getCombustivel());
				defaultTableModelSaidaVeiculo.addRow(vector);
			
				
			}//fim do for
		
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar

}// fim da classe
