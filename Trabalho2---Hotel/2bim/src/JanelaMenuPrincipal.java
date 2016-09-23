
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JanelaMenuPrincipal {
	private JDialog frame;

	private JMenuBar barraMenus;
	
	private JMenu menuCadastro;
	private JMenuItem editarCaracteristica;
	private JMenuItem menuHosp;
	private JMenuItem menuQua;
	private JMenuItem mnDespesas;
	private JMenuItem jMenuItem1;
	private JMenuItem excluirServico;
	private JMenuItem excluirProduto;
	private JMenuItem editarServico;
	private JMenuItem editarProduto;
	private JMenuItem cadServico;
	private JMenuItem cadProduto;
	private JMenuItem editarQuarto;
	private JMenuItem editarCliente;
	private JMenu menuEditar;
	private JMenuItem checkOut;
	private JMenuItem excluirCaract;
	private JMenuItem cadCaract;
	private JMenuItem excluirQuarto;
	private JMenuItem excluirCli;
	private JMenu menuExcluir;
	private JMenuItem cadCli;
	private JMenuItem cadQuarto;
	
	private JMenu menuControle;
	private JMenuItem checkIn;
	
	private JMenu menuRelatorio;

	private JMenuItem sair;

	public static void main(String[] args) {
		new JanelaMenuPrincipal();
	}

	public JanelaMenuPrincipal() {

		cadCli = new JMenuItem("Cliente");
		cadCli.setMnemonic('C');
		cadCli.addActionListener(new Lis1());

		menuCadastro = new JMenu("Cadastro");
		menuCadastro.add(cadCli);
		{
			cadQuarto = new JMenuItem();
			menuCadastro.add(cadQuarto);
		}
		cadQuarto.setText("Quarto");
		cadQuarto.addActionListener(new Lis3());
		{
			cadCaract = new JMenuItem();
			menuCadastro.add(cadCaract);
			cadCaract.setText("Característica");
			cadCaract.addActionListener(new Lis2());
		}
		{
			cadProduto = new JMenuItem();
			menuCadastro.add(cadProduto);
			cadProduto.setText("Produto");
			cadProduto.addActionListener(new Lis11());
		}
		{
			cadServico = new JMenuItem();
			menuCadastro.add(cadServico);
			cadServico.setText("Serviço");
			cadServico.addActionListener(new Lis12());
		}
		//-------------------

		menuControle = new JMenu("Controle");
		{
			checkIn = new JMenuItem();
			menuControle.add(checkIn);
		}
		checkIn.setText("Check In");
		checkIn.addActionListener(new Lis17());
		{
			checkOut = new JMenuItem();
			menuControle.add(checkOut);
			checkOut.setText("Check Out");
			checkOut.addActionListener(new Lis18());
		}
		{
			jMenuItem1 = new JMenuItem();
			menuControle.add(jMenuItem1);
			jMenuItem1.setText("Registrar Consumo");
			jMenuItem1.addActionListener(new Lis19());
		}
		//---------------------------

		menuRelatorio = new JMenu("Relatorio");
		//----------------------------
		sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		sair.addActionListener(new Lis6());

		barraMenus = new JMenuBar();
		barraMenus.add(menuCadastro);
		menuCadastro.setText("Cadastro  ");
		barraMenus.add(menuControle);
		menuControle.setText("Controle  ");
		barraMenus.add(menuRelatorio);
		menuRelatorio.setText("Relatório  ");
		{
			mnDespesas = new JMenuItem();
			menuRelatorio.add(mnDespesas);
			mnDespesas.setText("Despesas Pessoais");
			mnDespesas.addActionListener(new Lis20());
		}
		{
			menuQua = new JMenuItem();
			menuRelatorio.add(menuQua);
			menuQua.setText("Quartos");
			menuQua.addActionListener(new Lis21());
		}
		{
			menuHosp = new JMenuItem();
			menuRelatorio.add(menuHosp);
			menuHosp.setText("Hospedagens");
			menuHosp.addActionListener(new Lis22());
		}
		{
			menuEditar = new JMenu();
			barraMenus.add(menuEditar);
			menuEditar.setText("Editar  ");
			{
				editarCliente = new JMenuItem();
				menuEditar.add(editarCliente);
				editarCliente.setText("Cliente");
				editarCliente.addActionListener(new Lis8());
			}
			{
				editarQuarto = new JMenuItem();
				menuEditar.add(editarQuarto);
				editarQuarto.setText("Quarto");
				editarQuarto.addActionListener(new Lis9());
			}
			{
				editarCaracteristica = new JMenuItem();
				menuEditar.add(editarCaracteristica);
				editarCaracteristica.setText("Característica");
				editarCaracteristica.addActionListener(new Lis10());
			}
			{
				editarProduto = new JMenuItem();
				menuEditar.add(editarProduto);
				editarProduto.setText("Produto");
				editarProduto.addActionListener(new Lis15());
			}
			{
				editarServico = new JMenuItem();
				menuEditar.add(editarServico);
				editarServico.setText("Serviço");
				editarServico.addActionListener(new Lis16());
			}
		}
		{
			menuExcluir = new JMenu();
			barraMenus.add(menuExcluir);
			menuExcluir.setText("Excluir  ");
			{
				excluirCli = new JMenuItem();
				menuExcluir.add(excluirCli);
				excluirCli.setText("Cliente");
				excluirCli.addActionListener(new Lis4());
			}
			{
				excluirQuarto = new JMenuItem();
				menuExcluir.add(excluirQuarto);
				excluirQuarto.setText("Quarto");
				excluirQuarto.addActionListener(new Lis7());
			}
			{
				excluirCaract = new JMenuItem();
				menuExcluir.add(excluirCaract);
				excluirCaract.setText("Característica");
				excluirCaract.addActionListener(new Lis5());			}
			{
				excluirProduto = new JMenuItem();
				menuExcluir.add(excluirProduto);
				excluirProduto.setText("Produto");
				excluirProduto.addActionListener(new Lis13());
			}
			{
				excluirServico = new JMenuItem();
				menuExcluir.add(excluirServico);
				excluirServico.setText("Serviço");
				excluirServico.addActionListener(new Lis14());
			}
		}
		barraMenus.add(sair);

		frame = new JDialog();
		frame.setTitle("Hotel San Diego - Sistema de Hotel");
		frame.setModal(true);
		frame.setJMenuBar(barraMenus);
		// frame.pack();
		frame.setSize(352, 293);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(new java.awt.Dimension(352, 293));
	}
	private int op;
	public int getOp(){
		return op;
	}
	
	private class Lis1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 1;
			frame.dispose();
		}
	}
	private class Lis2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 2;
			frame.dispose();
		}
	}
	private class Lis3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 3;
			frame.dispose();
		}
	}
	private class Lis4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 4;
			frame.dispose();
		}
	}
	private class Lis5 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 5;
			frame.dispose();
		}
	}
	private class Lis6 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 6;
			frame.dispose();
		}
	}
	private class Lis7 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 7;
			frame.dispose();
		}
	}
	private class Lis8 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 8;
			frame.dispose();
		}
	}
	private class Lis9 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 9;
			frame.dispose();
		}
	}
	private class Lis10 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 10;
			frame.dispose();
		}
	}
	private class Lis11 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 11;
			frame.dispose();
		}
	}
	private class Lis12 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 12;
			frame.dispose();
		}
	}
	private class Lis13 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 13;
			frame.dispose();
		}
	}
	private class Lis14 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 14;
			frame.dispose();
		}
	}
	private class Lis15 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 15;
			frame.dispose();
		}
	}
	private class Lis16 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 16;
			frame.dispose();
		}
	}
	private class Lis17 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 17;
			frame.dispose();
		}
	}
	private class Lis18 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 18;
			frame.dispose();
		}
	}
	private class Lis19 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 19;
			frame.dispose();
		}
	}
	private class Lis20 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 20;
			frame.dispose();
		}
	}
	private class Lis21 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 21;
			frame.dispose();
		}
	}
	private class Lis22 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 22;
			frame.dispose();
		}
	}
}