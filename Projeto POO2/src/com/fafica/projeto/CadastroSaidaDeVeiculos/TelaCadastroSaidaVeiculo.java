package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;
import com.fafica.projeto.Funcionario.Funcionario;

import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageTranscoder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroSaidaVeiculo {

	public JFrame frmTelaCadastroSaida;
	private JTextField textCombustivel;
	private JTextField textValorDiaria;
	private JTextField textDiasComCarro;
	private JTextField textValorTotal;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroSaidaVeiculo window = new TelaCadastroSaidaVeiculo();
					window.frmTelaCadastroSaida.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroSaidaVeiculo() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastroSaida = new JFrame();
		frmTelaCadastroSaida.setTitle("Tela Cadastro Saida de Veiculo");
		frmTelaCadastroSaida.setBounds(100, 100, 738, 432);
		frmTelaCadastroSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastroSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 702, 203);
		frmTelaCadastroSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		panel.add(lblCliente);
		
		JLabel lblVeiculo = new JLabel("Placa do veiculo:");
		lblVeiculo.setBounds(10, 62, 108, 14);
		panel.add(lblVeiculo);
		
		JLabel lblTanqueCombustivel = new JLabel("Tanque Combustivel:");
		lblTanqueCombustivel.setBounds(303, 11, 118, 14);
		panel.add(lblTanqueCombustivel);
		
		textCombustivel = new JTextField();
		textCombustivel.setBounds(431, 8, 138, 20);
		panel.add(textCombustivel);
		textCombustivel.setColumns(10);
		
		JLabel lblValorDiaria = new JLabel("Valor diaria:");
		lblValorDiaria.setBounds(10, 90, 88, 14);
		panel.add(lblValorDiaria);
		
		textValorDiaria = new JTextField();
		textValorDiaria.setBounds(98, 87, 86, 20);
		panel.add(textValorDiaria);
		textValorDiaria.setColumns(10);
		
		JLabel lblPevis = new JLabel("Dias com carro:");
		lblPevis.setBounds(10, 118, 88, 14);
		panel.add(lblPevis);
		
		textDiasComCarro = new JTextField();
		textDiasComCarro.setBounds(117, 115, 67, 20);
		panel.add(textDiasComCarro);
		textDiasComCarro.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(10, 143, 78, 14);
		panel.add(lblValorTotal);
		
		textValorTotal = new JTextField();
		textValorTotal.setBounds(98, 140, 86, 20);
		panel.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(128, 59, 131, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastro();
				} catch (ClienteNaoEncontradoException | CPFInvalidoException | CarroNaoEncontradoException
						| CampoObrigatorioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnCadastrar.setBounds(584, 169, 108, 23);
		panel.add(btnCadastrar);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(98, 8, 161, 20);
		panel.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(10, 37, 86, 14);
		panel.add(lblFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(98, 34, 161, 20);
		panel.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
	}//  fim do main
	
	public void cadastro() throws ClienteNaoEncontradoException, CPFInvalidoException, CarroNaoEncontradoException, CampoObrigatorioException{
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		
		int valorDiaria = Integer.parseInt(textValorDiaria.getText());
		int diasComCarro = Integer.parseInt(textDiasComCarro.getText());
		int valorTotal = valorDiaria * diasComCarro;
		
		String valorTotalString = Integer.toString(valorTotal);
		String nomeCliente = textNomeCliente.getText();
		String nomeFuncionario = textNomeFuncionario.getText();
		String placa = textPlaca.getText();
		String combustivel = textCombustivel.getText();
		
		  
		
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
			 CadastroSaidaDeVeiculos saidaVeiculo = new CadastroSaidaDeVeiculos(nomeCliente, nomeFuncionario, data, hora, placa, valorTotal, combustivel);

			 fachada.cadastarSaidaDeVeiculos(saidaVeiculo);
			 textValorTotal.setText(valorTotalString);
			 			 
	
			
			
			// JOptionPane.showMessageDialog(null, "Saida Cadastrada com sucesso!");
			 
		 }catch(Exception e){
			 
		 }
		
		
	
		
		
	}// fim do metodo
	
}// fim da classe
