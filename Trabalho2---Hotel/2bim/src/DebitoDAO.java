import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class DebitoDAO {
	
	private Connection conexao = null;

	public DebitoDAO(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}
	public void adiciona(Debito debito) {
		String sql = "INSERT INTO hotel.debito (nome, valor, mes) VALUES (?,?,?)"; 
		PreparedStatement stmt;
		
		try{
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, debito.getNome());
			stmt.setDouble(2, debito.getValor());
			stmt.setString(3, debito.getMes());
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void excluir(int codigo) {
		String sql = "DELETE FROM hotel.debito WHERE debito.cod = ?";
		PreparedStatement stmt;
		try{
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Debito> listaTodos() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM hotel.debito");

		ResultSet rs = stmt.executeQuery();
		ArrayList<Debito> vetor = new ArrayList<Debito>();

		while (rs.next()) {
			Debito debito = new Debito();
			debito.setCod(rs.getInt("cod"));
			debito.setNome(rs.getString("nome"));
			debito.setValor(rs.getDouble("valor"));


			vetor.add(debito);
		}
		

		return vetor;
	}
	public void edita(Debito debito, int cod) {
		String sql = "UPDATE `hotel`.`debito` SET `nome` = ?, `valor` = ?, `mes` = ?  WHERE `debito`.`cod` =?;"; 
		PreparedStatement stmt;
		
		try{
			stmt = conexao.prepareStatement(sql);
			
			
			stmt.setString(1, debito.getNome());
			stmt.setDouble(2, debito.getValor());
			stmt.setString(3, debito.getMes());
			
			stmt.setInt(4, cod);
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public ArrayList<Debito> listaPorCod(int cod) throws SQLException {
		String sql = "SELECT * FROM debito WHERE debito.cod = ?";
		PreparedStatement stmt = null;
		try{
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, cod);
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		ArrayList<Debito> vetor = new ArrayList<Debito>();

		while (rs.next()) {
			Debito debito = new Debito();
			debito.setCod(rs.getInt("cod"));
			debito.setNome(rs.getString("nome"));
			debito.setValor(rs.getDouble("valor"));
			

			vetor.add(debito);
		}
		

		return vetor;
	}
	public ArrayList<Debito> listaPorMes(String mes) throws SQLException {
		String sql = "SELECT * FROM debito WHERE debito.mes = ?";
		PreparedStatement stmt = null;
		try{
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, mes);
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		ArrayList<Debito> vetor = new ArrayList<Debito>();

		while (rs.next()) {
			Debito debito = new Debito();
			debito.setCod(rs.getInt("cod"));
			debito.setNome(rs.getString("nome"));
			debito.setValor(rs.getDouble("valor"));
			debito.setMes(rs.getString("mes"));
			

			vetor.add(debito);
		}
		

		return vetor;
	}
	public String getNomePorCod(int cod) throws SQLException {
		String sql = "SELECT * FROM debito WHERE debito.cod = ?";
		PreparedStatement stmt = null;
		try{
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, cod);
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		String nome = null;

		while (rs.next()) {
			nome = rs.getString("nome");
		}
		

		return nome;
	}
	public ResultSet listaTodosRS() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from hotel.debito");

		ResultSet rs = stmt.executeQuery();

		return rs;
	}
}