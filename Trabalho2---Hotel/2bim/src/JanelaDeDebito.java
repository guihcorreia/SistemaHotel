
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.Font;

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
public class JanelaDeDebito {
	private JScrollPane TabTodasCaract;
	private JButton btAdd;
	private JButton butCancelar;
	private JButton btSalvar;
	private DefaultTableModel modelo, modelo2;
	private JTable table1;
	private JPanel panel;
	private JLabel lbMes;
	private JDialog frame;
	private int op;
	int cont;
	private JRadioButton rdbtnNovoDbito;
	private JTextField textNome;
	private JTextField textValor;
	private boolean adiciona = true;
	private JComboBox comboBox;



	public int getOp() {
		return op;
	}
	public static void main(String[] args) {
		new JanelaDeDebito();
	}

	public JanelaDeDebito() {
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL; // n√£o redimensionar objeto inserido;
		cons.insets = new Insets(3,3, 3, 3); // distancia entre os objetos
		cons.anchor = GridBagConstraints.WEST;

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(280, 375));
		
		
		{
			btSalvar = new JButton();
			panel.add(btSalvar);
			btSalvar.setText("OK");
			btSalvar.addActionListener(new MostrarListener());
			btSalvar.setBounds(98, 336, 76, 23);
		}
		{
			butCancelar = new JButton();
			panel.add(butCancelar);
			butCancelar.setText("Cancelar");
			butCancelar.addActionListener(new SairListener());
			butCancelar.setBounds(184, 336, 86, 23);
		}
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setBounds(12, 35, 74, 20);
		comboBox.addActionListener(new ComboListener());
		
		panel.add(comboBox);
		
