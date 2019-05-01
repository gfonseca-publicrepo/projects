package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.DadosBancarios;
import model.DadosBancarios.Banco;
import model.DadosBancarios.TipoConta;
import util.ConexaoBD;
import util.MySQL;

public class DadosBancariosDAO {

	public static class BancoDAO {

		public static List<Banco> carregarBox() {

			List<Banco> bancos = new ArrayList<Banco>();

			try {

				String sql = "select * from bancos";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {
					Banco banco = new Banco(rs.getInt("id"), rs.getString("numero"), rs.getString("nome"));

					bancos.add(banco);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return bancos;

		}

		public static Banco selecionar(int id) {

			Banco b = null;

			try {

				String sql = "select * from bancos where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {

					b = new Banco(rs.getInt("id"), rs.getString("numero"), rs.getString("nome"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (SQLException e) {

				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			return b;

		}
	}

	public static class TipoContaDAO {

		public static List<TipoConta> carregarBox() {

			List<TipoConta> tipos = new ArrayList<TipoConta>();

			try {

				String sql = "select * from tipoconta";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {
					TipoConta tipo = new TipoConta(rs.getInt("id"), rs.getString("tipo"));

					tipos.add(tipo);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return tipos;

		}

		public static TipoConta selecionar(int id) {

			TipoConta tc = null;

			try {

				String sql = "select * from tipoconta where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {

					tc = new TipoConta(rs.getInt("id"), rs.getString("tipo"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (SQLException e) {

				JOptionPane.showMessageDialog(null, e.getMessage());

			}

			return tc;

		}
	}

	public static void inserirDadosFuncionario(DadosBancarios dados, int fkMatricula) {

		try {

			String sql = "insert into dadosbancofunc (numConta, agencia, FKBanco, FKFuncionario, FKTipoConta) values (?,?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, dados.getNumeroConta());
			comando.setString(2, dados.getAgencia());
			comando.setInt(3, dados.getBanco().getId());
			comando.setInt(4, fkMatricula);
			comando.setInt(5, dados.getTpConta().getId());

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

	}

	public static DadosBancarios selecionarDadosBancoFun(int fkMatricula) {

		DadosBancarios db = null;

		try {

			String sql = "select * from dadosbancofunc where FKFuncionario = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkMatricula);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				db = new DadosBancarios(rs.getInt("id"), rs.getString("numConta"), rs.getString("agencia"),
						TipoContaDAO.selecionar(rs.getInt("FKTipoConta")), BancoDAO.selecionar(rs.getInt("FKBanco")));

			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return db;

	}

}
