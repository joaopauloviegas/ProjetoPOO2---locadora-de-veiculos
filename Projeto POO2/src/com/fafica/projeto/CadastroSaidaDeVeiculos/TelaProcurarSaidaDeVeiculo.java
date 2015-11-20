package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProcurarSaidaDeVeiculo {

	public JFrame frmTelaAtualizarSaida;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textCombustivel;
	private JTextField textValor;
	
	private CadastroSaidaDeVeiculos saidaVeiculo;
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAtualizarSaida = new JFrame();
		frmTelaAtualizarSaida.setTitle("Tela Atualizar Saida de Veiculos");
		frmTelaAtualizarSaida.setBounds(100, 100, 450, 300);
		frmTelaAtualizarSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaAtualizarSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 66);
		frmTelaAtualizarSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 22, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 19, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(187, 18, 89, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 414, 162);
		frmTelaAtualizarSaida.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		panel_1.add(lblCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(77, 8, 86, 20);
		panel_1.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(10, 36, 76, 14);
		panel_1.add(lblFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(96, 33, 86, 20);
		panel_1.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 61, 46, 14);
		panel_1.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(77, 58, 86, 20);
		panel_1.add(textData);
		textData.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 86, 46, 14);
		panel_1.add(lblHora);
		
		textHora = new JTextField();
		textHora.setBounds(77, 83, 86, 20);
		panel_1.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblCombustivel = new JLabel("Combustivel:");
		lblCombustivel.setBounds(10, 111, 76, 14);
		panel_1.add(lblCombustivel);
		
		textCombustivel = new JTextField();
		textCombustivel.setBounds(96, 108, 86, 20);
		panel_1.add(textCombustivel);
		textCombustivel.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 137, 46, 14);
		panel_1.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(96, 134, 86, 20);
		panel_1.add(textValor);
		textValor.setColumns(10);
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
}// fim da classe
