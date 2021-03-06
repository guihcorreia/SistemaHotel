import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
public class JanelaDeRegistrarDebito {



	private JPanel panel;
	private JButton btCancelar;
	private JButton btSalvar;
	private JTextField tfValor;
	private JLabel lbCod;
	private JLabel lbValor;
	private JTextField tfCod;
	private JLabel lbNome;
	private JTextField tfNome;
	private JDialog frame;
	
	private int op;
	public JTextField getTfValor() {
		return tfValor;
	}

	public void setTfValor(JTextField tfValor) {
		this.tfValor = tfValor;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfCod() {
		return tfCod;
	}

	public void setTfCod(JTextField tfCod) {
		this.tfCod = tfCod;
	}

	public int getOp() {
		return op;
	}

	public JanelaDeRegistrarDebito() {
		ArrayList<Debito> vetor = new ArrayList<Debito>();

		Connection conexao = null;
		DebitoDAO daoDebito = null;

		
		try {
			conexao = ConnectionFactory.getConnection();
			daoDebito = new DebitoDAO(conexao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			vetor = daoDebito.listaTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cont = 0;
		for (int i = 0; i < vetor.size(); i++) {
			cont = vetor.get(i).getCod();
		}
		

		
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL; // não redimensionar objeto inserido;
		cons.insets = new Insets(3,3, 3, 3); // distancia entre os objetos
		cons.anchor = GridBagConstraints.WEST;

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new java.awt.Dimension(316, 152));
		{
			tfNome = new JTextField();
			tfNome.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					tfNome.setBackground(Color.white);
				}
			});
			panel.add(tfNome);
			tfNome.setPreferredSize(new java.awt.Dimension(227, 21));
			tfNome.setSize(227, 21);
			tfNome.setBounds(77, 32, 227, 19);
		}
		{
			lbNome = new JLabel();
			panel.add(lbNome);
			lbNome.setText("Nome *");
			lbNome.setFont(new java.awt.Font("Tahoma",1,12));
			lbNome.setBounds(77, 13, 51, 14);
		}
		{
			lbCod = new JLabel();
			panel.add(lbCod);
			lbCod.setText("C�digo");
			lbCod.setFont(new java.awt.Font("Tahoma",1,12));
			lbCod.setBounds(12, 12, 65, 14);
			
		}
		{
			tfCod = new JTextField();
			panel.add(tfCod);
			tfCod.setEditable(false);
			tfCod.setBounds(12, 32, 45, 21);
			tfCod.setText(""+(cont+1));
		}
		{
			lbValor = new JLabel();
			panel.add(lbValor);
			lbValor.setText("Valor *");
			lbValor.setFont(new java.awt.Font("Tahoma",1,12));
			lbValor.setBounds(12, 65, 65, 14);
		}
		{
		/*	
			DecimalFormat dFormat = new DecimalFormat ( "#######.##" ) ;
			NumberFormatter Formatter = new NumberFormatter ( dFormat ) ;
			Formatter.setFormat ( dFormat ) ;
			Formatter.setAllowsInvalid ( false ) ; 
			*/
			
			tfValor = new JTextField();
			tfValor.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					tfValor.setBackground(Color.white);
				}
			});
			panel.add(tfValor);
			tfValor.setBounds(12, 85, 292, 21);
		}
		{
			btSalvar = new JButton();
			panel.add(btSalvar);
			btSalvar.setText("Salvar");
			btSalvar.setBounds(66, 119, 85, 21);
			btSalvar.addActionListener(new MostrarListener());
		}
		{
			btCancelar = new JButton();
			panel.add(btCancelar);
			btCancelar.setText("Cancelar");
			btCancelar.setBounds(162, 119, 85, 21);
			btCancelar.addActionListener(new SairListener());
		}

		frame = new JDialog();
		frame.setTitle("Registrar D\u00E9bitos - Hotel");
		frame.setModal(true);
		//frame.add(panel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		//frame.add(panelBotoes);
		//frame.getContentPane().add(BorderLayout.SOUTH, panelBotoes);
		//frame.setSize(300, 300);
		frame.pack(); // ajusta o tamanho da janela (frame)
		frame.setLocationRelativeTo(null); // coloca no meio
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Sair do
		frame.setResizable(false);								// programa
		frame.setVisible(true); // torna a janela visível
	}

	private class MostrarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean erro = false;
			
			if(tfNome.getText() == null || tfNome.getText().isEmpty()){
				tfNome.setBackground(Color.pink);
				erro = true;
			}
			
			if(tfValor.getText() == null || tfValor.getText().isEmpty()){
				tfValor.setBackground(Color.pink);
				erro = true;
			}
			
			if (!erro){
				Debito debito = new Debito();
				debito.setNome(getTfNome().getText());
				if (getTfValor().getText() != null){
					debito.setValor(Double.parseDouble(getTfValor().getText()));
				}
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
				JOptionPane.showMessageDialog(null, "D�bito registrado com sucesso!");
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(frame, "Preencha todos os campos obrigat�rios", "Erro", JOptionPane.ERROR_MESSAGE);
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


	public static void main(String[] args) {
		new JanelaDeRegistrarDebito();
	}


}