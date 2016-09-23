import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class JanelaDeLogin {
	private JLabel labelNome;
	static JTextField tfNome;
	private JLabel lbSenha;
	static JPasswordField tfSenha;
	private JButton btOk;
	private JPanel panel;
	private JDialog frame;
	
	
	public JanelaDeLogin(){
		labelNome = new JLabel("Nome de usu�rio:");
		labelNome.setBounds(5, 5, 100, 20);
		tfNome = new JTextField(20);
		tfNome.setBounds(5,30,200,20);
		lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(5, 50, 200, 20);
		tfSenha = new JPasswordField(20);
		tfSenha.setBounds(5,70,200,20);
		btOk = new JButton("Ok");
		btOk.setBounds(5, 100, 90, 20);
		btOk.addActionListener(new OkListener());
		JButton btSair = new JButton("Cancelar");
		btSair.setBounds(116, 100, 89, 20);
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
		frame.setTitle("Login de acesso - Hotel");
		frame.setModal(true);
		frame.add(panel);
		panel.setPreferredSize(new java.awt.Dimension(234, 145));
		frame.setSize(235, 170);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JanelaDeLogin();
		
	}
	private class OkListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (tfSenha.getText().equals("1234") && (tfNome.getText().equals("admin"))) 
				frame.dispose();
			else
				JOptionPane.showMessageDialog(frame, "Erro! Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	private class SairListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			tfSenha.setText("1111");
			frame.dispose();
		}
	}
	public JTextField getTfSenha(){
		return tfSenha;
	}
	public JTextField getTfUsu(){
		return tfNome;
	}
	
}