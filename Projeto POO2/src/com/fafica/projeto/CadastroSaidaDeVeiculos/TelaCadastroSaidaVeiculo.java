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
import javax.imageio.ImageTranscoder;
import javax.swing.JButton;

public class TelaCadastroSaidaVeiculo {

	private JFrame frmTelaCadastroSaida;
	private JTextField textCombustivel;
	private JTextField textValorDiaria;
	private JTextField textDiasComCarro;
	private JTextField textValorTotal;
	private JTextField textPlaca;
	private JTextField textCpf;
	private JTextField textCpfFuncionario;

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
		lblVeiculo.setBounds(10, 62, 86, 14);
		panel.add(lblVeiculo);
		
		JLabel lblTanqueCombustivel = new JLabel("Tanque Combustivel:");
		lblTanqueCombustivel.setBounds(204, 90, 112, 14);
		panel.add(lblTanqueCombustivel);
		
		textCombustivel = new JTextField();
		textCombustivel.setBounds(315, 87, 138, 20);
		panel.add(textCombustivel);
		textCombustivel.setColumns(10);
		
		JLabel lblValorDiaria = new JLabel("Valor diaria:");
		lblValorDiaria.setBounds(10, 90, 67, 14);
		panel.add(lblValorDiaria);
		
		textValorDiaria = new JTextField();
		textValorDiaria.setBounds(76, 87, 86, 20);
		panel.add(textValorDiaria);
		textValorDiaria.setColumns(10);
		
		JLabel lblPevis = new JLabel("Dias com carro:");
		lblPevis.setBounds(10, 118, 86, 14);
		panel.add(lblPevis);
		
		textDiasComCarro = new JTextField();
		textDiasComCarro.setBounds(95, 115, 67, 20);
		panel.add(textDiasComCarro);
		textDiasComCarro.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(10, 143, 56, 14);
		panel.add(lblValorTotal);
		
		textValorTotal = new JTextField();
		textValorTotal.setBounds(76, 140, 86, 20);
		panel.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(106, 59, 131, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(603, 169, 89, 23);
		panel.add(btnCadastrar);
		
		textCpf = new JTextField();
		textCpf.setBounds(76, 8, 161, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(10, 37, 67, 14);
		panel.add(lblFuncionario);
		
		textCpfFuncionario = new JTextField();
		textCpfFuncionario.setBounds(76, 34, 161, 20);
		panel.add(textCpfFuncionario);
		textCpfFuncionario.setColumns(10);
	}//  fim do main
	
	public void cadastro() throws ClienteNaoEncontradoException, CPFInvalidoException, CarroNaoEncontradoException, CampoObrigatorioException{
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		String cpf = textCpf.getText();
		String cpfFuncionario = textCpfFuncionario.getText();
		String placa = textPlaca.getText();
		
		int valorDiaria = Integer.parseInt(textValorDiaria.getText());
		int diasComCarro = Integer.parseInt(textDiasComCarro.getText());
		int valorTotal = valorDiaria * diasComCarro;
		String valorTotalString = Integer.toString(valorTotal);
		
		
		//pegando data e hora
		 String data = "dd/MM/yyyy";  
		 String hora = "h:mm - a";  
		 String data1, hora1;  
		   
		 java.util.Date agora = new java.util.Date();;  
		 SimpleDateFormat formata = new SimpleDateFormat(data);  
		 data1 = formata.format(agora);  
		 formata = new SimpleDateFormat(hora);  
		 hora1 = formata.format(agora);
		 
		 try{
			 Cliente cliente = fachada.procurarCliente(cpf);
			 Carro carro = fachada.procurarCarro(placa);
			 textValorTotal.setText(valorTotalString);
			 
			 Endereco endereco = new Endereco("Terra nova", "Boa vista 2", "Prox a praça","Caruaru" );
			 Funcionario funcionario = new Funcionario("João paulo", "099.487.664-58",endereco);
			 
			 
			 int id = 0;
			 ++id;
			 
			 CadastroSaidaDeVeiculos saidaVeiculo = new CadastroSaidaDeVeiculos(id,cliente, funcionario, data1, hora1, carro, valorTotal);
			 fachada.cadastarSaidaDeVeiculos(saidaVeiculo);
			 
		 }catch(Exception e){
			 
		 }
		
		
	
		
		
	}// fim do metodo
	
}// fim da classe
