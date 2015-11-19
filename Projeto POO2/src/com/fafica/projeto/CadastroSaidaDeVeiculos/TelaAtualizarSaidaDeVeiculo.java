package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarSaidaDeVeiculo {

	private JFrame frmTelaAtualizarSaida;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textCombustivel;
	private JTextField textValorTotal;
	private Fachada fachada;
	private CadastroSaidaDeVeiculos saidaVeiculo;

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
		frmTelaAtualizarSaida.setBounds(100, 100, 713, 422);
		frmTelaAtualizarSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaAtualizarSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 677, 45);
		frmTelaAtualizarSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 8, 97, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(212, 7, 103, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 98, 677, 216);
		frmTelaAtualizarSaida.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		panel_1.add(lblCliente);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(10, 36, 71, 14);
		panel_1.add(lblFuncionario);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 61, 46, 14);
		panel_1.add(lblData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 86, 46, 14);
		panel_1.add(lblHora);
		
		JLabel lblNewLabel_1 = new JLabel("Combustivel:");
		lblNewLabel_1.setBounds(10, 111, 71, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Total");
		lblNewLabel_2.setBounds(10, 136, 71, 14);
		panel_1.add(lblNewLabel_2);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(91, 8, 86, 20);
		panel_1.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(91, 33, 86, 20);
		panel_1.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		textData = new JTextField();
		textData.setBounds(91, 58, 86, 20);
		panel_1.add(textData);
		textData.setColumns(10);
		
		textHora = new JTextField();
		textHora.setBounds(91, 83, 86, 20);
		panel_1.add(textHora);
		textHora.setColumns(10);
		
		textCombustivel = new JTextField();
		textCombustivel.setBounds(91, 108, 86, 20);
		panel_1.add(textCombustivel);
		textCombustivel.setColumns(10);
		
		textValorTotal = new JTextField();
		textValorTotal.setBounds(91, 133, 86, 20);
		panel_1.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 325, 677, 47);
		frmTelaAtualizarSaida.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(577, 11, 90, 23);
		panel_2.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(478, 11, 89, 23);
		panel_2.add(btnLimpar);
	}// fim do main

	
	
	public void procurar(){
		try{
		String placa = textPlaca.getText();
		saidaVeiculo = fachada.procurarSaidaDeVeiculos(placa);
		
		textNomeCliente.setText(saidaVeiculo.getNomeCliente());
		textNomeFuncionario.setText(saidaVeiculo.getNomeFuncionario());
		textData.setText(saidaVeiculo.getData());
		textHora.setText(saidaVeiculo.getHora());
		textCombustivel.setText(saidaVeiculo.getCombustivel());
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
		String combustivel = textCombustivel.getText();
		String valorTotal = textValorTotal.getText();
		double valor =  Double.parseDouble(valorTotal);
		String placa = textPlaca.getText();
		
		try{
			
			CadastroSaidaDeVeiculos saidaDeVeiculo = new CadastroSaidaDeVeiculos(nomeCliente, nomeFuncionario, data, hora, placa, valor, combustivel);
			fachada.atualizarSaidaDeVeiculos(saidaDeVeiculo);
			
			
		}catch(Exception e ){
			
		}
		
	}// fim do metodo atualizar
	
	public void limparCampos(){
		textCombustivel.setText("");
		textData.setText("");
		textHora.setText("");
		textNomeCliente.setText("");
		textNomeFuncionario.setText("");
		textPlaca.setText("");
		textValorTotal.setText("");
		
	}
}// fim da classe