		{
			String colunas[] = new String[] {"ID","Nome", "Valor"};
			modelo = new DefaultTableModel(colunas,0);
			
			ArrayList<Debito> vetDeb = new ArrayList<Debito>();

			Connection conexao = null;
			DebitoDAO daoDeb = null;

			
			try {
				conexao = ConnectionFactory.getConnection();
				daoDeb = new DebitoDAO(conexao);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				vetDeb = daoDeb.listaPorMes(comboBox.getSelectedItem().toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < vetDeb.size(); i++) {
				modelo.addRow(new Object[] {vetDeb.get(i).getCod(),vetDeb.get(i).getNome(), vetDeb.get(i).getValor()});	
			}
			
			table1 = new JTable(modelo);

			table1.getColumnModel().getColumn(0).setPreferredWidth(40);
			table1.getColumnModel().getColumn(0).setResizable(true);
			table1.getColumnModel().getColumn(1).setPreferredWidth(147);
			table1.getColumnModel().getColumn(1).setResizable(false);
			table1.getColumnModel().getColumn(2).setPreferredWidth(56);
			table1.getColumnModel().getColumn(2).setResizable(false);
			table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//table1.setPreferredSize(new java.awt.Dimension(196, 18));
			//table1.getTableHeader().setMinimumSize(new java.awt.Dimension(90, 18));
			table1.addMouseListener(new MouseListener());
			TabTodasCaract = new JScrollPane(table1);
			
			panel.add(TabTodasCaract);
			TabTodasCaract
			.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			TabTodasCaract
			.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			TabTodasCaract.setBounds(12, 139, 262, 186);
			
			
			
		}
		{
			String colunas[] = new String[] {"ID","Qtd", "Nome", "Valor", "Caract"};
			modelo2 = new DefaultTableModel(colunas,0);
		}
		{
			btAdd = new JButton();
			panel.add(btAdd);
			btAdd.setText("Adicionar");
			btAdd.addActionListener(new AdicionaListener());
			btAdd.setBounds(184, 91, 90, 21);
		}
		{
			lbMes = new JLabel();
			panel.add(lbMes);
			lbMes.setText("M\u00EAs");
			lbMes.setBounds(12, 12, 65, 16);
			lbMes.setFont(new java.awt.Font("Tahoma",1,12));
		}
	    
		
		frame = new JDialog();
		frame.setResizable(false);
		frame.setTitle("Registro de DÈbito - Hotel");
		frame.setModal(true);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		
		
		rdbtnNovoDbito = new JRadioButton("Novo D\u00E9bito");
		rdbtnNovoDbito.setSelected(true);
		rdbtnNovoDbito.setBounds(111, 34, 109, 23);
		rdbtnNovoDbito.addActionListener(new NovoDebListener());
		panel.add(rdbtnNovoDbito);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(12, 66, 46, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(12, 91, 86, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(108, 66, 46, 14);
		panel.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(108, 91, 66, 20);
		panel.add(textValor);
		textValor.setColumns(10);
		frame.pack(); // ajusta o tamanho da janela (frame)
		frame.setLocationRelativeTo(null); // coloca no meio
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		/*if (cont == 0){
			JOptionPane.showMessageDialog(frame, "Nenhum Cliente Hospedado", "Hotel Vazio", JOptionPane.ERROR_MESSAGE);
		}else{
			frame.setVisible(true);
		}*/
		
		
	}
	private class MouseListener implements java.awt.event.MouseListener {
		public void mouseClicked(MouseEvent e) {
			int l = table1.getSelectedRow();
			textNome.setText(""+modelo.getValueAt(l, 1));
			textValor.setText(""+modelo.getValueAt(l, 2));
			rdbtnNovoDbito.setSelected(false);
			adiciona= false;
			btAdd.setText("Editar");
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class MostrarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			frame.dispose();
		}
	}
	private class AdicionaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(adiciona){
				boolean erro = false;
				
				if(textNome.getText() == null || textNome.getText().isEmpty()){
					textNome.setBackground(Color.pink);
					erro = true;
				}
				
				if(textValor.getText() == null || textValor.getText().isEmpty()){
					textValor.setBackground(Color.pink);
					erro = true;
				}
				
				if (!erro){
					Debito debito = new Debito();
					debito.setNome(textNome.getText());
					if (textValor.getText() != null){
						debito.setValor(Double.parseDouble(textValor.getText()));
					}
					debito.setMes(comboBox.getSelectedItem().toString());
					Connection conexao = null;
					DebitoDAO daoDebito = null;
					try {
						conexao = ConnectionFactory.getConnection();
						daoDebito = new DebitoDAO(conexao);
						
						daoDebito.adiciona(debito);
						
						conexao.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "DÈbito registrado com sucesso!");
				}else{
					JOptionPane.showMessageDialog(frame, "Preencha todos os campos obrigatÛrios", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				textNome.setText("");
				textValor.setText("");
			}else{
				int l = table1.getSelectedRow();
				int cod = Integer.parseInt(""+modelo.getValueAt(l, 0));
				boolean erro = false;
				
				if(textNome.getText() == null || textNome.getText().isEmpty()){
					textNome.setBackground(Color.pink);
					erro = true;
				}
				
				if(textValor.getText() == null || textValor.getText().isEmpty()){
					textValor.setBackground(Color.pink);
					erro = true;
				}
				
				if (!erro){
					Debito debito = new Debito();
					debito.setNome(textNome.getText());
					if (textValor.getText() != null){
						debito.setValor(Double.parseDouble(textValor.getText()));
					}
					debito.setMes(comboBox.getSelectedItem().toString());
					Connection conexao = null;
					DebitoDAO daoDebito = null;
					try {
						conexao = ConnectionFactory.getConnection();
						daoDebito = new DebitoDAO(conexao);
						
						daoDebito.edita(debito,cod);
						
						conexao.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "DÈbito editado com sucesso!");
				}else{
					JOptionPane.showMessageDialog(frame, "Preencha todos os campos obrigatÛrios", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				textNome.setText("");
				textValor.setText("");
			}
			int row = modelo.getRowCount();
			for (int i = 0; i < row; i++) {
				modelo.removeRow(0);
			}
			
			ArrayList<Debito> vetDeb = new ArrayList<Debito>();

			Connection conexao = null;
			DebitoDAO daoDeb = null;

			
			try {
				conexao = ConnectionFactory.getConnection();
				daoDeb = new DebitoDAO(conexao);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				vetDeb = daoDeb.listaPorMes(comboBox.getSelectedItem().toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < vetDeb.size(); i++) {
				modelo.addRow(new Object[] {vetDeb.get(i).getCod(),vetDeb.get(i).getNome(), vetDeb.get(i).getValor()});	
			}
		}
	}
	private class NovoDebListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			textNome.setText("");
			textValor.setText("");
			btAdd.setText("Adicionar");
			adiciona = true;
		}
	}
	private class ComboListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = modelo.getRowCount();
			for (int i = 0; i < row; i++) {
				modelo.removeRow(0);
			}
			
			ArrayList<Debito> vetDeb = new ArrayList<Debito>();

			Connection conexao = null;
			DebitoDAO daoDeb = null;

			
			try {
				conexao = ConnectionFactory.getConnection();
				daoDeb = new DebitoDAO(conexao);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				vetDeb = daoDeb.listaPorMes(comboBox.getSelectedItem().toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < vetDeb.size(); i++) {
				modelo.addRow(new Object[] {vetDeb.get(i).getCod(),vetDeb.get(i).getNome(), vetDeb.get(i).getValor()});	
			}
		}
	}

	private class SairListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 2;
			frame.dispose();
		}
	}
}