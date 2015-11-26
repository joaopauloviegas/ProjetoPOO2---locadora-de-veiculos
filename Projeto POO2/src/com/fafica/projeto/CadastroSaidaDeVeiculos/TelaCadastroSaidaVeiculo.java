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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;

public class TelaCadastroSaidaVeiculo {

	public JFrame frmTelaCadastroSaida;
	private JTextField textValorDiaria;
	private JTextField textDiasComCarro;
	private JTextField textValorTotal;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private ButtonGroup grupo = new ButtonGroup();
	private JRadioButton rdbtnSeco;
	private JRadioButton rdbtnMeio;
	private JRadioButton rdbtnCheio;
	private JButton btnAtualizar;
	
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
		frmTelaCadastroSaida.setBounds(100, 100, 738, 361);
		frmTelaCadastroSaida.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaCadastroSaida.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 702, 300);
		frmTelaCadastroSaida.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(10, 11, 78, 14);
		panel.add(lblCliente);
		
		JLabel lblVeiculo = new JLabel("Placa:");
		lblVeiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeiculo.setBounds(10, 62, 108, 14);
		panel.add(lblVeiculo);
		
		JLabel lblTanqueCombustivel = new JLabel("Tanque Combustivel:");
		lblTanqueCombustivel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTanqueCombustivel.setBounds(10, 87, 149, 14);
		panel.add(lblTanqueCombustivel);
		
		JLabel lblValorDiaria = new JLabel("Valor diaria:");
		lblValorDiaria.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorDiaria.setBounds(10, 116, 108, 14);
		panel.add(lblValorDiaria);
		
		textValorDiaria = new JTextField();
		textValorDiaria.setBounds(144, 114, 86, 20);
		panel.add(textValorDiaria);
		textValorDiaria.setColumns(10);
		
		JLabel lblPevis = new JLabel("Dias com carro:");
		lblPevis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPevis.setBounds(262, 116, 108, 14);
		panel.add(lblPevis);
		
		textDiasComCarro = new JTextField();
		textDiasComCarro.setBounds(380, 114, 67, 20);
		panel.add(textDiasComCarro);
		textDiasComCarro.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorTotal.setBounds(10, 172, 108, 14);
		panel.add(lblValorTotal);
		
		textValorTotal = new JTextField();
		textValorTotal.setBounds(144, 170, 86, 20);
		panel.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(144, 60, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		btnCadastrar.setBounds(584, 266, 108, 23);
		panel.add(btnCadastrar);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(144, 8, 502, 20);
		panel.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFuncionario.setBounds(10, 37, 88, 14);
		panel.add(lblFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(144, 35, 502, 20);
		panel.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		rdbtnSeco = new JRadioButton("Seco");
		rdbtnSeco.setBounds(154, 84, 67, 23);
		panel.add(rdbtnSeco);
		
		rdbtnMeio = new JRadioButton("Meio");
		rdbtnMeio.setBounds(223, 84, 67, 23);
		panel.add(rdbtnMeio);
		
		rdbtnCheio = new JRadioButton("Cheio");
		rdbtnCheio.setBounds(292, 84, 67, 23);
		panel.add(rdbtnCheio);
		
		grupo.add(rdbtnSeco);
		grupo.add(rdbtnMeio);
		grupo.add(rdbtnCheio);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorTotal();
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizar.setBounds(262, 169, 127, 23);
		panel.add(btnAtualizar);
		
	}//  fim do main
	
	private String selecionarCombustivel(){
		String combustivel = "";
		if(rdbtnSeco.isSelected()) combustivel = "Seco";
		if(rdbtnMeio.isSelected()) combustivel = "Meio";
		if(rdbtnCheio.isSelected()) combustivel = "Cheio";
		return combustivel;
		
	}
	private int valorTotal(){
		int valorDiaria = Integer.parseInt(textValorDiaria.getText());
		int diasComCarro = Integer.parseInt(textDiasComCarro.getText());
		int valorTotal = valorDiaria * diasComCarro;
		String valorTotalString = Integer.toString(valorTotal);
		textValorTotal.setText(valorTotalString);
		return valorTotal;
		
	}
	public void cadastro() throws ClienteNaoEncontradoException, CPFInvalidoException, CarroNaoEncontradoException, CampoObrigatorioException{
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		
		int valorDiaria = Integer.parseInt(textValorDiaria.getText());
		int diasComCarro = Integer.parseInt(textDiasComCarro.getText());
		int valorTotal = valorTotal();
		
		String valorTotalString = Integer.toString(valorTotal);
		String nomeCliente = textNomeCliente.getText();
		String nomeFuncionario = textNomeFuncionario.getText();
		String placa = textPlaca.getText();
		String combustivel = selecionarCombustivel();
		
		  
		
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
