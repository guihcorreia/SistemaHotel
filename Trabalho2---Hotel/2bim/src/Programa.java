import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Programa {
	public static void main(String[] args) {
		String senha;
		String usu;
		JanelaDeLogin j0 = new JanelaDeLogin();
		senha = j0.getTfSenha().getText();
		usu = j0.getTfUsu().getText();
		Cliente cli = new Cliente();
		Quarto quarto = new Quarto();
		Caract caract = new Caract();
		Usuario usuario = new Usuario();
		
		
		ArrayList<Usuario> vetorUsu = new ArrayList<Usuario>();

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
			vetorUsu = daoUsuario.listaTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean acesso = false;
		
		for (int i = 0; i < vetorUsu.size(); i++) {
			if(usu.equals(vetorUsu.get(i).getLogin()) && senha.equals(vetorUsu.get(i).getSenha())){
				acesso = true;
			}
		}
		
		
		
		if (acesso){
			int op;
			do{
				JanelaMenuPrincipal janMenPrin = new JanelaMenuPrincipal();
				op = janMenPrin.getOp();
				if (op == 1){
					JanelaDeCadastroCliente janCadCli = new JanelaDeCadastroCliente();
					
					if (janCadCli.getOp() == 1){
						cli.setNome(janCadCli.getTfNome().getText());
						cli.setRua(janCadCli.getTfEndereco().getText());
						cli.setNumero(Integer.parseInt(janCadCli.getTfNum().getText()));
						cli.setCidade(janCadCli.getTfCidade().getText());
						cli.setUf((String) janCadCli.getTfUF().getSelectedItem());
						cli.setCep(janCadCli.getTfCEP().getText());
						cli.setCpf(janCadCli.getTfCPF().getText());
						cli.setIdentidade(janCadCli.getTfIden().getText());
						cli.setTelefone(janCadCli.getTfTel().getText());
						cli.setEmail(janCadCli.getTfEmail().getText());
						
						//DATA--
						Calendar calen = new GregorianCalendar();
						SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
						try {
							calen.setTime(f.parse(janCadCli.getTfData().getText()));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						cli.setDataNasc(calen);
						
						conexao = null;
						ClienteDAO daoContato = null;
						try {
							conexao = ConnectionFactory.getConnection();
							daoContato = new ClienteDAO(conexao);
							
							daoContato.adiciona(cli);
							
							conexao.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");					
					}
				}
				if (op == 2){
					JanelaDeCadastroDeCaract janCadCaract = new JanelaDeCadastroDeCaract();
					if (janCadCaract.getOp() == 1){
						caract.setNome(janCadCaract.getTfNome().getText());
						if (janCadCaract.getTfDescCaract().getText() != null){
							caract.setDescricao(janCadCaract.getTfDescCaract().getText());
						}
						conexao = null;
						CaractDAO daoCaracteristica = null;
						try {
							conexao = ConnectionFactory.getConnection();
							daoCaracteristica = new CaractDAO(conexao);
							
							daoCaracteristica.adiciona(caract);
							
							conexao.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}					
						JOptionPane.showMessageDialog(null, "Característica cadastrada com sucesso!");
					}
				}
				if (op ==3){
					JanelaDeCadastroQuarto janCadQua = new JanelaDeCadastroQuarto();
					
					if (janCadQua.getOp() == 1){
						quarto.setNumero(Integer.parseInt(janCadQua.getTfNum().getText()));
						quarto.setValorDiaria(Double.parseDouble(janCadQua.getTfValorDiaria().getText()));
						int cont = janCadQua.getTable2().getRowCount();
						int cont2 = 0;
						
						//aki
						int vetCod[] = new int[cont];
						int vetQtd[] = new int[cont];
						
						for (int i=0; i<cont; i++){
							vetCod[i] = Integer.parseInt((String)janCadQua.getTable2().getValueAt(i, 0));
							vetQtd[i] = Integer.parseInt((String)janCadQua.getTable2().getValueAt(i, 2));
						}
						//ate aki
						
						conexao = null;
						QuartoDAO daoQuarto = null;
						//aki
						ArrayList<Quarto> vetor = new ArrayList<Quarto>();
						try {
							conexao = ConnectionFactory.getConnection();
							daoQuarto = new QuartoDAO(conexao);
						
							daoQuarto.adiciona(quarto);
							//aki
							vetor = daoQuarto.listaTodos();
						
							conexao.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						//aki
						for (int j = 0; j < vetor.size(); j++) {
							cont2 = vetor.get(j).getCod();
						}
						conexao = null;
						Quarto_CaractDAO daoQuarto_Caract = null;
						try {
							conexao = ConnectionFactory.getConnection();
							daoQuarto_Caract = new Quarto_CaractDAO(conexao);
							for (int i=0; i<cont; i++){
								daoQuarto_Caract.adiciona(cont2, vetCod[i], vetQtd[i]);
							}
							
						
							conexao.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Quarto cadastrado com sucesso!");
					}
				}
				if (op ==4){
					JanelaDeExcluirCliente janExCli = new JanelaDeExcluirCliente();
				}
				if (op ==5){
					JanelaDeExcluirCaract janExCar = new JanelaDeExcluirCaract();
				}
				if (op ==7){
					JanelaDeExcluirQuarto janExQua = new JanelaDeExcluirQuarto();
				}
				if (op ==8){
					JanelaDeEditarCliente janEditCli = new JanelaDeEditarCliente();
				}
				if (op ==9){
					JanelaDeEditarQuarto janEditQua = new JanelaDeEditarQuarto();
				}
				if (op ==10){
					JanelaDeEditarCaract janEditCar = new JanelaDeEditarCaract();
				}
				if (op ==11){
					JanelaDeCadastroProduto janCadPro = new JanelaDeCadastroProduto();
				}
				if (op ==12){
					JanelaDeCadastroServico janCadSer = new JanelaDeCadastroServico();
				}
				if (op ==13){
					JanelaDeExcluirProduto janCadSer = new JanelaDeExcluirProduto();
				}
				if (op ==14){
					JanelaDeExcluirServico janCadSer = new JanelaDeExcluirServico();
				}
				if (op ==15){
					JanelaDeEditarProduto janEdiPro = new JanelaDeEditarProduto();
				}
				if (op ==16){
					JanelaDeEditarServico janEdiSer = new JanelaDeEditarServico();
				}
				if (op ==17){
					JanelaDeCheckIn janCheckIn = new JanelaDeCheckIn();
				}
				if (op ==18){
					JanelaDeCheckOutQua janCheckout = new JanelaDeCheckOutQua();
				}
				if (op ==19){
					JanelaDeConsumo janCons = new JanelaDeConsumo();
				}
				if (op ==20){
					JanelaDeRelatorioDespesas janRelDesp = new JanelaDeRelatorioDespesas();
				}
				if (op ==21){
					JanelaDeRelatorioQuartos janRelQua = new JanelaDeRelatorioQuartos();
				}
				if (op ==22){
					JanelaDeRelatorioHospedagem janRelHosp = new JanelaDeRelatorioHospedagem();
				}
				if (op ==23){
					JanelaDeCadastroDeUsuario janCadUsu = new JanelaDeCadastroDeUsuario();
					if (janCadUsu.getOp() == 1){
						usuario.setNome(janCadUsu.getTfNome().getText());
						usuario.setLogin(janCadUsu.getTfLogin().getText());
						usuario.setSenha(janCadUsu.getTfSenha().getText());
						usuario.setPergunta(janCadUsu.getTfPergunta().getText());
						usuario.setResposta(janCadUsu.getTfResposta().getText());
						
						conexao = null;
						daoUsuario = null;
						try {
							conexao = ConnectionFactory.getConnection();
							daoUsuario = new UsuarioDAO(conexao);
							
							daoUsuario.adiciona(usuario);
							
							conexao.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					}
				}
				if (op == 24){
					JanelaDeEditarUsuario janEditUsu = new JanelaDeEditarUsuario();
				}
				if (op == 25){
					JanelaDeExcluirUsuario janExcUsu = new JanelaDeExcluirUsuario();
				}
				if (op == 26){
					JanelaDeDebito janRegDeb = new JanelaDeDebito();
				}
				
			}while(op != 6);
		}
		JOptionPane.showMessageDialog(null, "Fechando o sistema!");
	}
}
