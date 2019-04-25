package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

import model.DocFun;
import util.Conexao;
import util.MySQL;

public class DocFunDAO {

	@SuppressWarnings("deprecation")
	public static void novo(String rg, String orgaoEmissor, Date dtEmissao, String cpf, String ctps, String pis,
			String pai, String mae, Date aso, int fkMatricula) {

		try {

			String sql = "insert into docfun (rg, orgaoemissor, dtEmissao, cpf, nomePai, nomeMae, ctps, pis, ultimoAso, FKFuncionario) values (?,?,?,?,?,?,?,?,?,?)";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			java.sql.Date d1 = new java.sql.Date(dtEmissao.getDate());
			java.sql.Date d2 = new java.sql.Date(aso.getDate());

			comando.setString(1, rg);
			comando.setString(2, orgaoEmissor);
			comando.setDate(3, d1);
			comando.setString(4, cpf);
			comando.setString(5, pai);
			comando.setString(6, mae);
			comando.setString(7, ctps);
			comando.setString(8, pis);
			comando.setDate(9, d2);
			comando.setInt(10, fkMatricula);

			comando.executeUpdate();

			comando.close();
			con.close();

			JOptionPane.showMessageDialog(null, "DocFun Salvo", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

	}

	public static DocFun selecionarDoc(int fk) {

		DocFun df = null;

		try {

			String sql = "select * from docfun where FKFuncionario = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				df = new DocFun(rs.getInt("id"), rs.getString("rg"), rs.getString("orgaoEmissor"),
						rs.getDate("dtEmissao"), rs.getString("cpf"), rs.getString("ctps"), rs.getString("pis"),
						rs.getString("pai"), rs.getString("mae"), rs.getDate("aso"),
						CertificadoDAO.trazerCertificados(rs.getInt("id")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return df;

	}

	public static int selecionarFK(int fk) {

		int id = 0;

		try {

			String sql = "select id from docfun where FKFuncionario = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				id = rs.getInt("id");
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return id;

	}
}
