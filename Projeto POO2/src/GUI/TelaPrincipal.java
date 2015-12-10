package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.fafica.projeto.CadastroDeReserva.TelaAtualizarCadastroDeReserva;
import com.fafica.projeto.CadastroDeReserva.TelaBuscarCadastroDeReserva;
import com.fafica.projeto.CadastroDeReserva.TelaCadastroDeReserva;
import com.fafica.projeto.CadastroDeReserva.TelaListarCadastroDeReserva;
import com.fafica.projeto.CadastroDeReserva.TelaRemoverCadastroDeReserva;
import com.fafica.projeto.CadastroSaidaDeVeiculos.TelaAtualizarSaidaDeVeiculo;
import com.fafica.projeto.CadastroSaidaDeVeiculos.TelaCadastroSaidaVeiculo;
import com.fafica.projeto.CadastroSaidaDeVeiculos.TelaListarSaidaDeVeiculo;
import com.fafica.projeto.CadastroSaidaDeVeiculos.TelaProcurarSaidaDeVeiculo;
import com.fafica.projeto.CadastroSaidaDeVeiculos.TelaRemoverSaidaDeVeiculo;
import com.fafica.projeto.Carro.TelaAtualizarCarro;
import com.fafica.projeto.Carro.TelaCadastroCarro;
import com.fafica.projeto.Carro.TelaListarCarro;
import com.fafica.projeto.Carro.TelaProcurarCarro;
import com.fafica.projeto.Carro.TelaRemoverCarro;
import com.fafica.projeto.Cliente.TelaAtualizarCliente;
import com.fafica.projeto.Cliente.TelaCadastroCliente;
import com.fafica.projeto.Cliente.TelaListarCliente;
import com.fafica.projeto.Cliente.TelaProcurarCliente;
import com.fafica.projeto.Cliente.TelaRemoverCliente;
import com.fafica.projeto.Funcionario.TelaAtualizarFuncionario;
import com.fafica.projeto.Funcionario.TelaBuscarFuncionario;
import com.fafica.projeto.Funcionario.TelaCadastroFuncionario;
import com.fafica.projeto.Funcionario.TelaListarFuncionario;
import com.fafica.projeto.Funcionario.TelaRemoverFuncionario;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class TelaPrincipal {

	private JFrame frmTelaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setBounds(100, 100, 792, 679);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaPrincipal.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 774, 21);
		frmTelaPrincipal.getContentPane().add(menuBar);
		
		JMenu mnCadastrar = new JMenu("CADASTRAR");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCarro = new JMenuItem("Carro");
		mntmCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroCarro telaCadastro = new TelaCadastroCarro();
				telaCadastro.frmTelaCadastroCarro.setVisible(true);
				
				
				
				
			}
		});
		mnCadastrar.add(mntmCarro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente window = new TelaCadastroCliente();
				window.frmTelaCadastroCliente.setVisible(true);
				
			}
		});
		mnCadastrar.add(mntmCliente);
		
		JMenuItem mntmSaidaDeVeiculo = new JMenuItem("Saida de veiculo");
		mntmSaidaDeVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroSaidaVeiculo telaSaidaVeiculo = new TelaCadastroSaidaVeiculo();
				telaSaidaVeiculo.frmTelaCadastroSaida.setVisible(true);
			}
		});
		mnCadastrar.add(mntmSaidaDeVeiculo);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario tlf = new TelaCadastroFuncionario();
				tlf.frmCadastroFuncionario.setVisible(true);
			}
		});
		mnCadastrar.add(mntmFuncionario);
		
		JMenuItem mntmCadastrodereserva = new JMenuItem("Cadastro de Reserva");
		mntmCadastrodereserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroDeReserva tcdr = new TelaCadastroDeReserva();
				tcdr.frmCadastroDeReserva.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrodereserva);
		
		JMenu mnAtualizar = new JMenu("ATUALIZAR");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmCarro_1 = new JMenuItem("Carro");
		mntmCarro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarCarro telaAtualizar =  new TelaAtualizarCarro();
				telaAtualizar.frmTelaAtualizarCarro.setVisible(true);
			}
		});
		mnAtualizar.add(mntmCarro_1);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarCliente telaAtualizarCliente = new TelaAtualizarCliente();
				telaAtualizarCliente.frmTelaAtualizarCliente.setVisible(true);
			}
		});
		mnAtualizar.add(mntmCliente_1);
		
		JMenuItem mntmSaidaDeVeiculo_1 = new JMenuItem("Saida de Veiculo");
		mntmSaidaDeVeiculo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarSaidaDeVeiculo telaAtualizarSaidaVeiculo = new TelaAtualizarSaidaDeVeiculo();
				telaAtualizarSaidaVeiculo.frmTelaAtualizarSaida.setVisible(true);
			}
		});
		mnAtualizar.add(mntmSaidaDeVeiculo_1);
		
		JMenuItem mntmFuncionario_1 = new JMenuItem("Funcionario");
		mntmFuncionario_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarFuncionario taf = new TelaAtualizarFuncionario();
				taf.frame.setVisible(true);
			}
		});
		mnAtualizar.add(mntmFuncionario_1);
		
		JMenuItem mntmCadastrodereserva_1 = new JMenuItem("Cadastro de Reserva");
		mntmCadastrodereserva_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarCadastroDeReserva tacdr = new TelaAtualizarCadastroDeReserva();
				tacdr.frame.setVisible(true);
			}
		});
		mnAtualizar.add(mntmCadastrodereserva_1);
		
		JMenu mnRemover = new JMenu("REMOVER");
		menuBar.add(mnRemover);
		
		JMenuItem mntmCarro_2 = new JMenuItem("Carro");
		mntmCarro_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverCarro telaRemover = new TelaRemoverCarro();
				telaRemover.frmTelaRemoverCarro.setVisible(true);
			}
		});
		mnRemover.add(mntmCarro_2);
		
		JMenuItem mntmCliente_2 = new JMenuItem("Cliente");
		mntmCliente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverCliente telaRemover = new TelaRemoverCliente();
				telaRemover.frmTelaRemoverCliente.setVisible(true);
			}
		});
		mnRemover.add(mntmCliente_2);
		
		JMenuItem mntmSaidaDeVeiculo_2 = new JMenuItem("Saida de Veiculo");
		mntmSaidaDeVeiculo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverSaidaDeVeiculo telaRemoverSaidaVeiculo = new TelaRemoverSaidaDeVeiculo();
				telaRemoverSaidaVeiculo.frmTelaRemoverSaida.setVisible(true);
				
			}
		});
		mnRemover.add(mntmSaidaDeVeiculo_2);
		
		JMenuItem mntmFuncionario_2 = new JMenuItem("Funcionario");
		mntmFuncionario_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverFuncionario trf = new TelaRemoverFuncionario();
				trf.frmRemoverFuncionario.setVisible(true);
				
			}
		});
		mnRemover.add(mntmFuncionario_2);
		
		JMenuItem mntmCadastroDeReserva = new JMenuItem("Cadastro de Reserva");
		mntmCadastroDeReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaRemoverCadastroDeReserva trcdr = new TelaRemoverCadastroDeReserva();
			trcdr.frame.setVisible(true);
			}
		});
		mnRemover.add(mntmCadastroDeReserva);
		
		JMenu mnProcurar = new JMenu("PROCURAR");
		menuBar.add(mnProcurar);
		
		JMenuItem mntmCarro_3 = new JMenuItem("Carro");
		mntmCarro_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarCarro telaProcurarCarro = new TelaProcurarCarro();
				telaProcurarCarro.frmTelaProcurarCarro.setVisible(true);
			}
		});
		mnProcurar.add(mntmCarro_3);
		
		JMenuItem mntmCliente_3 = new JMenuItem("Cliente");
		mntmCliente_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarCliente telaProcurarCliente = new TelaProcurarCliente();
				telaProcurarCliente.frmTelaProcurarCliente.setVisible(true);
			}
		});
		mnProcurar.add(mntmCliente_3);
		
		JMenuItem mntmSaidaDeVeiculo_3 = new JMenuItem("Saida de veiculo");
		mntmSaidaDeVeiculo_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarSaidaDeVeiculo telaProcurarSaidaVeiculo = new TelaProcurarSaidaDeVeiculo();
				telaProcurarSaidaVeiculo.frmTelaAtualizarSaida.setVisible(true);
			}
		});
		mnProcurar.add(mntmSaidaDeVeiculo_3);
		
		JMenuItem mntmFuncionario_3 = new JMenuItem("Funcionario");
		mntmFuncionario_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarFuncionario tbf = new TelaBuscarFuncionario();
				tbf.frame.setVisible(true);
			}
		});
		mnProcurar.add(mntmFuncionario_3);
		
		JMenuItem mntmCadastroDeReserva_1 = new JMenuItem("Cadastro de Reserva");
		mntmCadastroDeReserva_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarCadastroDeReserva tbcdr = new TelaBuscarCadastroDeReserva();
				tbcdr.frame.setVisible(true);
				
			}
		});
		mnProcurar.add(mntmCadastroDeReserva_1);
		
		JMenu mnListar = new JMenu("LISTAR");
		menuBar.add(mnListar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Carro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarCarro telaListarCarros = new TelaListarCarro();
				telaListarCarros.frmTelaListarCarros.setVisible(true);
			}
		});
		mnListar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cliente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarCliente telaListarCliente = new TelaListarCliente();
				telaListarCliente.frmTelaListarClientes.setVisible(true);
			}
		});
		mnListar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Saida de Veiculos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarSaidaDeVeiculo telaListarSaidaVeiculo = new TelaListarSaidaDeVeiculo();
				telaListarSaidaVeiculo.frmTelaListarSaida.setVisible(true);
			}
		});
		mnListar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmFuncionario_4 = new JMenuItem("Funcionario");
		mntmFuncionario_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaListarFuncionario tlf = new TelaListarFuncionario();
			tlf.frame.setVisible(true);
			}
		});
		mnListar.add(mntmFuncionario_4);
		
		JMenuItem mntmCadastroDeReserva_2 = new JMenuItem("Cadastro de Reserva");
		mntmCadastroDeReserva_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarCadastroDeReserva tlcdr = new TelaListarCadastroDeReserva();
				tlcdr.frmListagemCadastroDe.setVisible(true);
			}
		});
		mnListar.add(mntmCadastroDeReserva_2);
		
		JLabel lblNewLabel = new JLabel("Locadora de veiculos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblNewLabel.setBounds(242, 238, 441, 99);
		frmTelaPrincipal.getContentPane().add(lblNewLabel);
	}
}
