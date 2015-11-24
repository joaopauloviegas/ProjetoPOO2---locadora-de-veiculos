package com.fafica.projeto.CadastroDeReserva;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto.Fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroDeReserva {

	private JFrame frmCadastroDeReserva;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textPlaca;
	private JTextField textQuantidade;
	private JTextField textDiasComCarro;
	private JTextField textValor;
	private JTextField textValorDiaria;
	private Fachada fachada;
	private CadastroDeReserva cadastrodeReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDeReserva window = new TelaCadastroDeReserva();
					window.frmCadastroDeReserva.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroDeReserva() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeReserva = new JFrame();
		frmCadastroDeReserva.setTitle("Cadastro de Reserva");
		frmCadastroDeReserva.setBounds(100, 100, 716, 414);
		frmCadastroDeReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeReserva.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 31, 680, 333);
		frmCadastroDeReserva.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCpfCliente = new JLabel("Nome Cliente:");
		lblCpfCliente.setBounds(10, 34, 72, 14);
		panel.add(lblCpfCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(114, 31, 517, 20);
		panel.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblCpfFuncionario = new JLabel("Nome Funcionario:");
		lblCpfFuncionario.setBounds(10, 56, 94, 14);
		panel.add(lblCpfFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(114, 53, 517, 20);
		panel.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 78, 46, 14);
		panel.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(114, 75, 86, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 99, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(114, 96, 138, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 122, 72, 14);
		panel.add(lblQuantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(114, 119, 86, 20);
		panel.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblDiasComCarro = new JLabel("Dias com Carro:");
		lblDiasComCarro.setBounds(10, 144, 81, 14);
		panel.add(lblDiasComCarro);
		
		textDiasComCarro = new JTextField();
		textDiasComCarro.setBounds(114, 141, 86, 20);
		panel.add(textDiasComCarro);
		textDiasComCarro.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 213, 46, 14);
		panel.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(114, 210, 86, 20);
		panel.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblValorDiaria = new JLabel("Valor Diaria:");
		lblValorDiaria.setBounds(10, 184, 72, 14);
		panel.add(lblValorDiaria);
		
		textValorDiaria = new JTextField();
		textValorDiaria.setBounds(114, 179, 86, 20);
		panel.add(textValorDiaria);
		textValorDiaria.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnCadastrar.setBounds(581, 299, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limpar();
			}
		});
		btnLimpar.setBounds(482, 299, 89, 23);
		panel.add(btnLimpar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorTotal();
			}
		});
		btnAtualizar.setBounds(247, 209, 89, 23);
		panel.add(btnAtualizar);
	}
	
	private int valorTotal(){
		int valorDiaria = Integer.parseInt(textValorDiaria.getText());
		int diasComCarro = Integer.parseInt(textDiasComCarro.getText());
		int valorTotal = valorDiaria * diasComCarro;
		String valorTotalString = Integer.toString(valorTotal);
		textValor.setText(valorTotalString);
		return valorTotal;
		
	}
	
	public void cadastrar(){
		
		
		int valorDiaria = Integer.parseInt(textValorDiaria.getText());
		int diasComCarro = Integer.parseInt(textDiasComCarro.getText());
		int quantidade = Integer.parseInt(textQuantidade.getText());
		int Valor = valorTotal();
		
		String valorTotalString = Integer.toString(Valor);
		String nomeCliente = textNomeCliente.getText();
		String nomeFuncionario = textNomeFuncionario.getText();
		String placa = textPlaca.getText();
		
		//pegando data e hora
		 String data1 = "dd/MM/yyyy";  
		 String hora1 = "h:mm - a";  
		 String data, hora;  
		   
		 java.util.Date agora = new java.util.Date();;  
		 SimpleDateFormat formata = new SimpleDateFormat(data1);  
		 data = formata.format(agora);  
		 formata = new SimpleDateFormat(hora1);  
		 hora = formata.format(agora);
		 
		try{
		CadastroDeReserva cadastrodeReserva = new CadastroDeReserva(nomeCliente,nomeFuncionario,data,placa,quantidade,diasComCarro,Valor);
		fachada.cadastrarCadastroDeReserva(cadastrodeReserva);
		 textValor.setText(valorTotalString);
		 limpar();
		} catch (Exception e){
			
		}
	}
	
	public void limpar(){
		textNomeCliente.setText("");
		textNomeFuncionario.setText("");
		textData.setText("");
		textPlaca.setText("");
		textQuantidade.setText("");
		textDiasComCarro.setText("");
		textValorDiaria.setText("");
		textValor.setText("");
	}
	
}
