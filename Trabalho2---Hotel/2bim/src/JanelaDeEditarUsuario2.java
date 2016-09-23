import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




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
public class JanelaDeEditarUsuario2 {
	private JLabel labelNome;
	static JTextField tfNome;
	private JLabel lbSenha;
	static JPasswordField tfSenha;
	private JButton btOk;
	private JPanel panel;
	private JDialog frame;
	private JTextField tfLogin;
	private JTextField tfConfirma;
	
	private int op;
	
	public JanelaDeEditarUsuario2(int co){
		ArrayList<Usuario> vetor = new ArrayList<Usuario>();

		Connection conexao = null;
		UsuarioDAO daoUsuario = null;

		
		try {
			conexao = ConnectionFactory.getConnection();
			daoUsuario = new UsuarioDAO(conexao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			vetor = daoUsuario.listaPorCod(co);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		op = vetor.get(0).getCod();
		
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(5, 5, 100, 20);
		tfNome = new JTextField(20);
		tfNome.setBounds(5,30,250,20);
		tfNome.setText(vetor.get(0).getNome());
		lbSenha = new JLabel("Senha");
		lbSenha.setBounds(5, 117, 46, 20);
		tfSenha = new JPasswordField(20);
		tfSenha.setBounds(5,142,117,20);
		btOk = new JButton("Ok");
		btOk.setBounds(66, 179, 90, 20);
		btOk.addActionListener(new OkListener());
		JButton btSair = new JButton("Cancelar");
		btSair.setBounds(166, 179, 89, 20);
		btSair.addActionListener(new SairListener());
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(labelNome);
		panel.add(tfNome);
		panel.add(lbSenha);
		panel.add(tfSenha);
		panel.add(btOk);
		panel.add(btSair);
		
		frame = new JDialog();
		frame.setTitle("Cadastro de Usu\u00E1rio - Hotel");
		frame.setModal(true);
		frame.getContentPane().add(panel);
		panel.setPreferredSize(new java.awt.Dimension(234, 145));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(5, 61, 46, 14);
		panel.add(lblLogin);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(5, 86, 250, 20);
		tfLogin.setText(vetor.get(0).getLogin());
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setBounds(132, 120, 117, 14);
		panel.add(lblConfirmeASenha);
		
		tfConfirma = new JPasswordField(20);
		tfConfirma.setBounds(132, 142, 123, 20);
		panel.add(tfConfirma);
		tfConfirma.setColumns(10);
		frame.setSize(271, 240);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		//new JanelaDeEditarUsuario2();
		
	}
	private class OkListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (tfNome.getText().equals(""))
				JOptionPane.showMessageDialog(frame, "Campo Obrigat�rio! Preencha o campo NOME.", "Erro", JOptionPane.ERROR_MESSAGE);
			else if (tfLogin.getText().equals(""))
				JOptionPane.showMessageDialog(frame, "Campo Obrigat�rio! Preencha o campo LOGIN.", "Erro", JOptionPane.ERROR_MESSAGE);
			else if (tfSenha.getText().equals("") || tfConfirma.getText().equals(""))
				JOptionPane.showMessageDialog(frame, "Preencha o campo senha e a confirme.", "Erro", JOptionPane.ERROR_MESSAGE);
			else{
				if (tfSenha.getText().equals(tfConfirma.getText())){
					Usuario usu = new Usuario();
					usu.setNome(getTfNome().getText());
					usu.setLogin(getTfLogin().getText());
					usu.setSenha(getTfSenha().getText());
					
					Connection conexao;
					int codigo = getOp();
					try {
						conexao = ConnectionFactory.getConnection();
						UsuarioDAO dao = new UsuarioDAO(conexao);
						dao.edita(usu, codigo);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					frame.dispose();
				}else if(!tfSenha.getText().equals(tfConfirma.getText()))
					JOptionPane.showMessageDialog(frame, "Erro! As senhas n�o coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private class SairListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			op = 2;
			frame.dispose();
			JanelaDeEditarUsuario j = new JanelaDeEditarUsuario();
		}
	}
	public JTextField getTfSenha(){
		return tfSenha;
	}
	public JTextField getTfNome(){
		return tfNome;
	}
	public JTextField getTfLogin(){
		return tfLogin;
	}
	public int getOp(){
		return op;
	}
}