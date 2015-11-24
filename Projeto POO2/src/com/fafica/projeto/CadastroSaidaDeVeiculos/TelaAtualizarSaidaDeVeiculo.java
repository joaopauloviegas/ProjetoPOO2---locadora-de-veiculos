package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class TelaAtualizarSaidaDeVeiculo {

	public JFrame frmTelaAtualizarSaida;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textValorTotal;
	private Fachada fachada;
	private CadastroSaidaDeVeiculos saidaVeiculo;
	private JTable tableCarro;
	private DefaultTableModel defaultTableModelCarro;
	private ButtonGroup grupo = new ButtonGroup();
	private JRadioButton rdbtnSeco;
	private JRadioButton rdbtnMeio;
	private JRadioButton rdbtnCheio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarSaidaDeVeiculo window = new TelaAtualizarSaidaDeVeiculo();
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
	public TelaAtualizarSaidaDeVeiculo() {
		fachada = Fachada.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAtualizarSaida = new JFrame();
		frmTelaAtualizarSaida.setTitle("Tela Atualizar Saida de Veiculo");
		frmTelaAtualizarSaida.setBounds(100, 100, 725, 485);
		frmTelaAtualizarSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaAtualizarSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 689, 45);
		frmTelaAtualizarSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 56, 14);
		panel.add(lblNewLabel);
		
		textPlaca = new JTextField();
		textPlaca.setToolTipText("Digite placa");
		textPlaca.setBounds(76, 9, 97, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurarCarro();
			}
		});
		btnProcurar.setBounds(204, 7, 111, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 98, 689, 279);
		frmTelaAtualizarSaida.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(10, 11, 71, 14);
		panel_1.add(lblCliente);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFuncionario.setBounds(10, 36, 86, 14);
		panel_1.add(lblFuncionario);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(10, 61, 46, 14);
		panel_1.add(lblData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(240, 61, 46, 14);
		panel_1.add(lblHora);
		
		JLabel lblNewLabel_1 = new JLabel("Combustivel:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(392, 61, 103, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 86, 109, 14);
		panel_1.add(lblNewLabel_2);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setToolTipText("Digite o nome do cliente");
		textNomeCliente.setBounds(116, 9, 563, 20);
		panel_1.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setToolTipText("Digite o nome do funcionario");
		textNomeFuncionario.setBounds(116, 33, 563, 20);
		panel_1.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		textData = new JTextField();
		textData.setToolTipText("Digite a data");
		textData.setBounds(116, 59, 94, 20);
		panel_1.add(textData);
		textData.setColumns(10);
		
		textHora = new JTextField();
		textHora.setToolTipText("Digite a hora");
		textHora.setBounds(296, 59, 86, 20);
		panel_1.add(textHora);
		textHora.setColumns(10);
		
		textValorTotal = new JTextField();
		textValorTotal.setToolTipText("Digite o valor total");
		textValorTotal.setBounds(116, 84, 94, 20);
		panel_1.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 265, 157);
		panel_1.add(scrollPane);
		
		tableCarro = new JTable();
		String colunaTabelaCarro[] = new String[] {"Nome", "Placa"};
		defaultTableModelCarro = new DefaultTableModel(new Object[] []{ }, colunaTabelaCarro) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCarro.setModel(defaultTableModelCarro);
		scrollPane.setViewportView(tableCarro);
		
		JButton btnListarPlacas = new JButton("Listar placas");
		btnListarPlacas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (SQLException | CarroNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListarPlacas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListarPlacas.setBounds(282, 245, 119, 23);
		panel_1.add(btnListarPlacas);
		
		rdbtnSeco = new JRadioButton("Seco");
		rdbtnSeco.setBounds(501, 58, 61, 23);
		panel_1.add(rdbtnSeco);
		
		rdbtnMeio = new JRadioButton("Meio");
		rdbtnMeio.setBounds(564, 58, 61, 23);
		panel_1.add(rdbtnMeio);
		
		rdbtnCheio = new JRadioButton("Cheio");
		rdbtnCheio.setBounds(627, 58, 61, 23);
		panel_1.add(rdbtnCheio);
		
		grupo.add(rdbtnSeco);
		grupo.add(rdbtnMeio);
		grupo.add(rdbtnCheio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 388, 677, 47);
		frmTelaAtualizarSaida.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(539, 11, 128, 23);
		panel_2.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(440, 11, 89, 23);
		panel_2.add(btnLimpar);
	}// fim do main

	
	private String selecionarCombustivel(){
		String combustivel = "";
		if(rdbtnSeco.isSelected()) combustivel = "Seco";
		if(rdbtnMeio.isSelected()) combustivel = "Meio";
		if(rdbtnCheio.isSelected()) combustivel = "Cheio";
		return combustivel;
		
	}
	
	public void procurarCarro(){
		try{
		String placa = textPlaca.getText();
		saidaVeiculo = fachada.procurarSaidaDeVeiculos(placa);
		
		textNomeCliente.setText(saidaVeiculo.getNomeCliente());
		textNomeFuncionario.setText(saidaVeiculo.getNomeFuncionario());
		textData.setText(saidaVeiculo.getData());
		textHora.setText(saidaVeiculo.getHora());
		String valorTotal = String.valueOf(saidaVeiculo.getValor());
		textValorTotal.setText(valorTotal);
		}catch(Exception e){
			
		}
		
		
	}
	public void atualizar(){
		
		String nomeCliente = textNomeCliente.getText();
		String nomeFuncionario = textNomeFuncionario.getText();
		String data = textData.getText();
		String hora = textHora.getText();
		String combustivel = selecionarCombustivel();
		String valorTotal = textValorTotal.getText();
		double valor =  Double.parseDouble(valorTotal);
		String placa = textPlaca.getText();
		
		try{
			
			CadastroSaidaDeVeiculos saidaDeVeiculo = new CadastroSaidaDeVeiculos(nomeCliente, nomeFuncionario, data, hora, placa, valor, combustivel);
			fachada.atualizarSaidaDeVeiculos(saidaDeVeiculo);
			JOptionPane.showMessageDialog(null, "Saida de veiculo atualizada com sucesso!");
			limparCampos();
			limparTabelaCarro();
			listar();
			
		}catch(Exception e ){
			
		}
		
	}// fim do metodo atualizar
	
	public void limparCampos(){
		
		textData.setText("");
		textHora.setText("");
		textNomeCliente.setText("");
		textNomeFuncionario.setText("");
		textPlaca.setText("");
		textValorTotal.setText("");
		
	}
	
	public void listar() throws SQLException, CarroNaoEncontradoException{
		limparTabelaCarro();
		ArrayList<CadastroSaidaDeVeiculos> carros = fachada.listarSaidaDeVeiculo();

		try{
			for (CadastroSaidaDeVeiculos carro : carros) {
				Vector vector = new Vector();
				
				vector.add(carro.getNomeCliente());
				vector.add(carro.getPlaca());
				
				defaultTableModelCarro.addRow(vector);
			}//fim do for
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
	
	private void limparTabelaCarro() {
		defaultTableModelCarro.setRowCount(0);
	}
}// fim da classe
