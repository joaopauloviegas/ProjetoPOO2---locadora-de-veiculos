package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Carro.CarroNaoEncontradoException;
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

public class TelaProcurarSaidaDeVeiculo {

	public JFrame frmTelaAtualizarSaida;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textCombustivel;
	private JTextField textValor;
	private DefaultTableModel defaultTableModelSaidaVeiculo;
	private Fachada fachada;
	
	private CadastroSaidaDeVeiculos saidaVeiculo;
	private JTable tableSaidaVeiculo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcurarSaidaDeVeiculo window = new TelaProcurarSaidaDeVeiculo();
					window.frmTelaAtualizarSaida.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaProcurarSaidaDeVeiculo() {
		
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAtualizarSaida = new JFrame();
		frmTelaAtualizarSaida.setTitle("Tela Atualizar Saida de Veiculos");
		frmTelaAtualizarSaida.setBounds(100, 100, 690, 348);
		frmTelaAtualizarSaida.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaAtualizarSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 43, 415, 59);
		frmTelaAtualizarSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca.setBounds(10, 22, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(122, 20, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(240, 18, 104, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 113, 415, 181);
		frmTelaAtualizarSaida.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(10, 11, 103, 14);
		panel_1.add(lblCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(123, 9, 275, 20);
		panel_1.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFuncionario.setBounds(10, 36, 103, 14);
		panel_1.add(lblFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(123, 34, 275, 20);
		panel_1.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(10, 61, 86, 14);
		panel_1.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(123, 59, 86, 20);
		panel_1.add(textData);
		textData.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(10, 86, 86, 14);
		panel_1.add(lblHora);
		
		textHora = new JTextField();
		textHora.setBounds(123, 84, 86, 20);
		panel_1.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblCombustivel = new JLabel("Combustivel:");
		lblCombustivel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCombustivel.setBounds(10, 111, 103, 18);
		panel_1.add(lblCombustivel);
		
		textCombustivel = new JTextField();
		textCombustivel.setBounds(123, 111, 86, 20);
		panel_1.add(textCombustivel);
		textCombustivel.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValor.setBounds(10, 137, 68, 14);
		panel_1.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(123, 135, 86, 20);
		panel_1.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a PLACA que deseja procurar");
		lblDigiteAPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDigiteAPlaca.setBounds(198, 11, 263, 21);
		frmTelaAtualizarSaida.getContentPane().add(lblDigiteAPlaca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(435, 43, 229, 201);
		frmTelaAtualizarSaida.getContentPane().add(scrollPane);
		
		tableSaidaVeiculo = new JTable();
		String colunaTabelaSaidaVeiculo[] = new String[] {"Cliente", "Placa"};
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
		btnListar.setBounds(575, 271, 89, 23);
		frmTelaAtualizarSaida.getContentPane().add(btnListar);
	}
	
	public void procurar(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{
		String placa = textPlaca.getText();
		saidaVeiculo = fachada.procurarSaidaDeVeiculos(placa);
		
		textNomeCliente.setText(saidaVeiculo.getNomeCliente());
		textNomeFuncionario.setText(saidaVeiculo.getNomeFuncionario());
		textData.setText(saidaVeiculo.getData());
		textHora.setText(saidaVeiculo.getHora());
		textCombustivel.setText(saidaVeiculo.getCombustivel());
		String valorTotal = String.valueOf(saidaVeiculo.getValor());
		textValor.setText(valorTotal);
		}catch(Exception e){
			
		}
	}
	
	public void listarSaidaVeiculo() throws SQLException, CarroNaoEncontradoException{
		limparTabelaSaidaVeiculo();
		ArrayList<CadastroSaidaDeVeiculos> saidaVeiculo = fachada.listarSaidaDeVeiculo();

		try{
			for (CadastroSaidaDeVeiculos cadastroSaidaDeVeiculos : saidaVeiculo) {
				Vector vector = new Vector();
				
				vector.add(cadastroSaidaDeVeiculos.getNomeCliente());
				vector.add(cadastroSaidaDeVeiculos.getPlaca());	
				defaultTableModelSaidaVeiculo.addRow(vector);
			
				
			}//fim do for
		
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
	
	private void limparTabelaSaidaVeiculo() {
		  defaultTableModelSaidaVeiculo.setRowCount(0);
	}
}// fim da classe
